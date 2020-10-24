package pieces;

import java.awt.Color;
import java.util.ArrayList;

import chess.pieceCoordinate;

public class Piece {
	
	private Color color;
	
	public Piece(Color color){
		this.color = color;
	}
	
	public Color returnColor() {
		return this.color;
	}
	
	/*public boolean isValidMove(ChessCoordinates start, ChessCoordinates end, SpecialCases specialCases){
		return start.distanceFrom(end) <= 7;
	}*/
	
	public ArrayList<pieceCoordinate> farthestMovesFrom(pieceCoordinate start) {
		return null;
	}

	public String toString() {
		return this.color.equals(Color.WHITE)? "w" : "b";
	}
}
