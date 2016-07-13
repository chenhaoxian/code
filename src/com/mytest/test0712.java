package com.mytest;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.tool.Tool;

public class test0712 {

	public static void main(String[] args) {
		new Thread(new WriteFile("A"));
		new Thread(new WriteFile("B"));
	}

}

class WriteFile implements Runnable {
	private String str;

	public WriteFile(String str) {
		super();
		this.str = str;
	}

	@Override
	public void run() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("test0712.test"));
			for (int i = 0; i < 10; i++) {
				synchronized (bw) {
					bw.write(str);
					Tool.print("input"+str);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
