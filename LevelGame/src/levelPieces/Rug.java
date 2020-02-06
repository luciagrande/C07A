//Authors: Liam Morrissey and Lucy Grande
package levelPieces;

import gameEngine.Drawable;

public class Rug implements Drawable {
	private char symbol = 'R';
	private int location;

	public char getSymbol() {
		return symbol;
	}

	public int getLocation() {
		return location;
	}

	public Rug(int location) {
		super();
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}
}
