package com.kroy.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import com.badlogic.gdx.Game;
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
		assertTrue(game.isWon(emptyList));
		assertFalse(game.isWon(nonemptyList));
	}
}
