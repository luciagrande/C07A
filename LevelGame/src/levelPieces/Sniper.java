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
		if (Math.abs(this.getLocation() - playerLocation) <=3) {
			return InteractionResult.KILL;
		}
		return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		Random rand = new Random();
		int m = rand.nextInt() % 2;
		for(Drawable p:gameBoard) {
		if(this.getLocation()+m!= playerLocation && this.getLocation()+m!=t.getLocation());
		}
	}

}
