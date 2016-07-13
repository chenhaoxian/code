package com.teachercode.code0713.test03;

public class Avata extends Intellegor {
	
	private Intellegor p;
	

	public Avata(Intellegor p) {
		super();
		this.p = p;
	}



	@Override
	public void run() {
		System.out.println("avata run.......");
		p.run();

	}
	
	public static void main(String[] args){
		Intellegor p = new Persom();
		Intellegor a = new Avata(p);
		a.run();
	}

}
