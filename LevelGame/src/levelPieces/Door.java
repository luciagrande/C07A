//Authors: Liam Morrissey and Lucy Grande
package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Door extends GamePiece {

	public Door(int location) {
		super('D', location);
	}

	//Advances player
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation-this.getLocation() == 0) return InteractionResult.ADVANCE;
		return null;
	}

}
