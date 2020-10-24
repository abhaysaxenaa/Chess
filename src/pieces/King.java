package pieces;

import java.awt.Color;
import java.util.ArrayList;

import chess.pieceCoordinate;

public class King extends Piece{
	
	public King(Color color) {
		super(color);
	}
	
	public Color returnColor() {
		return super.returnColor();
	}
	
	/*public boolean isValidMove(ChessCoordinates start, ChessCoordinates end, SpecialCases specialCases) {
		return super.isValidMove(start, end, specialCases) && start.isAdjacentTo(end);
	}*/
	
	public ArrayList<pieceCoordinate> farthestMovesFrom() {
		return null;
	}
	
	public String toString() {
		return super.toString() + "K";
	}
	
}
