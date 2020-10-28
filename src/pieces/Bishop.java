/**
 * @author Abhay Saxena (ans192)
 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;

import chess.Coordinates;


public class Bishop extends ChessPiece{
	
	private String color;
	
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
	
	public ArrayList<Coordinates> pieceMoveList() {
		return null;
	}
	
	public String printPiece() {
		if (this.color.equals("White")) {
			return  "wB";
		} else {
			return "bB";
		}
	}
	
}