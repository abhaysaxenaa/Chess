package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class King extends ChessPiece{
	
	public King(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (curr.calculateDistance(end) <= 7 && !curr.checkBoardLimits(end) && curr.adjacencyCheck(end)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		return null;
	}
	
	public String printPiece() {
		return super.printPiece() + "K";
	}
}