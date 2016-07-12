package com.test;

import java.util.LinkedList;
import java.util.Queue;

public class ProSumTest {
	private static Queue<Integer> que = new LinkedList<Integer>();

	public static void main(String[] args) {
		
		new Thread(new Producer(que)).start();
		new Thread(new Comsumer(que)).start();

	}

}

class Producer implements Runnable {
	private Queue<Integer> q;

	public Producer(Queue<Integer> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		System.out.println("Producer start.....");
		for (int i = 0; i < 100; i++) {
			synchronized (q) {
				q.add(i);
				System.out.println("Producer ....." + i);
				// 利用说对象唤醒其他
				q.notify();
				try {
					q.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
}

class Comsumer implements Runnable {
	private Queue<Integer> q;

	public Comsumer(Queue<Integer> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		System.out.println("Comsumer start.....");
		for (int i = 0; i < 100; i++) {
			synchronized (q) {
				if (q.isEmpty()) {
					try {
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				int x = q.remove();
				System.out.println("Comsumer ....." + x);
				q.notify();
				
			}

		}

	}
}
