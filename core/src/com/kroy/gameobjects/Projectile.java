package com.kroy.gameobjects;

public class Projectile {
	
	int damage, velocity;
	boolean animate;
	GameObject target;
	int[] position;
	//image texture;
	
	public Projectile(int damage, int velocity, GameObject target, int[] position) {
		this.damage = damage;
		this.velocity = velocity;
		this.animate = false;
		this.target = target;
		this.position = position;
		//this.texture = texture;
	}
	public void draw() {
		
	}
	public void setPosition(int x, int y) {
		this.position[0] = x;
		this.position[1] = y;
	}
	public void update() {
		
	}
}
