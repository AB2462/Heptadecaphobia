package com.kroy.gameobjects;
import java.util.ArrayList;

public class Projectile {
	
	int damage, velocity;
	boolean animate;
	GameObject target;
	ArrayList<Integer> position;
	//image texture;
	
	public Projectile(int damage, int velocity, GameObject target, ArrayList<Integer> position) {
		this.damage = damage;
		this.velocity = velocity;
		this.animate = false;
		this.target = target;
		this.position = position;
		//this.texture = texture;
	}
	public void draw() {
		
	}
	public void update() {
		
	}
	public ArrayList<Integer> getPosition() {
		return this.position;
	}
}
