package com.mytest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Test071202 {

	public static void main(String[] args) throws Exception {
		File file = new File("test0712.txt");
		
		FileOutputStream fout = new FileOutputStream(file,true);
		
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		
		new Thread(new WriteQueue("thread1", queue));
		new Thread(new WriteQueue("thread2", queue));
		
		System.out.println(queue.size());
		

	}

}

class WriteQueue implements Runnable{
	private String value;
	
	private ConcurrentLinkedQueue<String> queue;

	public WriteQueue(String value, ConcurrentLinkedQueue<String> queue) {
		super();
		this.value = value;
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i = 0; i<10; i++){
			queue.add(value);
		}
		
	}
}