package pieces;

import java.util.ArrayList;

import chess.Coordinates;

public class Knight extends ChessPiece{
	
	private String color;
	
	public Knight(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end /*SpecialCase*/) {
		
		if (curr.calculateDistance(end) > 8 || (curr.getRow() < 0 || curr.getCol() < 0) && !(curr. adjacencyCheck(end))) {
			return false;
		}
		else {int row = curr.getRow(), currFile = curr.getCol(), endRank = end.getRow(),
				endFile = end.getCol();

		if (row + 2 == endRank || row - 2 == endRank)
			return currFile + 1 == endFile || currFile - 1 == endFile;
		else if (currFile + 2 == endFile || currFile - 2 == endFile)
			return row + 1 == endRank || row - 1 == endRank;
			return true;
		}
		
		//&& curr.isAdjacentTo(end);
	}
	
	public ArrayList<Coordinates> pieceMoveList() {
		return null;
	}
	
	public String printPiece() {
		if (this.color.equals("White")) {
			return "wN";
		} else {
			return "bN";
		}
	}
}
