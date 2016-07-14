package com.itatest.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static int PORT = 8888;

	public static void main(String[] args) throws Exception {
		Server server = new Server();
		System.out.println("Server Start...");
		
		server.init();

	}
	
	public void init() throws Exception{
		
		ServerSocket server = new ServerSocket(PORT);
		
		while(true){
			Socket socket = server.accept();
			new Thread(new ServerListener(socket)).start();
		}
		
		
	}

}
