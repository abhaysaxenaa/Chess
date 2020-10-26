package controller;

import chess.chessBoard;
import chess.chessBoard.Square;
import pieces.*;
import chess.Coordinates;

public class ChessController {
	
	private chessBoard chessboard;
	public boolean hasEnded;
	private String currPlayer;
	
	public ChessController() {
		this.chessboard = new chessBoard();
		this.hasEnded = false;
		this.currPlayer = "White";
	}
	
	public chessBoard getBoard() {
		return this.chessboard;
	}
	
	public void makeMove(Coordinates curr, Coordinates end, ChessPiece promote) {
		
		if (curr.getRow() == end.getRow() && curr.getCol() == end.getCol()) {
			
			System.out.println("Illegal move, try again");
			return;
			
		} else {
			
			int row = curr.getRow(), col = curr.getCol();
			int finalrow = end.getRow(), finalcol = end.getCol();
			ChessPiece currPiece = this.chessboard.getcurrSquare(row, col).getcurrPiece();
			ChessPiece endPiece = this.chessboard.getcurrSquare(finalrow, finalcol).getcurrPiece();
			
			//Check for special cases
			//IMPLEMENT THIS METHOD
		}
	}
	
	public boolean checkPath(Coordinates curr, Coordinates end) {
		
		int row = curr.getRow(), col = curr.getCol(), finalRow = end.getRow(), finalCol = end.getCol();
		
		//Checks if there is any other piece vertical to the coordinates.
		if (curr.verticalCheck(end)) {
			if (row < finalRow) {
				for (int i = row; i < finalRow; i++) {
					if (this.chessboard.getcurrSquare(i, col) != null) {
						return true;
					}
				}
				return false;
			}
			for (int i = finalRow; i > row; i--) {
				if (this.chessboard.getcurrSquare(i, col) != null) {
					return true;
				}
			}
			return false;
		}
		
		//Horizontal Check.
		if (curr.horizontalCheck(end)) {
			if (col < finalCol) {
				for (int i = col; i < finalCol; i++) {
					if (this.chessboard.getcurrSquare(row, i) != null) {
						return true;
					}
				}
				return false;
			}
			for (int i = finalCol; i > col; i--) {
				if (this.chessboard.getcurrSquare(row, i) != null) {
					return true;
				}
			}
			return false;
		}
		
		//Adjacency Check.
		//IMPLEMENT ADJACENCY CHECK.
		
		return false;
		
	}
	
}
