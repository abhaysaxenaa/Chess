/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;

import chess.Coordinates;


public class Bishop extends ChessPiece{
	
	//Constructor: Creates a new Bishop Piece
	/*
	 * @param color 
	 * (type String) for the color of bishop
	 */
	public Bishop(String color) {
		super(color);
	}
	
	//Getter Method: Gets Bishop's current color property.
	/*
	 * @return String 
	 */
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	//Checks for possible edge case checks specific to the Bishop Piece.
	/*
	 * @return  boolean  
	 * @param curr 
	 *  current coordinate of bishop
	 * 
	 * @param end 
	 *  final coordinate of bishop
	 * 
	 * @param exceptionalCase 
	 * 
	 */
	public boolean checkValidity(Coordinates curr, Coordinates end, Case exceptionalCase) {
		if (curr.calculateDistance(end) <= 7 && !curr.checkBoardLimits(end) && curr.diagonalCheck(end)) {
			return true;
		} else {
			return false;
		}
	}
	
	//The ArrayList holds the position of farthest locations where the Bishop Piece can move across the chess board.
	/*
	 * @param curr
	 * current coordinate 
	 */
	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		return null;
	}
	
	//Prints Bishop place with the appropriate color.
	/*
	 * @return String 
	 * bishop piece as string 
	 */
	public String printPiece() {
		return super.printPiece() + "B";
	}
	
}