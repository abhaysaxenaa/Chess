/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class King extends ChessPiece{
	//Constructor: Creates a new King Piece
	/*
	 * @param color (
	 * type String) for the color of King
	*/
	public King(String color) {
		super(color);
	}
	
	//Getter Method: Gets King's current color property.
	/*
	 * @return String
	 *  King color (type String)
	*/
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	//Checks for possible edge case checks specific to the King Piece.
		/*
		 * @return boolean 
		 * @param curr 
		 *  current coordinate of king
		 * 
		 * @param end 
		 * final coordinate of king
		 * 
		 * @param exceptionalCase 
		 * 
		 */
	public boolean checkValidity(Coordinates curr, Coordinates end, Case exceptionalCase) {
		if (curr.calculateDistance(end) <= 7 && !curr.checkBoardLimits(end) && curr.adjacencyCheck(end)) {
			return true;
		} else {
			return false;
		}
	}
	//The ArrayList holds the position of farthest locations where the King Piece can move across the chess board.
		/*
		 * @param curr
		 *  current coordinate 
		 */
	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		return null;
	}
	
	//Prints King place with the appropriate color.
	/*
	 * @return String 
	 *  
	 */
	public String printPiece() {
		return super.printPiece() + "K";
	}
}