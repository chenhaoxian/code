package com.teachercode.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectFilter {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// Stu s = new Stu("hyman",100);
		// Stu s1 = new Stu("john",20);

		 ObjectOutputStream out = new ObjectOutputStream(new
		 FileOutputStream("stu.data"));
		 for(int i =0; i<100;i++){
		 Stu s = new Stu("hyman",i);
		 out.writeObject(s);
		 }
		 out.writeObject(null);
		 out.close();

		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("stu.data"));

		Stu ss = null;
		while ((ss=(Stu) oin.readObject()) != null) {
			// out.write(buf);
//			ss = (Stu) oin.readObject();
			System.out.println(ss.getSname() + "....." + ss.getAge());
		}

	}

}

class Stu implements Serializable {

	private String sname;
	private int age;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Stu(String sname, int age) {
		super();
		this.sname = sname;
		this.age = age;
	}

}