package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


public class Missle extends GamePiece implements Moveable{
	boolean trajectory;
	public Missle(int location, boolean trajectory) {
		super('M', location);
		this.trajectory = trajectory;
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) return InteractionResult.KILL;
		else return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if(trajectory) {
			int m = 1;
			while(this.getLocation() + m <gameBoard.length && gameBoard[this.getLocation() + m] != null) m++;
			if(this.getLocation() + m >=gameBoard.length) trajectory = !trajectory;
			else {
				gameBoard[this.getLocation() +m ]= this;
				gameBoard[this.getLocation()] = null;
				this.setLocation(this.getLocation() + m);
			}
		}
		else {
			int m = 1;
			while(this.getLocation() - m >=0 && gameBoard[this.getLocation() - m] != null) m++;
			if(this.getLocation() - m <0) trajectory = !trajectory;
			else {
				gameBoard[this.getLocation() -m ]= this;
				gameBoard[this.getLocation()] = null;
				this.setLocation(this.getLocation() - m);
			}
		}
		System.out.println(this.getLocation());
		
	}

}
