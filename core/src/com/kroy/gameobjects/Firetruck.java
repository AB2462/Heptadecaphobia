package com.kroy.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Firetruck extends GameObject{

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;
    private int goalX;
    private int goalY;
    private boolean isHit = false;
    
    private boolean startMove;
    private boolean notDestroyed;

    public Firetruck(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(50, 50);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
        this.startMove = false;
        this.notDestroyed = false;
        
    }

    public void update(float delta) {
    	move();
    	if (isHit) {
    		damage();
    	}
    }
    
    public void move() {
    	if (this.startMove) {
	    	float xdif = this.goalX - this.position.x;
	    	float ydif = this.goalY - this.position.y;
	    	float dx = 0;
	    	float dy = 0;
	    	
	    	if (this.position.x != this.goalX) {
	    		dx = xdif / this.velocity.x;
	    	} else {
	    		dx = 0;
	    	}
	    	if (this.position.y != this.goalY) {
	    		dy = ydif / this.velocity.y;
	    	} else {
	    		dy = 0;
	    	}
	    	
	    	if (this.position.x == this.goalX && this.position.y == this.goalY) {
	    		this.startMove = false;
	    	}
	    	
	    	this.position.x += dx;
	    	this.position.y += dy;
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
    	this.position.y = 50;
    	this.position.x = 50;
    	this.velocity.y = 0;
    	this.velocity.x = 0;
    	this.acceleration.y = 0;
    	this.acceleration.x = 0;
    	this.notDestroyed = false;
    }
}