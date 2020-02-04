package levelPieces;

import gameEngine.Drawable;
import java.util.Random;

import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Sniper extends GamePiece implements Moveable{

	public Sniper(int location) {
		super('S', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (Math.abs(this.getLocation() - playerLocation) <=1) {
			return InteractionResult.KILL;
		}
		return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		Random rand = new Random();
		int m = rand.nextInt() % 3;
		if(m+this.getLocation()<0)m=0;
		while(gameBoard[(this.getLocation()+m)%gameBoard.length]!= null) m++;
		gameBoard[(this.getLocation()+m)%gameBoard.length] = this;
		gameBoard[this.getLocation()] = null;
		this.setLocation((this.getLocation()+m)%gameBoard.length);
	}

}
