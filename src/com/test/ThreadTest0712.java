package com.test;

public class ThreadTest0712 {

	public static void main(String[] args) {
		System.out.println("====================");
		MyThread myThread = new MyThread();
		new Thread(new MyRunnable()).start();
		
//		System.exit(0);//主线程结束 所有线程结束

	}

}

class MyRunnable /* extends XXX */ implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("sub thread...");
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("sub thread...");
	}
}
