package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Player;
import levelPieces.Door;
import levelPieces.Missile;
import levelPieces.Sniper;
import levelPieces.Treasure;
import levelPieces.Vest;

public class TestInteractions {

	
	@Test
	public void testMissile() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Missile m = new Missile(10, true);
		gameBoard[10] = m;
		// Hit points if player on same space
		assertEquals(InteractionResult.KILL, m.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, m.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, m.interact(gameBoard, i));
	}
	
	@Test
	public void testVest() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Vest v = new Vest(10);
		gameBoard[10] = v;
		// Hit points if player on same space
		assertEquals(InteractionResult.PROTECT, v.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, v.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, v.interact(gameBoard, i));
	}
	
	@Test
	public void testSniper() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Sniper s = new Sniper(10);
		gameBoard[10] = s;
		// Hit points if player on same space
		for(int i =0; i<5; i++) {
		assertEquals(InteractionResult.SNIPE, s.interact(gameBoard, 8+i));
		}
		// These loops ensure no interaction if not on same space
		for (int i=0; i<8; i++)
			assertEquals(InteractionResult.NONE, s.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, s.interact(gameBoard, i));
	}
	
	@Test
	public void testDoor() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Door d = new Door(10);
		gameBoard[10] = d;
		// Hit points if player on same space
		assertEquals(InteractionResult.ADVANCE, d.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, d.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, d.interact(gameBoard, i));
	}
	
	@Test
	public void testTreasure() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Treasure t = new Treasure(10);
		gameBoard[10] = t;
		// Hit points if player on same space
		assertEquals(InteractionResult.GET_POINT, t.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, t.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, t.interact(gameBoard, i));
	}
	

}
