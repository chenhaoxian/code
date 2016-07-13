package com.teachercode.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import sun.net.util.IPAddressUtil;

public class FileCopy2 {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("image01.png");
		BufferedInputStream bin = new BufferedInputStream(in);
		
		OutputStream out = new FileOutputStream("image02.png");
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		int m=0;
		
		while((m=in.read())!=-1){
//			out.write(buf);
			bout.write(m);
		}
		
		bin.close();
		bout.close();

	}

}
