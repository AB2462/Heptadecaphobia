package com.kroy.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.kroy.gameobjects.Firetruck;
import com.kroy.gameworld.GameWorld;

public class InputHandler implements InputProcessor {
	
	private Firetruck myTruck;
	private GameWorld myWorld;
	private int mouseX;
	private int mouseY;
	
	public InputHandler(GameWorld myWorld) {
		this.myWorld = myWorld;
		myTruck = myWorld.getFiretruck();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		if (character == 'w') {
			myTruck.moveY(true,  true);
		} else if (character == 's') {
			myTruck.moveY(true,  false);
		} else if (character == 'd') {
			myTruck.moveX(true,  true);
		} else if (character == 'a') {
			myTruck.moveX(true,  false);
		}
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (myWorld.isReady()) {
			myWorld.start();
		} else if (myWorld.isRunning()) {
			mouseX = Gdx.input.getX();
			mouseY = Gdx.input.getY();
			myTruck.onClick(mouseX, mouseY);
		}

		if (myWorld.isGameOver()) {
			myWorld.restart();
		}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
