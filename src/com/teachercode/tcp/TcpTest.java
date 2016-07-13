package com.teachercode.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTest {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(4444);
		Socket sk = server.accept();
		OutputStream out = sk.getOutputStream();
		
//		System.out.println(System.getenv());
		
		InputStream in = sk.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));//起到缓存 ，可以输入一串字符串
		
		out.write("input host:\n".getBytes());
		String port = reader.readLine();
		
		String value = System.getenv(port);
		out.write(value.getBytes());
//		ServerSocket server2 = new ServerSocket(Integer.parseInt(port));
//		Socket sk2 = server.accept();
//		OutputStream out2 = sk.getOutputStream();
//		System.out.println(System.getenv());
//		System.out.println(System.getenv(port));
//		System.out.println();
//		String line = null;
//		while((line=reader.readLine())!=null){
//			System.out.println(line);
//		}
		
		
//		System.out.println(line);
//		ServerSocket server2 = new ServerSocket(Integer.parseInt(line));
//		Socket sk2 = server.accept();
//		OutputStream out2 = sk.getOutputStream();
//		System.out.println(System.getenv());
		
		
		out.close();
		sk.close();
		server.close();

	}

}
