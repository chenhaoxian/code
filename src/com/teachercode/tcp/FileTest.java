package com.teachercode.tcp;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File f = new File("D:\\");
		System.out.println(f.isDirectory());
		String[] fs = f.list();
		for(String s:fs){
			System.out.println(s);
		}
	}
}
