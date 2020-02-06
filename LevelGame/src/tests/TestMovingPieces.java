package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.GamePiece;
import levelPieces.Missile;
import levelPieces.Rug;
import levelPieces.Sniper;
import levelPieces.Vest;

public class TestMovingPieces {

	@Test
	public void testSniperMove() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Rug(i);
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Rug(i);
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Rug(i);
		
		Sniper sniper = new Sniper(6);
		gameBoard[6] = sniper;
		
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		
		for (int i=0; i<200; i++) {
			sniper.move(gameBoard, 13);
			int loc = sniper.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 13 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		
		assert(count0 > 1);
		assert(count6 > 1);
		assert(count12 > 1);
		assert(count20 > 1);
	}
	
	@Test
	public void testMissileMove() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Rug(i);
		
	
		Vest v1 = new Vest(7);
		gameBoard[7] = v1;
		
		for (int i=8; i<=11; i++)
			gameBoard[i] = new Rug(i);
		
		Vest v2 = new Vest(14);
		gameBoard[14] = v2;
		
		for (int i=15; i<20; i++)
			gameBoard[i] = new Rug(i);
		
		//add the vest to pieces arraylist
		ArrayList <GamePiece> pieces= new ArrayList<GamePiece>();
		pieces.add(v1);
		pieces.add(v2);
		
		
		Missile m = new Missile(0, false);
		gameBoard[0] = m;
		m.setInteractable(pieces);
		

		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		
		for (int i=0; i<200; i++) {
			m.move(gameBoard, 13);
			int loc = m.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 7 && loc != 12 && loc != 13 && loc != 14 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		
	
		assert(count6 > 1);
		assert(count12 > 1);
		assert(count20 > 1);
	}


}
