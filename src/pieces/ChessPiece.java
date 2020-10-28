/**
 * @author Abhay Saxena (ans192)
 * @author Venkata Sai Karthik Gandrath (vg311)
 */

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
	
	//Can potentially be removed
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCases){
		if (curr.calculateDistance(end) > 8 || curr.checkBoardLimits(end)) {
			return false;
		} else {
			return true;
		}
	}
	
	//Additional checks for each individual pieces:
	/*protected boolean knightCondition(Coordinates curr, Coordinates end) {
		if (curr.getRow() + 2 == end.getRow() || curr.getRow() - 2 == end.getRow()) {
			return (curr.getCol() + 1 == end.getCol() || curr.getCol() - 1 == end.getCol()) ? true : false;
		} else if (curr.getCol() + 2 == end.getCol() || curr.getCol() - 2 == end.getCol()) {
			return (curr.getRow() + 1 == end.getRow() || curr.getRow() - 1 == end.getRow()) ? true : false;
		}
		return false;
	}*/ 
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		return null;
	}
			
	public String printPiece() {
		if (this.color.equals("White")) {
			return "w";
		} else {
			return "b";
		}
	}
}