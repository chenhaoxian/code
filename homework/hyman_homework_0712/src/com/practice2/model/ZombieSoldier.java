package com.practice2.model;

import com.practice2.function.AttackInterface;

public class ZombieSoldier extends Invader implements AttackInterface{
	
	private int hp;
	
	public ZombieSoldier(){}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public ZombieSoldier(int hp) {
		super();
		this.hp = hp;
	}

	@Override
	int damage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int vitality() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int speed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		
	}

}
