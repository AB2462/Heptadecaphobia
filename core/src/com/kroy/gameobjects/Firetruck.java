package com.kroy.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Firetruck extends GameObject{

	private Vector2 position;
    private Vector2 velocity;

    private float rotation;
    private int width;
    private int height;
    private int goalX;
    private int goalY;
    private boolean isHit = false;
    
    private boolean startMove;
    private boolean notDestroyed;
    private Weapon firehose= new Weapon(1,3,10);
    
    public Firetruck(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(45, 45);
        this.velocity = new Vector2(0, 0);
        this.startMove = false;
        this.notDestroyed = false;
    }

    public void update(float delta) {
		if (this.position.x%45!=0 || this.position.y%45 != 0 || this.startMove) {
			this.position.add(this.velocity);
		} else {
			this.velocity.x = 0;
			this.velocity.y = 0;
		}
		this.startMove = false;
    }
    
    public void moveX(boolean moving, boolean right) {
    	if (moving) {
    		if (right) {
        		this.velocity.x = 5;
        		this.rotation = 90;
        	} else {
        		this.velocity.x = -5;
        		this.rotation = 270;
        	}
    	} else {
    		this.velocity.x = 0;
    	}
    	if (this.position.x%45!=0 || moving) {
    		this.position.add(this.velocity);
    		moving = false;
    		this.startMove = false;
    	}
    }
    
    public void moveY(boolean moving, boolean up) {
    	if (moving) {
    		if (up) {
    			this.velocity.y = -5;
        		this.rotation = 0;
        	} else {
        		this.velocity.y = 5;
        		this.rotation = 180;
        	}
    	} else {
    		this.velocity.y = 0;
    	}
    	if (this.position.y%45!=0 || moving) {
    		this.position.add(this.velocity);
    		moving = false;
    		this.startMove = false;
    	}
    }

    public void onClick(int mouseX, int mouseY) {
    	this.goalX = mouseX;
    	this.goalY = mouseY;
    	this.startMove = true;
    }

    public float getX() {
        return this.position.x;
    }

    public float getY() {
        return this.position.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getRotation() {
        return this.rotation;
    }
    
    public boolean notDestroyed() {
    	return this.notDestroyed;
    }
    
    public void onRestart() {
    	this.rotation = 0;
    	this.position.y = 45;
    	this.position.x = 45;
    	this.velocity.y = 0;
    	this.velocity.x = 0;
    	this.notDestroyed = false;
    }
    
    public void refill() {
    	this.firehose.setNumProjectiles(10);
    }
    
    public void repair() {
    	this.hpCurrent = this.hpMax;
    }
    
    public void fireWeapon() {
    	this.firehose.fire();
    }
}