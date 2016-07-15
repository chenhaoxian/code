package com.itatest.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;

public class HttpServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(8889);
			
			while(true){
				Socket socket = server.accept();
				OutputStream out = socket.getOutputStream();
				out.write("HTTP/1.0 200 OK\r\n".getBytes());
				out.write("Content-Type:text/html;charset=utf8\r\n".getBytes());
				out.write("\r\n".getBytes());
				InputStream in = new FileInputStream("server.html");
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				byte[] bs = new byte[in.available()];
				in.read(bs);
				out.write(bs);
				
				String line = reader.readLine();
//				System.out.println(line);
				if(line.contains("=")){
					String key = line.split("=")[1].split(" ")[0];
//					System.out.println(key);
					if("start".equals(key)){
						Server.main(null);
//						String line2 = reader.readLine();
//						System.out.println(line2);
						out.write("test".getBytes());
					}
				}
				
				
				
				
//				String resource = line.substring(line.indexOf('/'),
//				    line.lastIndexOf('/') - 5);
//				  System.out.println("the resource you request is: "
//				    + resource);
//				  resource = URLDecoder.decode(resource, "UTF-8");
				out.close();
				socket.close();
				in.close();
//				server.close();
				
//				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//				out.writeUTF("HTTP/1.0 200 OK\r\n");
//				out.writeUTF("Content-Type:text/html;charset=utf8\r\n");
//				out.writeUTF("\r\n");
//				out.writeUTF("HELLO中国");
//				out.close();
//				socket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
