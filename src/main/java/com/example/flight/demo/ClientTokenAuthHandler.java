package com.practice.flight.demo;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.apache.arrow.flight.auth.ClientAuthHandler;

public class ClientTokenAuthHandler implements ClientAuthHandler {
	private final byte[] authToken;
	private byte[] callToken = new byte[0];

	private ClientTokenAuthHandler(String authToken) {
		this.authToken = String.format("{\"authorization\":\"%s\"}", authToken).getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public void authenticate(ClientAuthSender outgoing, Iterator<byte[]> incoming) {
		outgoing.send(authToken);
		callToken = incoming.next();
	}

	@Override
	public byte[] getCallToken() {
		return callToken.clone();
	}

	public static ClientTokenAuthHandler build(String authToken) {
		return new ClientTokenAuthHandler(authToken);
	}
}
