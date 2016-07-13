package com.teachercode.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataFilter {

	public static void main(String[] args) throws Exception {
//		DataOutputStream dout = new DataOutputStream(new FileOutputStream("hyman2.data"));
//		dout.write(12);
//		dout.close();

		DataInputStream din = new DataInputStream(new FileInputStream("hyman2.data"));
		int x = din.read();
		System.out.println(x);
		
	}

}
