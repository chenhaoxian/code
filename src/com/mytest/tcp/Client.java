package com.mytest.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static String HOST = "127.0.0.1";
	private static int PORT = 5555;

	public static void main(String[] args) {
		System.out.println("客户端启动...");
		System.out.println("当客户端输入为OK时，客户端终止！  	");

		while (true) {
			Socket socket = null;

			try {
				// 创建一个流套接字并将其连接到指定主机上的指定端口号
				socket = new Socket(HOST, PORT);

				InputStream inputFromServer = socket.getInputStream();
				BufferedReader serverInput = new BufferedReader(new InputStreamReader(inputFromServer));

				OutputStream out = socket.getOutputStream();
				out.write("请输入： ".getBytes());

				String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
				out.write(str.getBytes());

				String serverResult = serverInput.readLine();
				System.out.println("服务器返回信息是：  " + serverResult);

				if ("OK".equals(serverResult)) {
					System.out.println("客户端将关闭连接");
					break;
				}

				out.close();
				serverInput.close();
				inputFromServer.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						socket = null;
						System.out.println("客户端 finally 异常:" + e.getMessage());
					}
				}
			}
		}

	}

}
