package com.teachercode.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class CharReaderTest {

	public static void main(String[] args) throws Exception {
		Reader r = new FileReader("char.txt");
		char c = (char) r.read();
		System.out.println(c);
		
		BufferedReader r1 = new BufferedReader(new FileReader("hyman3.txt"));
		String line = null;
		while((line=r1.readLine()) != null){
			System.out.println(line);
		}
		
		BufferedReader r2 = new BufferedReader(new InputStreamReader(System.in));
		String line2 = r2.readLine();
		System.out.println(line2+"..........");
		

	}

}
