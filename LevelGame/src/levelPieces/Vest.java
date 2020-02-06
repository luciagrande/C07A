//Authors: Liam Morrissey and Lucy Grande
package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Vest extends GamePiece  {

	public Vest( int location) {
		super('V', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//stops from damaging when attacked by sniper
		if(playerLocation==this.getLocation()) return InteractionResult.PROTECT;
		return null;
	}



}
