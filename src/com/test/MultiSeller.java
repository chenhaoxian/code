package com.test;

import jdk.jfr.events.ThrowablesEvent;

public class MultiSeller {

	public static void main(String[] args) {
		Ticket[] tickets = new Ticket[100];

		for (int i = 0; i < tickets.length; i++) {
			tickets[i] = new Ticket(i);
		}

		new Thread(new Seller(tickets)).start();
		new Thread(new Seller(tickets)).start();
		new Thread(new Seller(tickets)).start();
		new Thread(new Seller(tickets)).start();
	}

}

class Seller implements Runnable {
	private Ticket[] pool;
	// c+s+f

	@Override
	public void run() {
		for (int i = 0; i < pool.length; i++) {
			
			synchronized (pool) {
				Ticket t = pool[i];
				if (!t.isSold()) {
					t.setSold(true);
					System.out.println(Thread.currentThread().getName() + "..........." + t.getNum());
				}
			}
			sleep(6);
		}
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Seller(Ticket[] pool) {
		super();
		this.pool = pool;
	}
}

class Ticket {
	private int num;
	private boolean sold;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public Ticket(int num) {
		super();
		this.num = num;
		this.sold = false;
	}
}