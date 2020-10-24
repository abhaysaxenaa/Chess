package pieces;

import java.awt.Color;
import java.util.ArrayList;

import chess.pieceCoordinate;

public class Queen extends Piece{
	
	public Queen(Color color) {
		super(color);
	}
	
	public Color returnColor() {
		return super.returnColor();
	}
	
	/*public boolean isValidMove(ChessCoordinates start, ChessCoordinates end, SpecialCases specialCases) {
		return super.isValidMove(start, end, specialCases) && (start.isDiagonalTo(end) || start.isHorizontalTo(end) || start.isVerticalTo(end));	
	}
	
	public ArrayList<ChessCoordinates> farthestMovesFrom(ChessCoordinates start) {
		ArrayList<ChessCoordinates> farthestMoves = new ArrayList<ChessCoordinates>(4);
		
		farthestMoves.add(new ChessCoordinates(start.getRank(), 7));
		farthestMoves.add(new ChessCoordinates(start.getRank(), 0));
		farthestMoves.add(new ChessCoordinates(7, start.getFile()));
		farthestMoves.add(new ChessCoordinates(0, start.getFile()));
		
		return farthestMoves;
	}*/
	
	public String toString() {
		return super.toString() + "Q";
	}
}
