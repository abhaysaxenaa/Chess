package pieces;

import java.util.ArrayList;

import chess.Coordinates;

public class ChessPiece {
	
	private String color;
	
	public ChessPiece(String color) {
		this.color = color;
	}
	
	public String getPlayerColor() {
		return this.color;
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCases){
		if (curr.calculateDistance(end) > 8 || (curr.getRow() < 0 || curr.getCol() < 0)) {
			return false;
		} else {
			return true;
		}
	}
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		return null;
	}
			
	public String printPiece() {
		if (this.color.equals("White")) {
			return this.color;
		} else {
			return "Black";
		}
	}
}
