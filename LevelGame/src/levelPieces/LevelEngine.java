package levelPieces;

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelEngine {
	private Drawable[] board = new Drawable[gameEngine.GameEngine.BOARD_SIZE];
	private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
	private ArrayList<GamePiece> gamePieces= new ArrayList<GamePiece>();;
	
	public void createLevel(int l) {
		switch(l) {
		case 1:
			levelOne();
			break;
		case 2:
			resetLevel();
			levelTwo();
			break;
		case 3:
			resetLevel();
			levelThree();
			break;
		}
		
	
	}
	
	public void levelOne() {
		Rug r1 = new Rug(11);
		Sniper s1 = new Sniper(0);
		Treasure t = new Treasure(2);
		Missile m = new Missile(3, true);
		Vest v = new Vest(7);
		Door d = new Door (15);
		
		m.setInteractable(gamePieces);
		
		board[r1.getLocation()] = r1;
		board[t.getLocation()]= t;
		board[s1.getLocation()] = s1;
		board[m.getLocation()]=m;
		board[v.getLocation()]=v;
		board[d.getLocation()]=d;
		
		movingPieces.add(s1);
		movingPieces.add(m);
		
		gamePieces.add(t);
		gamePieces.add(s1);
		gamePieces.add(m);
		gamePieces.add(v);
		gamePieces.add(d);
	}
	
	public void levelTwo() {
		Rug r1 = new Rug(11);
		Sniper s1 = new Sniper(15);
		Treasure t = new Treasure(20);
		Door d = new Door (3);
		
		
		board[r1.getLocation()] = r1;
		board[t.getLocation()]= t;
		board[s1.getLocation()] = s1;
		board[d.getLocation()]=d;
		
		movingPieces.add(s1);
		gamePieces.add(t);
		gamePieces.add(s1);
		gamePieces.add(d);
	}
	
	public void levelThree() {
		Rug r1 = new Rug(0);
		Sniper s1 = new Sniper(5);
		Treasure t = new Treasure(2);
		Missile m = new Missile(19, false);
		Door d = new Door (1);
		
		
		board[r1.getLocation()] = r1;
		board[t.getLocation()]= t;
		board[s1.getLocation()] = s1;
		board[m.getLocation()]=m;
		board[d.getLocation()]=d;
		
		movingPieces.add(s1);
		movingPieces.add(m);
		gamePieces.add(t);
		gamePieces.add(s1);
		gamePieces.add(m);
		gamePieces.add(d);
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
	
	public void resetLevel() {
		for(int i=0; i<board.length; i++) {
			board[i]=null;
		}
		movingPieces.clear();
		gamePieces.clear();
	}
	
}
