package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) {
//		ExecutorService pool1 = Executors.newFixedThreadPool(2);
//		pool1.execute(new MyRun("hyman1"));
//		pool1.execute(new MyRun("hyman2"));
//		pool1.execute(new MyRun("hyman3"));
		
		ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(2);
		pool2.scheduleAtFixedRate(new YourRun(), 5,2, TimeUnit.SECONDS);

	}

}

class YourRun implements Runnable{
	@Override
	public void run() {
		System.out.println("working.......");
		
	}
}

class MyRun implements Runnable{
	private String name;
	
	
	
	public MyRun(String name) {
		super();
		this.name = name;
	}



	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name+".....runing");
		}
		
	}
}