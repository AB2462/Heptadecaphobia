package com.kroy.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.kroy.helpers.AssetLoader;
import com.kroy.screens.GameScreen;

public class KroyGame extends Game {
	
	/*/int state;
	Screen screen = new Screen();
	EventListener eventListener = new EventListener();
	Map map = new Map();
	FireStation fireStation = new FireStation(0, 0, 0);
	ArrayList<Object> patrolList = new ArrayList<Object>();
	ArrayList<Object> truckList = new ArrayList<Object>();
	ArrayList<Object> fortressList = new ArrayList<Object>();
	/*/
	@Override
	public void create() {
		Gdx.app.log("Game", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
		
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
	
	public static boolean isWon() {
		/*/
		if (fortressList.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		/*/
		return false;
	}
	/*/
	public static FireTruck generateFireTruck() {
		FireTruck newTruck = new FireTruck(0, 0);
		return newTruck;
	}
	
	public static Patrol spawnPatrol() {
		Patrol newPatrol = new Patrol(0);
		return newPatrol;
	}
	
	public static Fortress generateFortress() {
		Fortress newFortress = new Fortress(0);
		return newFortress;
	}
	/*/
}
