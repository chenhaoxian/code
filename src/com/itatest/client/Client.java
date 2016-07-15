package com.itatest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket sk = new Socket("127.0.0.1", 8888);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		OutputStream out = sk.getOutputStream();
		BufferedReader readerInConsole = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String line = reader.readLine();
			System.out.println(line);
			if(line.startsWith("Your")){
				line = reader.readLine();
				System.out.println(line);
			}
			
			String command = readerInConsole.readLine();
			if(command.toUpperCase().equals("Q")){
				out.write(("bye\n").getBytes());
				break;
			}
			
			out.write((command+"\n").getBytes());
			
			System.out.println("===================================\n\n\n");
		}
		
		

	}

}
