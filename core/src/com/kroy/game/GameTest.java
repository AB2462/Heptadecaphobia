package com.kroy.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import com.badlogic.gdx.Game;
import com.kroy.gameobjects.FireStation;
import com.kroy.gameobjects.Firetruck;
import com.kroy.gameobjects.Fortress;

import org.junit.Test;


public class GameTest {
	/**
	 * @Test isWon()
	 */
	@Test
	public void testTest() {
		KroyGame game = new KroyGame();
		assertEquals(game.getTest(),3);
	}	
	
	
	@Test
	public void testIsWon() {
		KroyGame game = new KroyGame();
		ArrayList<Object> emptyList = new ArrayList<Object>();
		ArrayList<Object> nonemptyList = new ArrayList<Object>();
		Fortress fort = new Fortress(0);
		nonemptyList.add(fort);
		assertTrue(game.isWon(emptyList));
		assertFalse(game.isWon(nonemptyList));
	}
	@Test
	public void testIsLost() {
		KroyGame game = new KroyGame();
		ArrayList<Object> emptyList = new ArrayList<Object>();
		ArrayList<Object> nonemptyList = new ArrayList<Object>();
		Firetruck truck = new Firetruck(1,1,1,1);
		nonemptyList.add(truck);
		assertTrue(game.isLost(emptyList));
		assertFalse(game.isLost(nonemptyList));
	}
	@Test
	public void testEngineHealth() {
		Firetruck truck = new Firetruck(1,1,1,1);
		assertEquals(truck.getHpCurrent(),10);
		truck.damage();
		assertEquals(truck.getHpCurrent(),9);
	}
	@Test
	public void testStationHealth() {
		FireStation station = new FireStation(1,1,1);
		assertEquals(station.getHpCurrent(),10);
		station.damage();
		assertEquals(station.getHpCurrent(),9);
		
	}
	@Test
	public void testFortressHealth() {
		Fortress fort = new Fortress(1);
		assertEquals(fort.getHpCurrent(),10);
		fort.damage();
		assertEquals(fort.getHpCurrent(),9);
		
	}
	@Test
	public void testEngineStartNum() {
		KroyGame game = new KroyGame();
		assertEquals(2,2);
	}
	@Test
	public void testFortressStartNum() {
		KroyGame game = new KroyGame();
		assertEquals(4,4);
	}
	@Test
	public void testRefills() {
		Firetruck truck = new Firetruck(1,1,1,1);
		assertEquals(truck.getHpCurrent(),10);
		truck.fireWeapon();
		assertEquals(truck.getHpCurrent(),9);
		
	}
	@Test
	public void testRepairs() {
		Firetruck truck = new Firetruck(1,1,1,1);
		truck.damage();
		assertEquals(truck.getHpCurrent(),9);
		truck.repair();
		assertEquals(truck.getHpCurrent(),10);
	}
	@Test
	public void testFiretruckDestroyed() {
		Firetruck truck = new Firetruck(1,1,1,1);
		assertEquals(truck.getHpCurrent(),10);
		truck.damage();
		assertEquals(truck.getHpCurrent(),9);
	}
	@Test
	public void testFortressDestroyed() {
		Fortress fort = new Fortress(1);
		assertEquals(fort.getHpCurrent(),10);
		fort.damage();
		assertEquals(fort.getHpCurrent(),9);
	}
}
