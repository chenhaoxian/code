package com.mytest.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(4444);
		
	}
}

class Server1 implements Runnable{
	private Socket socket;
	
	
	public Server1(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void chat() throws Exception{
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		while(true){
			out.write("input your key:\n".getBytes());
			String line = reader.readLine();
			
			
			
			
		}
		
		
	}


	@Override
	public void run() {
		
		
	}
}
