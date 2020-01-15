package com.kroy.gameobjects;
import java.util.ArrayList;
import java.awt.Image;
import java.lang.Math;

public abstract class GameObject {
	
	protected ArrayList<Integer> position;
	protected int hpMax;
	protected int hpCurrent = 10;
	protected ArrayList<Image> texture;

	protected int damage =1;
	public abstract void Draw();
	public abstract void Update();


	public ArrayList<Integer> getPosition(){
		return this.position;
	};

	public int getHpMax(){
		return this.hpMax;
	};

	public int getHpCurrent() {
		return this.hpCurrent;
	};

	public boolean damage() {
		if (damage > this.hpCurrent) {
			this.hpCurrent = 0;
			return true;
		}
		this.hpCurrent = this.hpCurrent - damage;
		return false;
	};

	protected double getAngleTo(GameObject target) {
		ArrayList<Integer> tPos = target.getPosition();
		int dX = tPos.get(0) - this.position.get(0);
		int dY = tPos.get(1) - this.position.get(1);
		double angle = Math.atan2(dY, dX);
		return angle;
	};

	protected double getDistanceTo(GameObject target) {
		ArrayList<Integer> tPos = target.getPosition();
		int dX = tPos.get(0) - this.position.get(0);
		int dY = tPos.get(1) - this.position.get(1);
		double distance = Math.pow(Math.pow(dX, 2) + Math.pow(dY, 2), 0.5);
		return distance;
	};
}