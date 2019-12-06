package com.kroy.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.badlogic.gdx.Game;

import org.junit.Test;


public class GameTest {
	/**
	 * @Test isWon()
	 */
	@Test
	public void testIsWon() {
		KroyGame game = new KroyGame();
		assertEquals(game.getTest(),3);
		
	}
}
