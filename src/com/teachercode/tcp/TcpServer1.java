package com.teachercode.tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer1 {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(4444);

		while(true){
			Socket sk = server.accept();
			new Thread(new Chater1(sk)).start();
		}
//		server.close();
	}
}

class Chater1 implements Runnable {
	private Socket sk;
	
	public Chater1(Socket sk) {
		super();
		this.sk = sk;
	}

	public void chat() throws Exception{
//		Socket sk = socket.accept();
		OutputStream out = sk.getOutputStream();

		InputStream in = sk.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));// 起到缓存
																																					// ，可以输入一串字符串

		while (true) {

			out.write("input host?\n".getBytes());

			// System.out.println("finish......");
			String line = reader.readLine();

			// System.out.println(line);
			if (line.equals("bye"))
				break;
			out.write((System.getenv()+"\n").getBytes());
		}

		out.close();
		sk.close();
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
