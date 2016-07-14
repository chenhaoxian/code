package com.mytest.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static int PORT = 5555;

	public static void main(String[] args) {
		
		Server server = new Server();
		
		System.out.println("Server start...");
		
		server.init();
	}
	
	public void init(){
		try {
			ServerSocket server = new ServerSocket(PORT);
			
			while(true){
				Socket client = server.accept();
				new HandlerThread(client);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class HandlerThread implements Runnable{
	private Socket cilent;
	
	public HandlerThread(Socket cilent) {
		super();
		this.cilent = cilent;
		new Thread(this).start();
	}

	@Override
	public void run() {
		String clientInput = null;
		String inputLine = null;
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(cilent.getInputStream())); //读取客户端输入
			clientInput = reader.readLine();
			
			System.out.println("客户端发来的内容： \n "+clientInput);
			
			OutputStream out = cilent.getOutputStream();// 向客户端发出数据
			System.out.println("请输入：  \n");
			inputLine = new BufferedReader(new InputStreamReader(System.in)).readLine();
			out.write(inputLine.getBytes());
			
			out.close();
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
