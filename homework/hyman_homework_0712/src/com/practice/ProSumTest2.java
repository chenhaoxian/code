package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ProSumTest2 {
	private static Queue<Integer> que = new LinkedList<Integer>();

	public static int QUEUE_SIZE = 10;

	public static void main(String[] args) {
		new Thread(new Producer2(que)).start();
		new Thread(new Comsumer2(que)).start();
	}
}

class Producer2 implements Runnable {
	private Queue<Integer> q;

	public Producer2(Queue<Integer> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		System.out.println("Producer start.....");
		for (int i = 0; i < 100; i++) {
			synchronized (q) {
				q.add(i);
				System.out.println("Producer " + i + "......now the queue size is : " + q.size());
				q.notify();
				if (q.size() >= ProSumTest2.QUEUE_SIZE) {
					try {
						System.out.println("Producer end" + "......now the queue size is : " + q.size());
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class Comsumer2 implements Runnable {
	private Queue<Integer> q;

	public Comsumer2(Queue<Integer> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		System.out.println("Comsumer start.....");
		for (int i = 0; i < 100; i++) {
			synchronized (q) {
				if (q.isEmpty()) {
					// q.notify();
					if (i < 99) {
						try {
							q.wait();
							System.out.println("Comsumer end=========================");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				int x = q.remove();
				System.out.println("Comsumer " + x + "......now the queue size is : " + q.size());
				q.notify();
			}
		}
	}
}
