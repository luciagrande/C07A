package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Door extends GamePiece {

	public Door(int location) {
		super('D', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation-this.getLocation() == 0) return InteractionResult.ADVANCE;
		return null;
	}

}
