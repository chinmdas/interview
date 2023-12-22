package com.practice.flight.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.arrow.flight.AsyncPutListener;
import org.apache.arrow.flight.CallOption;
import org.apache.arrow.flight.CallOptions;
import org.apache.arrow.flight.FlightClient;
import org.apache.arrow.flight.FlightDescriptor;
import org.apache.arrow.flight.FlightEndpoint;
import org.apache.arrow.flight.FlightInfo;
import org.apache.arrow.flight.FlightStream;
import org.apache.arrow.flight.Location;
import org.apache.arrow.flight.Ticket;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;

public class FlightDemo {

	private static final CallOption CALL_OPTIONS = CallOptions.timeout(60, TimeUnit.SECONDS);
	private static final Logger LOG = Logger.getLogger(FlightDemo.class.getName());
	private static final String HOST = "flight-server-docker1.fyre.ibm.com";
	private static final int PORT = 9443;
	private final String authHeader;
	private byte[] request;

	public FlightDemo() throws IOException {

		authHeader = "Bearer " + System.getenv("ACCESS_TOKEN");
		try (InputStream is = FlightDemo.class.getResourceAsStream("/request.json")) {
			if (is == null) {
				System.out.println("request.json not found");
				throw new IOException("FileNotfound: request.json");
			}
			final ByteArrayOutputStream bos = new ByteArrayOutputStream();
			final byte[] buf = new byte[0x1000];
			int len;
			while ((len = is.read(buf)) >= 0) {
				bos.write(buf, 0, len);
			}
			request = bos.toByteArray();
		}
	}

	private int getPartitionIndex(Ticket ticket) {
		final String str = new String(ticket.getBytes(), StandardCharsets.UTF_8);
		final int colonIndex = str.indexOf(':');
		return Integer.parseInt(str.substring(colonIndex + 1));
	}

	private void runRead() throws InterruptedException, URISyntaxException {
		final AtomicInteger rowCount = new AtomicInteger();
		final Location location = Location.forGrpcTls(HOST, PORT);
		try (final BufferAllocator clientAllocator = new RootAllocator();
				final FlightClient client = FlightClient.builder(clientAllocator, location).useTls().verifyServer(false)
						.build()) {
			client.authenticate(ClientTokenAuthHandler.build(authHeader), CALL_OPTIONS);
			final FlightDescriptor descriptor = FlightDescriptor.command(request);
			final FlightInfo info = client.getInfo(descriptor, CALL_OPTIONS);
			final List<FlightEndpoint> endpoints = info.getEndpoints();
			endpoints.parallelStream().map(endpoint -> endpoint.getTicket()).forEach(ticket -> {
				final int partitionIndex = getPartitionIndex(ticket);
				try (final FlightStream stream = client.getStream(ticket, CALL_OPTIONS)) {
					int batchIdx = 0;
					while (stream.next()) {
						try (final VectorSchemaRoot root = stream.getRoot()) {
							rowCount.addAndGet(root.getRowCount());
							if (partitionIndex == 0 && batchIdx == 0) {
								System.out.println("schema:\t" + root.getSchema());
								System.out.println("columns:\t" + root.getSchema().getFields().stream()
										.map(Field::getName).collect(Collectors.joining("\t")));
							}
							final int batchRows = root.getRowCount();
							for (int rowIdx = 0; rowIdx < batchRows; rowIdx++) {
								final int idx = rowIdx;
								if (idx == 0) {
									System.out.println("data[" + partitionIndex + "][" + batchIdx + "][" + rowIdx
											+ "]:\t" + root.getFieldVectors().stream().map(vector -> {
												final Object value = vector.getObject(idx);
												if (value == null) {
													return null;
												}
												return value.toString();
											}).collect(Collectors.joining("\t")));
									break;
								}
							}
							System.out.println("Rows in batch: " + batchRows);
						}
						batchIdx++;
					}
					System.out.println("Total RowCount: " + rowCount);
				} catch (final Exception e) {
					throw new RuntimeException(e);
				}
			});
		}
	}

//	private void runWrite() throws InterruptedException, URISyntaxException {
//		final List<Field> fields = new ArrayList<>();
//		fields.add(new Field("FIRST_NAME", new FieldType(false, new ArrowType.Utf8(), null), null));
//		fields.add(new Field("LAST_NAME", new FieldType(false, new ArrowType.Utf8(), null), null));
//		fields.add(new Field("CITY", new FieldType(false, new ArrowType.Utf8(), null), null));
//		final Schema schema = new Schema(fields);
//		try (final BufferAllocator clientAllocator = new RootAllocator();
//				final FlightClient client = FlightClient.builder(clientAllocator, location).useTls().verifyServer(false)
//						.build();
//				final VectorSchemaRoot root = VectorSchemaRoot.create(schema, clientAllocator)) {
//			client.authenticate(ClientTokenAuthHandler.build(authHeader), CALL_OPTIONS);
//			final FlightClient.ClientStreamListener listener = getClient().startPut(FlightDescriptor.command(request),
//					root, new AsyncPutListener(), CALL_OPTIONS);
//			String line = reader.readLine();
//			int batchRow = 0;
//			while ((line = reader.readLine()) != null) {
//				String[] cols = line.split(",");
//				((VarCharVector) vectors[0]).setSafe(batchRow, cols[0].getBytes(StandardCharsets.UTF_8));
//				((VarCharVector) vectors[1]).setSafe(batchRow, cols[1].getBytes(StandardCharsets.UTF_8));
//				((VarCharVector) vectors[2]).setSafe(batchRow, cols[2].getBytes(StandardCharsets.UTF_8));
//				batchRow++;
//			}
//			if (batchRow > 0) {
//				root.setRowCount(batchRow);
//				LOG.log(Level.INFO, String.format("Sending batch of %d rows.", batchRow));
//				listener.putNext();
//			}
//			LOG.log(Level.INFO, String.format("Send completed."));
//			listener.completed();
//			LOG.log(Level.INFO, String.format("Wait for result."));
//			listener.getResult();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				reader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}


	public static void main(String[] args) {
		try {
			final FlightDemo demo = new FlightDemo();
			if (args.length == 0 || "read".equalsIgnoreCase(args[0])) {
				demo.runRead();
			} else {
				//demo.runWrite();
			}
		} catch (

		final Exception e) {
			e.printStackTrace();
		}
	}
}