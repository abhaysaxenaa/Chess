/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class Knight extends ChessPiece{
	
	//Constructor: Creates a new Knight Piece
		/*
		 * @param color 
		 * (type String) for the color of Knight
		 */
	public Knight(String color) {
		super(color);
	}
	//Getter Method: Gets knight's current color property.
		/*
		 * @return String 
		 * Knight color (type String)
		 */
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	//Checks for possible edge case checks specific to the Knight Piece.
		/*
		 * @return boolean 
		 * @param curr 
		 *  current coordinate of Knight
		 * 
		 * @param end
		 * final coordinate of Knight
		 * 
		 * @param exceptionalCase 
		 * 
		 */
	public boolean checkValidity(Coordinates curr, Coordinates end, Case exceptionalCase) {
		if (curr.calculateDistance(end) <= 7 && curr.checkBoardLimits(end)) {
			if (knightCondition(curr, end)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/*
	 * @param curr 
	 *  current coordinate 
	 * 
	 * @param end 
	 * final coordinate
	 * 
	 * @return boolean 
	 */
	private boolean knightCondition(Coordinates curr, Coordinates end) {
		if (curr.getRow() + 2 == end.getRow() || curr.getRow() - 2 == end.getRow()) {
			return (curr.getCol() + 1 == end.getCol() || curr.getCol() - 1 == end.getCol()) ? true : false;
		} else if (curr.getCol() + 2 == end.getCol() || curr.getCol() - 2 == end.getCol()) {
			return (curr.getRow() + 1 == end.getRow() || curr.getRow() - 1 == end.getRow()) ? true : false;
		}
		return false;
	}
	//The ArrayList holds the position of farthest locations where the Knight Piece can move across the chess board.
		/*
		 * @param curr 
		 *  current coordinate 
		 */
	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		
		int X[] = { 2, 1, -1, -2, -2, 0, 1, 2 };
		int Y[] = { 1, 2, 2, 1, -1, 0, -2, -1 };
		
		ArrayList<Coordinates> pieceMove = new ArrayList<Coordinates>();
		
		for (int i = 0; i <= 7; i++) {
			int currRow = curr.getRow() + X[i], currCol = curr.getCol() + Y[i];
			if (currRow < 8 && currRow >= 0 && currCol < 8 && currCol >= 0) {
				pieceMove.add(new Coordinates(currRow, currCol));
			}
		}
		
		return pieceMove;
	}
	//Prints Knight place with the appropriate color.
	/*
	 * @return String
	 *  
	 */
	public String printPiece() {
		return super.printPiece() + "N";
	}
}