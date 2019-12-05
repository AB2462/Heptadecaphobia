package com.kroy.gameworld;

import com.kroy.gameobjects.Firetruck;

public class GameWorld {
    private Firetruck truck;

    public GameWorld (int midPointY) {
    	truck = new Firetruck(100, midPointY, 76, 105);
    }

    public void update(float delta) {
        truck.update(delta);
    }

    public Firetruck getFiretruck() {
        return truck;

    }
}
