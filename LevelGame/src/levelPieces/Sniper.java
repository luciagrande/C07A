package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Sniper extends GamePiece implements Moveable{

	public Sniper(int location) {
		super('S', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() - playerLocation <=3) {
			return InteractionResult.KILL;
		}
		return null;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
	}

}
