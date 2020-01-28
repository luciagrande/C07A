package levelPieces;

import gameEngine.Drawable;

public class Rug implements Drawable {
	private char symbol = 'R';
	private int location = 4;
	
	public Rug() {
		super();
	}

	@Override
	public void draw() {
		System.out.println(symbol);
	}
}
