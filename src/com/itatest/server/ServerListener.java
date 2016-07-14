package com.itatest.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerListener implements Runnable {
	
	private Socket socket;

	public ServerListener(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void chat() throws Exception {
		OutputStream out = socket.getOutputStream();
		
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		char chars[] = new char[1024];
		int len;
        StringBuilder builder = new StringBuilder();
		
		while(true){
			out.write("Input your command : \n".getBytes());
			String line = reader.readLine();
			
//			if(line.equals("Q"))
//				break;
			
			while ((len=reader.read(chars)) != -1) {
	               builder.append(new String(chars, 0, len));
	            }
			
//			System.out.println("Receive from client message=: " + builder+"\n====================");
			
			out.write(("Your Command is : \n"+line+"\n===========================================\n").getBytes());
		}
	}

	@Override
	public void run() {
		try {
			chat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
