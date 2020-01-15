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
    private Weapon firehose= new Weapon(1,3,10);
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

    	move(delta);

    }
    public void refill() {
    	this.firehose.setNumProjectiles(10);
    }
    public void repair() {
    	this.hpCurrent = this.hpMax;
    }
    public void move(float delta) {
    	if (this.startMove) {
    		if (this.position.x > this.goalX) {
    		    this.acceleration.x = -10;
    		} else {
    		    this.acceleration.x = 10;
    		}
    		if (this.position.y > this.goalY) {
    		    this.acceleration.y = -10;
    		} else {
    			this.acceleration.y = 10;
    		}

    		double moveX = this.goalX - this.position.x; // Calculate how far truck has to go in x
    		double moveY = this.goalY - this.position.y; // Calculate how far truck has to go in y  
    		//double distance = Math.sqrt(moveX * moveX + moveY * moveY); // Work out overall distance to goal position

    		double travelX = this.position.x + this.velocity.x; // Work out how far it will go in x
    		double travelY = this.position.y + this.velocity.y; // Work out how far it will go in y
    		//double distanceTravel = Math.sqrt(travelX * travelX + travelY * travelY); // Work out how far it will go next update overall
    		       
    		if (travelX > moveX) {
    			this.position.x = this.goalX;
		        this.velocity.x = 0;
		        this.acceleration.x = 0;
		        Gdx.app.log("Done Move X", "Complete XXXXXXXXXXXXXXXXXXXXXXXXXX");
    		}
    		if (travelY > moveY) {
    			this.position.y = this.goalY;
		        this.velocity.y = 0;
		        this.acceleration.y = 0;
		        Gdx.app.log("Done Move Y", "Complete yyyyyyyyyyyyyyyyyyyyyyyyyy");
    		}
    		
    		Gdx.app.log("move",  "--------------------------------------------");
    	    Gdx.app.log("initial", (this.position.toString() + this.goalX + " " + this.goalY + this.velocity.toString() + this.acceleration.toString()) );
    	    if (this.position.x != this.goalX) {
    	    	this.velocity.x += this.acceleration.x;
    	    }
    	    if (this.position.y != this.goalY) {
    	    	this.velocity.y += this.acceleration.y;
    	    }
    	       
	        if (this.velocity.y > 50) { // Make sure velocity isn't too high in y
	        	this.velocity.y = 50;
            } else if (this.velocity.y < -50) {
	            this.velocity.y = -50;
            }
	        if (this.velocity.x > 50) { // Make sure velocity isn't too high in x
	        	this.velocity.x = 50;
            } else if (this.velocity.x < -50) {
	            this.velocity.x = -50;
            }
	       
	        this.position.add(this.velocity.cpy().scl(delta)); // Update the position, scaled by fps
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