package com.practice.chin.file.transfer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.Stream;

public class FileTransfer {

	private static void copyUsingChannel(File source, File target) throws IOException {
		try (FileChannel inputChannel = new FileInputStream(source).getChannel();
				FileChannel outputChannel = new FileOutputStream(target).getChannel();) {
			ByteBuffer buffer = ByteBuffer.allocateDirect(4 * 1024);
			while (inputChannel.read(buffer) != -1) {
				buffer.flip();
				outputChannel.write(buffer);
				buffer.clear();
			}
		}
	}

	private static void copyUsingJavaStreams(File source, File target) throws IOException {

		try {
			InputStream inputStream = new FileInputStream(source);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			FileWriter fileWriter = new FileWriter(target, true);
			PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));
			Stream<String> linesStream = bufferedReader.lines();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();

		File source = new File(System.getProperty("user.dir") + "/src/main/resources/part-00000.csv");
		File target = new File(System.getProperty("user.dir") + "/src/main/resources/part-00000-processed.csv");
		//FileTransfer.copyUsingChannel(source, target);
		FileTransfer.copyUsingJavaStreams(source, target);
		long endTime = System.currentTimeMillis();

		System.out.println(" Computation time : " + (((endTime - startTime) / 1000) / 60) + " minutes , and "
				+ ((endTime - startTime / 1000) % 60) + " Seconds");

	}

}
