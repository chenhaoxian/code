package com.teachercode.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import sun.net.util.IPAddressUtil;

public class FileCopy {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("image01.png");
		OutputStream out = new FileOutputStream("image02.png");
		
		int m=0;
		byte[] buf = new byte[4]; //开缓存 减少IO操作
		
		while((m=in.read(buf))!=-1){
//			out.write(buf);
			out.write(buf,0,m);
		}
		
		
		
		in.close();
		out.close();

	}

}
