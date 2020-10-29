/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class ChessPiece {
	
	//Private Variable: color, of type String.
	private String color;
	
	//Constructor: Creates a new Piece
	/*
	 * @param color 
	 * (type String) for the color of the piece
	 */
	public ChessPiece(String color) {
		this.color = color;
	}
	
	//Getter Method: Gets the Piece's current color property.
	/*
	 * @return String 
	 * Bishop color (type String)
	 */
	public String getPlayerColor() {
		return this.color;
	}
	
	//Checks for edge case checks for individual pieces in accordance to its coordinates.
	/*
	 * @return boolean 
	 * @param curr
	 *  current coordinate of the piece
	 * 
	 * @param end 
	 *  final coordinate of the piece
	 * 
	 * @param exceptionalCase 
	 * 
	 */
	public boolean checkValidity(Coordinates curr, Coordinates end, Case exceptionalCases){
		if (curr.calculateDistance(end) >= 8 || curr.checkBoardLimits(end)) {
			return false;
		} else {
			return true;
		}
	} 
	
	//The ArrayList holds the position of farthest locations where the Piece can move across the chess board. This property is inherited across individual Pieces.
	/*
	 * @param curr 
	 * current coordinate 
	 */
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		return null;
	}
	
	//Prints the color property of the current Piece.
	/*
	 * @return String 
	 */
	public String printPiece() {
		if (this.color.equals("White")) {
			return "w";
		} else {
			return "b";
		}
	}
}