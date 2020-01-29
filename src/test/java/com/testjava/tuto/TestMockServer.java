package com.testjava.tuto;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;

import org.mockserver.integration.ClientAndServer;

public class TestMockServer {
	
	public static ClientAndServer mockServer;
	private static int port = 1088;
	
	public static ClientAndServer createMockServer() {
		mockServer = startClientAndServer(port);
		return mockServer;
	}
	
	public void stopMockServer() {
		mockServer.stop();
	}
}
