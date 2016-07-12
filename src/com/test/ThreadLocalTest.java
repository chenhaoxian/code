package com.test;

public class ThreadLocalTest {

	public static ThreadLocal<Integer> mainT ;
	
//	public static ThreadLocal<Integer> subT ;
	
	public static void main(String[] args) throws InterruptedException {
//		final ThreadLocal<Integer> mainT = new ThreadLocal<Integer>();
		mainT = new ThreadLocal<Integer>();
		mainT.set(100);
		System.out.println(mainT.get());
		
		new Thread(){
			public void run(){
//				int x = mainT.get();
//				subT = new ThreadLocal<Integer>();
//				subT.set(200);
				mainT.set(300);
				System.out.println("sub....."+mainT.get());
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("sub....."+mainT.get());
			};
		}.start();
		Thread.sleep(1000);
		System.out.println(mainT.get());
//		System.out.println(subT.get());

	}

}
