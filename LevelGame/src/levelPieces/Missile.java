//Authors: Liam Morrissey and Lucy Grande
package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.ArrayList;



public class Missile extends GamePiece implements Moveable{
	boolean trajectory;
	private static ArrayList<GamePiece> pieces;
	public Missile(int location, boolean trajectory) {
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
		//bounces back and forth across the game board
		if(trajectory) {
			int m = 1;
			while(this.getLocation() + m <gameBoard.length && gameBoard[this.getLocation() + m] != null && gameBoard[this.getLocation() + m].getClass() != Vest.class ) m++;
			if(this.getLocation() + m >=gameBoard.length) trajectory = !trajectory; 
			else {
				if(gameBoard[this.getLocation() + m] != null) {
					//gets rid of vest if it hits it
					pieces.remove(gameBoard[this.getLocation() + m]);
				}

				gameBoard[this.getLocation() +m ]= this;
				gameBoard[this.getLocation()] = null;
				this.setLocation(this.getLocation() + m);

			}
		}
		else {
			int m = 1;
			while(this.getLocation() - m >=0 && gameBoard[this.getLocation() - m] != null && gameBoard[this.getLocation() - m].getClass() != Vest.class) m++;
			if(this.getLocation() - m <0) trajectory = !trajectory;
			else {
				if(gameBoard[this.getLocation() -m] != null) {
					//gets rid of vest if it hits it
					pieces.remove(gameBoard[this.getLocation() + m]);
				}
				gameBoard[this.getLocation() -m ]= this;
				gameBoard[this.getLocation()] = null;
				this.setLocation(this.getLocation() - m);
			}
		}

	}

	//gets gamepieces
	public void setInteractable(ArrayList<GamePiece> pieces) {
		Missile.pieces = pieces;
	}

}
