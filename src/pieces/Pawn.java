/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class Pawn extends ChessPiece{
	//Constructor: Creates a new Pawn Piece
		/*
		 * @param color 
		 * (type String) for the color of Pawn
		 */
	public Pawn(String color) {
		super(color);
	}
	
	//Getter Method: Gets Pawn's current color property.
		/*
		 * @return String
		 * Pawn color (type String)
		 */
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	//Checks for possible edge case checks specific to the Pawn Piece.
		/*
		 * @return  boolean  
		 * @param curr 
		 *  current coordinate of Pawn
		 * @param end
		 *  final coordinate of Pawn
		 * 
		 * @param exceptionalCase 
		 * 
		 */
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case exceptionalCase) {
		
		boolean blackPlayer = this.getPlayerColor().equals("Black");
		if (blackPlayer) {
			exceptionalCase.isFirstMove = curr.getRow() == 1 ? true : false;
			exceptionalCase.isPromote = end.getRow() == 7 ? true : false;
		} else {
			exceptionalCase.isFirstMove = curr.getRow() == 6 ? true : false;
			exceptionalCase.isPromote = end.getRow() == 0 ? true : false;
		}

		if (super.checkValidity(curr, end, exceptionalCase)) {

			if (exceptionalCase.isCapturing) {
				if (curr.getCol() - 1 == end.getCol() || curr.getCol() + 1 == end.getCol()) {
					if (blackPlayer) {
						return (curr.getRow() + 1 == end.getRow());
					}
					else {
						return (curr.getRow() - 1 == end.getRow());
					}
				} else {
					return false;
				}
			} else if (curr.getCol() == end.getCol()) {
				if (exceptionalCase.isFirstMove) {
					return blackPlayer ? curr.getRow() + 1 == end.getRow() || curr.getRow() + 2 == end.getRow()
							: curr.getRow() - 1 == end.getRow() || curr.getRow() - 2 == end.getRow();
				}
				else if (exceptionalCase.isPromoting) {
					return blackPlayer ? curr.getRow() + 1 == end.getRow() && exceptionalCase.isPromote
							: curr.getRow() - 1 == end.getRow() && exceptionalCase.isPromote;
				}
				else {
					return blackPlayer ? curr.getRow() + 1 == end.getRow() : curr.getRow() - 1 == end.getRow();
				}
			}
		}
		return false;
	}
	
	//The ArrayList holds the position of farthest locations where the pawn Piece can move across the chess board.
		/*
		 * @param curr
		 *  current coordinate 
		 */
	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		return null;
	}
	//Prints Pawn place with the appropriate color.
		/*
		 * @return String 
		 * Pawn piece as string 
		 */
	public String printPiece() {
		return super.printPiece() + "p";
	}
}