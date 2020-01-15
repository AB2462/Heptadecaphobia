package com.kroy.gameobjects;

import java.util.ArrayList;

public class Weapon {

	private int damage, firerate, range;
	private boolean animate;
	private ArrayList<Integer> position = new ArrayList<Integer>();
	private int numProjectiles;
	//private image texture;//change type
	
	public Weapon( int firerate,int range, int numProjectiles) {
		this.damage = 1;
		this.firerate = firerate;
		this.range = range;
		this.animate = false;

		this.numProjectiles = numProjectiles;
		//this.texture = texture;
	}
	public void fire() {
		this.numProjectiles -=1;
	}
	public int getDamage() {
		return this.damage;
	}
	public int getFirerate() {
		return this.firerate;
	}
	public int getRange() {
		return this.range;
	}


	public void draw() {
		
	}
	public void update() {
		
	}
	public void setNumProjectiles(int numProjectiles) {
		this.numProjectiles = numProjectiles;
	}
}
