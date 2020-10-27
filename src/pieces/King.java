package pieces;

import java.util.ArrayList;

import chess.Coordinates;

public class King extends ChessPiece{
	
	private String color;
	
	public King(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end /*SpecialCase*/) {
		if (curr.calculateDistance(end) > 8 || (curr.getRow() < 0 || curr.getCol() < 0)) {
			return false;
		} else {
			return true;
		}
		//&& start.isAdjacentTo(end);
	}
	
	public ArrayList<Coordinates> pieceMoveList() {
		return null;
	}
	
	public String printPiece() {
		if (this.color.equals("White")) {
			return "wK";
		} else {
			return "bK";
		}
	}
}
