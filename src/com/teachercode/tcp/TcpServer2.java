package com.teachercode.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(5555);

	}

}

class ChatServer2 implements Runnable{
	private Socket socket;

	public ChatServer2(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void chat() throws Exception{
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		while(true){
			out.write("input : \n".getBytes());
			
		}
	}
	
	@Override
	public void run() {
		
		
		
	}
	
	
}
