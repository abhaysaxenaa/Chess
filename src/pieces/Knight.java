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
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (curr.calculateDistance(end) <= 8 && curr.checkBoardLimits(end)) {
			if (knightCondition(curr, end)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	private boolean knightCondition(Coordinates curr, Coordinates end) {
		if (curr.getRow() + 2 == end.getRow() || curr.getRow() - 2 == end.getRow()) {
			return (curr.getCol() + 1 == end.getCol() || curr.getCol() - 1 == end.getCol()) ? true : false;
		} else if (curr.getCol() + 2 == end.getCol() || curr.getCol() - 2 == end.getCol()) {
			return (curr.getRow() + 1 == end.getRow() || curr.getRow() - 1 == end.getRow()) ? true : false;
		}
		return false;
	}

	public ArrayList<Coordinates> pieceMoveList() {
		return null;
		//ArrayList<Coordinates> farthestMoves = new ArrayList<Coordinates>();
	}
	
	public String printPiece() {
		if (this.color.equals("White")) {
			return "wN";
		} else {
			return "bN";
		}
	}
}