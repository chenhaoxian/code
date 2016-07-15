package com.itatest.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.teachercode.jdbc.dao.Hyman1Dao;
import com.teachercode.jdbc.dao.impl.Hyman1DaoImpl;
import com.teachercode.jdbc.po.Hyman1;
import com.teachercode.jdbc.util.DbUtil;

public class ServerListener implements Runnable {

	private Hyman1Dao dao = null;
	
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

		while (true) {
			out.write("Input your command : \n".getBytes());
			String line = reader.readLine();

			if (line.equals("Q"))
				break;
			// while ((len=reader.read(chars)) != -1) {
			// builder.append(new String(chars, 0, len));
			// }
			// System.out.println("Receive from client message=: " +
			// builder+"\n====================");
			
			
			if(line.trim().split("\\s+").length == 2){
				dao = new Hyman1DaoImpl();
				String command = line.trim().split("\\s+")[0];
				String value = line.trim().split("\\s+")[1];
				
				if("A-P".equals(command)){
					String name = value.split(",")[0].split(":")[1];
					String age = value.split(",")[1].split(":")[1];
					int ageInt = Integer.parseInt(age);
					Hyman1 hyman = new Hyman1(name, ageInt);
					dao.addHyman1(hyman);
					out.write(("Your Command is success!:" + "\n").getBytes());
				}else if("L-PA".equals(command)){
					List<Hyman1> list = dao.showAllHyman1();
					out.write("Your result is ".getBytes());
					for(Hyman1 hyman:list){
						out.write((""+hyman.getMyname()+"   "+hyman.getAge() + "\n").getBytes());
					}
				}
				
				else {
					out.write(("Your Command is error!:" + "\n").getBytes());
				}
				
				
			}else{
				out.write(("Your command is error :" + "\n").getBytes());
			}

//			out.write(("Your Command is :   " + line + "\n").getBytes());
			
//			out.write("===========================================\n".getBytes());
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
