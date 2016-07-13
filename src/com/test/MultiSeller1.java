package com.test;

public class MultiSeller1 {

	public static void main(String[] args) {
		
		Ticket1[] tickets = new Ticket1[100];
		
		for(int i=0; i<tickets.length;i++){
			tickets[i] = new Ticket1(i);
		}
		
		

	}

}

class Seller1 implements Runnable{
	private Ticket1[] tickets;
	
	public Seller1(Ticket1[] tickets) {
		super();
		this.tickets = tickets;
	}


	@Override
	public void run() {
		for(int i=0; i<tickets.length; i++){
			synchronized (tickets) {
				Ticket1 t = tickets[i];
			}
		}
		
	}
}

class Ticket1{
	private int id;
	private boolean sold;
	public Ticket1(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
}
