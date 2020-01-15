package com.kroy.gameworld;

import com.kroy.gameobjects.Firetruck;

public class GameWorld {
    private Firetruck truck;
    private GameState currentState;
    
    public enum GameState {

        READY, RUNNING, GAMEOVER

    }

    public GameWorld (int midPointY) {
    	truck = new Firetruck(100, midPointY, 76, 105);
    	currentState = GameState.READY;
    }

    public void update(float delta) {
    	switch (currentState) {
    	case READY:
    		updateReady(delta);
    		break;
    	
    	case RUNNING:
    		updateRunning(delta);
    		break;
    	}
    }

    private void updateRunning(float delta) {
        truck.update(delta);
	}

	private void updateReady(float delta) {
		// TODO Auto-generated method stub
		
	}

	public Firetruck getFiretruck() {
        return truck;

    }
    
    public boolean isReady() {
    	return currentState == GameState.READY;
    }
    
    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        truck.onRestart();
        currentState = GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
}
