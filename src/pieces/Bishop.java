/**
 * @author Abhay Saxena (ans192)
 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;

import chess.Coordinates;


public class Bishop extends ChessPiece{
	
	public Bishop(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (curr.calculateDistance(end) <= 7 && !curr.checkBoardLimits(end) && curr.diagonalCheck(end)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		return null;
	}
	
	public String printPiece() {
		return super.printPiece() + "B";
	}
	
}