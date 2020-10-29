/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class Rook extends ChessPiece{
	
	//Constructor: Creates a new Rook Piece
			/*
			 * @param color 
			 * (type String) for the color of Rook
			 */
	public Rook(String color) {
		super(color);
	}
	
	//Getter Method: Gets Rook's current color property.
	/*
	 * @return String  
	 */
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	//Checks for possible edge case checks specific to the Rook Piece.
	/*
	 * @return  boolean  
	 * @param curr 
	 *  current coordinate of Rook
	 * 
	 * @param end 
	 * final coordinate of Rook
	 * 
	 * @param exceptionalCase 
	 */
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (super.checkValidity(curr, end, specialCase) && rookConditionCheck(curr, end, specialCase)) {
			return true;
		} else {
			return false;
		}
	}
	
	//The ArrayList holds the position of farthest locations where the Rook Piece can move across the chess board.
	/*
	 * @param curr 
	 *  current coordinate 
	 */
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		ArrayList<Coordinates> pieceMove = new ArrayList<Coordinates>(4);
		
		pieceMove.add(new Coordinates(start.getRow(), 7));
		pieceMove.add(new Coordinates(start.getRow(), 0));
		pieceMove.add(new Coordinates(7, start.getCol()));
		pieceMove.add(new Coordinates(0, start.getCol()));
		
		return pieceMove;
	}
	
	/*
	 * @param curr
	 *  current coordinate 
	 * 
	 * @param end 
	 *  final coordinate
	 * 
	 * @return boolean 
	 */
	public boolean rookConditionCheck(Coordinates curr, Coordinates end, Case specialCase) {
		return (!specialCase.isInPath && ((curr.getRow() == end.getRow()) || (curr.getCol() == end.getCol())));
	}
	//Prints Rook place with the appropriate color.
			/*
			 * @return String 
			 */
	public String printPiece() {
		return super.printPiece() + "R";
	}
}