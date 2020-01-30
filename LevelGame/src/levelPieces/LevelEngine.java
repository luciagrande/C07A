package levelPieces;

import java.util.ArrayList;
import gameEngine.Player;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelEngine {
	private Drawable[] board = new Drawable[gameEngine.GameEngine.BOARD_SIZE];
	private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
	private ArrayList<GamePiece> gamePieces= new ArrayList<GamePiece>();;
	private int playerLoc;
	
	public void createLevel(int l) {
		switch(l) {
		case 1:
			levelOne();
		}
	
	}
	
	public void levelOne() {
		Rug r1 = new Rug(11);
		Sniper s1 = new Sniper(0);
		Treasure t = new Treasure(2);
		
		board[r1.getLocation()] = r1;
		board[t.getLocation()]= t;
		board[s1.getLocation()] = s1;
		
		movingPieces.add(s1);
		gamePieces.add(t);
		gamePieces.add(s1);
	}

	public Drawable[] getBoard() {
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return gamePieces;
	}

	public int getPlayerStartLoc() {
		return (gameEngine.GameEngine.BOARD_SIZE / 2);
	}
	
	
}
