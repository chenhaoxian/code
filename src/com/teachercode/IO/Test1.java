package com.teachercode.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.tool.Tool;

public class Test1 {

	public static void main(String[] args) throws Exception {
//		OutputStream fout = null;
//		try {
//			fout = new FileOutputStream("hymantest1.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		fout.write(97);
//		fout.write(98);
//		fout.write("中".getBytes());
//		fout.close();
		
		InputStream in = new FileInputStream("hymantest1.txt");
		//获取文件长度
		int len = in.available();
//		int a = in.read();
		byte[] bs = new byte[len];
		in.read(bs);
//		System.out.println(a);
//		for(int i=0;i<bs.length;i++){
//			System.out.println(bs[i]);
//		}
		String s = new String(bs,"utf8");
		System.out.println(s);

	}

}
