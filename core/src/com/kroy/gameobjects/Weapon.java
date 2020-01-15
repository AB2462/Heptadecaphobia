package com.kroy.gameobjects;

public class Weapon {

	private int damage, firerate, range;
	private boolean animate;
	private GameObject target;
	private int[] position = new int[2];
	//private image texture;//change type
	
	public Weapon( int firerate,int range, GameObject target, int[] position) {
		this.damage = 1;
		this.firerate = firerate;
		this.range = range;
		this.animate = false;
		this.target = target;
		this.position = position;
		//this.texture = texture;
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
	public int[] getPosition() {
		return this.position;
	}
	public void setPosition(int x, int y) {
		this.position[0] = x;
		this.position[1] = y;
	}
	public void draw() {
		
	}
	public void update() {
		
	}
}
