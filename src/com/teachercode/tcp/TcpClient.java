package com.teachercode.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class TcpClient {

	public static void main(String[] args) throws Exception {
		Socket sk = new Socket("127.0.0.1", 4444);//start connection ,need kaifan port
		BufferedReader reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		OutputStream out = sk.getOutputStream();
		
		String line = reader.readLine();
		System.out.println(line);
		out.write("fine\n".getBytes());
		
		reader.close();
		out.close();
		sk.close();

	}

}
