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