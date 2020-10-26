package pieces;

import java.awt.Color;
import java.util.ArrayList;

import chess.pieceCoordinate;


public class Bishop extends Piece{
	
	public Bishop(Color color) {
		super(color);
	}
	
	public Color returnColor(){
		return super.returnColor();
	}
	
	/*public boolean isValidMove(pieceCoordinate start, pieceCoordinate  end, SpecialCases specialCases) {
		return super.isValidMove(start, end, specialCases) && !specialCases.pieceInPath && start.isDiagonalTo(end);
	}*/

	public ArrayList<pieceCoordinate> farthestMovesFrom() {
		return null;
	}

	public String toString() {
		return super.toString() + "B";
	}
}