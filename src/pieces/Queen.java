package pieces;

import java.util.ArrayList;

import chess.Coordinates;

public class Queen extends ChessPiece{
	
	private String color;
	
	public Queen(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (curr.calculateDistance(end) > 8 || (curr.getRow() < 0 || curr.getCol() < 0)) {
			return false;
		} else {
			return true;
		}
		//&& (start.isDiagonalTo(end) || start.isHorizontalTo(end) || start.isVerticalTo(end));
	}
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		ArrayList<Coordinates> pieceMove = new ArrayList<Coordinates>(4);
		
		pieceMove.add(new Coordinates(start.getRow(), 7));
		pieceMove.add(new Coordinates(start.getRow(), 0));
		pieceMove.add(new Coordinates(7, start.getCol()));
		pieceMove.add(new Coordinates(0, start.getCol()));
		
		return pieceMove;
	}
	
	public String printPiece() {
		if (this.color.equals("White")) {
			return "wQ";
		} else {
			return "bQ";
		}
	}
}