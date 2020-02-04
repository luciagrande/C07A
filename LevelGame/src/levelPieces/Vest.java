package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Vest extends GamePiece  {

	public Vest( int location) {
		super('V', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		if(playerLocation==this.getLocation()) return InteractionResult.PROTECT;
		return null;
	}
	
	

}
