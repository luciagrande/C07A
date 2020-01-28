package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Treasure extends GamePiece {

	public Treasure(int location) {
		super('T',location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (this.getLocation() - playerLocation == 0) {
			return InteractionResult.GET_POINT;
		}
		return null;
	}

}
