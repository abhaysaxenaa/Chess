/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;

import chess.Coordinates;

public class Queen extends ChessPiece{
	
	//Constructor: Creates a new Queen Piece
			/*
			 * @param color 
			 * (type String) for the color of Queen
			 */
	public Queen(String color) {
		super(color);
	}
	//Getter Method: Gets Queen's current color property.
			/*
			 * @return String 
			 *  
			 */
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	//Checks for possible edge case checks specific to the Queen Piece.
			/*
			 * @return boolean 
			 * @param curr 
			 * current coordinate of Queen
			 * 
			 * @param end 
			 *  final coordinate of Queen
			 * 
			 * @param exceptionalCase 
			 * 
			 */
	public boolean checkValidity(Coordinates curr, Coordinates end, Case exceptionalCase) {
		if (super.checkValidity(curr, end, exceptionalCase) && queenConditionCheck(curr, end)) {
			return true;
		} else {
			return false;
		}
	}
	//The ArrayList holds the position of farthest locations where the Queen Piece can move across the chess board.
			/*
			 * @param curr
			 * current coordinate 
			 */
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		ArrayList<Coordinates> pieceMove = new ArrayList<Coordinates>();
		
		pieceMove.add(new Coordinates(start.getRow(), 7));
		pieceMove.add(new Coordinates(0, start.getCol()));
		pieceMove.add(new Coordinates(7, start.getCol()));
		pieceMove.add(new Coordinates(start.getRow(), 0));
		
		return pieceMove;
	}
	/*
	 * @param curr
	 *  current coordinate 
	 *
	 * @param end 
	 *  final coordinate
	 * 
	 * @return  boolean 
	 */
	public boolean queenConditionCheck(Coordinates curr, Coordinates end){
		return (curr.getCol() == end.getCol() || curr.diagonalCheck(end) || curr.getRow() == end.getRow());
	}
	//Prints Queen place with the appropriate color.
		/*
		 * @return String 
		 *  
		 */
	public String printPiece() {
		return super.printPiece() + "Q";
	}
}