package com.itatest.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.List;

import com.teachercode.jdbc.dao.Hyman1Dao;
import com.teachercode.jdbc.dao.impl.Hyman1DaoImpl;
import com.teachercode.jdbc.po.Hyman1;

public class Server {

	public static final int PORT = 8888;// 监听的端口号
//	public static final String IP_ADDR = "localhost";//服务器地址 
	public static final int PORT2 = 8889;//服务器端口号    

	public static void main(String[] args) {
		System.out.println("Server Start...\n");
		Server server = new Server();
		server.init();
	}

	public void init() {
		try {
			Socket socket = new Socket("127.0.0.1", 8889);
			if(socket != null){
				OutputStream out = socket.getOutputStream();
				out.write("test".getBytes());
				socket.close();
			}
			
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			while (true) {
				// 一旦有堵塞, 则表示服务器与客户端获得了连接
				Socket client = serverSocket.accept();
				// 处理这次连接
				new HandlerThread(client);
			}
		} catch (Exception e) {
			System.out.println("服务器异常: " + e.getMessage());
		}
	}

	private class HandlerThread implements Runnable {
		private Socket socket;

		private Hyman1Dao dao = new Hyman1DaoImpl();

		public HandlerThread(Socket client) {
			socket = client;
			new Thread(this).start();
		}

		public void run() {
			try {
				// 读取客户端数据
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String clientInputStr = input.readUTF();
				// 处理客户端数据
				System.out.println("Client Input Command :" + clientInputStr);

				
				// 向客户端回复信息
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				String command = null;
				if (clientInputStr != null) {
					if(!clientInputStr.trim().contains(" ")){
						if("L-PA".equals(clientInputStr.toUpperCase())){
							List<Hyman1> list = dao.showAllHyman1();
							StringBuilder sb = new StringBuilder();
							for (Hyman1 hyman: list){
								sb.append(hyman.getMyname()).append("\t").append(hyman.getAge()).append("#");
							}
							out.writeUTF(sb.toString());
						}
					}

				} else {
					out.writeUTF("null");
				}

				// System.out.print("Please Input :\t");
				// 发送键盘输入的一行
				// String s = new BufferedReader(new
				// InputStreamReader(System.in)).readLine();
				// out.writeUTF(s);

				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("服务器 run 异常: " + e.getMessage());
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (Exception e) {
						socket = null;
						System.out.println("服务端 finally 异常:" + e.getMessage());
					}
				}
			}
		}
	}

}
