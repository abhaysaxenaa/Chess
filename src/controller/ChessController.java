/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package controller;

import chess.chessBoard;
import chess.chessBoard.Square;
import pieces.*;
import chess.Coordinates;

import java.util.ArrayList;

public class ChessController {
	
	private chessBoard chessboard;
	private String currPlayer;
	public boolean hasEnded;
	
	//Constructor Call
	public ChessController() {
		this.chessboard = new chessBoard();
		this.hasEnded = false;
		this.currPlayer = "White";
	}
	
	//Return chessBoard instance.
	/**
	 * @return the board
	 */
	public chessBoard getBoard() {
		return this.chessboard;
	}
	
	/*
	 * @return current player as string 
	 */
	//Returns a string of the current player.
	public String getcurrPlayer() {
		return this.currPlayer;
	}
	
	/*Moves the piece from the current coordinate to the end coordinate after a series of checks. Also
	 * accepts a potential promotion if it is passed (and is not null). Also checks for a check, or a final checkmate.
	 *  @param curr 
	 *  (type Coordinates)  the current coordinate of the piece
	 * 	
	 * @param end 
	 * (type Coordinates) the final coordinate of the piece to be moved
	 * 
	 * 	@param promotion
	 *  (type chesspiece)  condition for the piece to be promoted 
	 *            
	 */
	public void makeMove(Coordinates curr, Coordinates end, ChessPiece promote) {
		
		if (curr.getRow() != end.getRow() && curr.getCol() != end.getCol()) {
			
			int row = curr.getRow(), col = curr.getCol();
			int finalrow = end.getRow(), finalcol = end.getCol();
			ChessPiece currPiece = this.chessboard.getcurrSquare(row, col).getcurrPiece();
			ChessPiece endPiece = this.chessboard.getcurrSquare(finalrow, finalcol).getcurrPiece();
			
			
			Case exceptionalCases = new Case();
			if( endPiece == null) {
				exceptionalCases.isCapturing = false;
			}
			else {
				exceptionalCases.isCapturing = true;
			}
			if(promote == null) {
				exceptionalCases.isPromoting = false;
			}
			else {
				exceptionalCases.isPromoting = true;
			}
			exceptionalCases.isInPath = this.checkPath(curr, end);
			
			if (currPiece == null || !currPiece.getPlayerColor().equals(endPiece.getPlayerColor()) || (endPiece != null && endPiece.getPlayerColor().equals(currPiece.getPlayerColor()))){
				System.out.println("Illegal move, try again");
				return;
			} else if (currPiece.checkValidity(curr, end, exceptionalCases)) {
				if (currPiece instanceof Pawn && exceptionalCases.isPromote) {
					this.chessboard.getcurrSquare(end.getRow(), end.getCol()).setcurrPiece(promote);
				} else {
					this.chessboard.getcurrSquare(end.getRow(), end.getCol()).setcurrPiece(currPiece);
				}
				this.chessboard.getcurrSquare(curr.getRow(), curr.getCol()).setcurrPiece(null);
				
				if (endPiece instanceof King) {
					this.hasEnded = true;
					System.out.println("Checkmate");
				} else if (checkOnKing())
					System.out.println("Check");
				flipPlayers();
				
			} else {
				System.out.println("Illegal move, try again");
			}
			
		} else {
			System.out.println("Illegal move, try again");
			return;
		} 
	}
	
	//Flips the current player to the other player, used for spontaneous switching for certain special cases.
		public void flipPlayers() {
			if (this.currPlayer.equals("White")) {
				this.currPlayer = "Black";
			} else {
				this.currPlayer = "White";
			}
		}
	/*
	 * * @param curr 
	 *  current coordinate of the square for piece
	 *            
	 * @param end
	 *   final coordinate of the square for piece to be moved
	 * 
	 * @return boolean 
	 * 
	 */
	//Checks if there is any piece in between the current and end coordinate for the makeMove method to operate.
	public boolean checkPath(Coordinates curr, Coordinates end) {
		
		int row = curr.getRow(), col = curr.getCol(), finalRow = end.getRow(), finalCol = end.getCol();
		
		//Checks if there is any other piece vertical to the coordinates.
		if (curr.getCol() == end.getCol()) {
			if (row < finalRow) {
				int i = row;
				while(i < finalRow){
					if (this.chessboard.getcurrSquare(i, col) != null) {
						return true;
					}
					i++;
				}
				return false;
			}
			
			int i = finalRow;
			while(i>row) {
				if (this.chessboard.getcurrSquare(i, col) != null) {
					return true;	
				}
				i--;
			}
			return false;
		}
		
		//Horizontal Check.
		if (curr.getRow() == end.getRow()) {
			if (col < finalCol) {
			
				int j = col;
				while(j<finalCol){
					if (this.chessboard.getcurrSquare(row, j) != null) {
						return true;
						
					}
					j++;
				}
				return false;
			}
			int k = finalCol;
			while (k > col){
				if (this.chessboard.getcurrSquare(row, k) != null) {
					return true;
					
				}
				k--;
			}
			return false;
		}
		
		//Diagonal and Adjacency Check.
		if (curr.diagonalCheck(end)) {
			if (curr.adjacencyCheck(end)) {
				return this.chessboard.getcurrSquare(finalRow, finalCol) != null;
			} else {
				int i = finalRow > row ? 1 : -1, j = finalCol > col ? 1 : -1;
				
					int itrRow = row + i; 
					while(itrRow != finalRow){
					for (int itrCol = col + j; itrCol != finalCol; itrCol = itrCol + j) {
						if (this.chessboard.getcurrSquare(itrRow, itrCol).getcurrPiece() != null){
							return true;
						}
					}
					itrRow = itrRow + i;
				}
			}
		}
		
		return false;
		
	}
	
	//Checks if a given coordinate is in collision with a King piece.
	/**
	 * 
	 * 
	 * @param row 
	 * (type int) row 
	 *            
	 * @param col 
	 * (type int) column
	 *             
	 * @return Boolean 
	 */
	public boolean possibleCheck(int row, int col) {
		
		ChessPiece currPiece = this.chessboard.getcurrSquare(row, col).getcurrPiece();
		Coordinates curr = new Coordinates(row, col);
		ArrayList<Coordinates> pieceMove = currPiece.pieceMoveList(curr);
		
		if (pieceMove != null) {
			 
			int i = 0;
			while(i < pieceMove.size()){
				if (this.directCheck(curr, pieceMove.get(i))) {
					return true;
				}
				i++;
			}
		}
		return false;
	}
	
	//Checks if a King piece is currently in a 'Check'.
	/*
	 * @return boolean 
	 */
	private boolean checkOnKing() {
		
		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++) {
				Square currSquare = this.chessboard.getcurrSquare(i, j);
				if (currSquare != null && currSquare.getcurrPiece().getPlayerColor().equals(currPlayer))
					return possibleCheck(i, j);
			}

		return false;
	}
	
	//Condition Check: If a King piece is the primary collision for two coordinates.
	/*
	 * @param curr
	 *  current coordinate
	 * 
	 * @param end  
 	 *final coordinate 
	 * 
	 * @return boolean 
	 */
	public boolean directCheck(Coordinates curr, Coordinates end) {
		
		if (curr.getCol() == end.getCol()) {
			
			
			int i = curr.getRow()+1;
			while(i < end.getRow()){
				Square check = this.chessboard.getcurrSquare(i, curr.getCol());
				if (check != null) {
					if (check.getcurrPiece() instanceof King) {
						return true;
					} else {
						return false;
					}
				}
				i++;
			}
		} 
		else if (curr.getRow() == end.getCol()) {
			
		
			int i = curr.getCol()+1;
			while(i < end.getCol()){
				Square check = this.chessboard.getcurrSquare(curr.getRow(), i);
				if (check != null) {
					if (check.getcurrPiece() instanceof King) {
						return true;
					} else {
						return false;
					}
				}
				i++;
			}
		} else if (curr.diagonalCheck(end)) {
			
			int i = end.getRow() > curr.getRow() ? 1 : -1, j = end.getCol() > curr.getCol() ? 1 : -1;
			
			for (int itrRow = curr.getRow() + i; itrRow != end.getRow(); itrRow = itrRow + i) {
				for (int itrCol = curr.getCol() + j; itrCol != end.getCol(); itrCol = itrCol + j) {
					Square check = this.chessboard.getcurrSquare(itrRow, itrCol);
					if (check != null) {
						if (check.getcurrPiece() instanceof King) {
							return true;
						} else {
							return false;
						}
					}
				}
			}
		}
		return false;
	}
	
	
	

	
	
	
}