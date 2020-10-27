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
			
			/*IMPLEMENT DIFFERENTLY*/
			Case specialCases = new Case();
			specialCases.isCapturing = endPiece == null ? false : true;
			specialCases.isPromoting = promote == null ? false : true;
			specialCases.pieceInPath = this.checkPath(curr, end);
			
			if (currPiece == null || currPiece.getPlayerColor().equals(endPiece.getPlayerColor()) || (endPiece != null && endPiece.getPlayerColor().equals(currPiece.getPlayerColor()))){
				System.out.println("Illegal move, try again");
				return;
			} else if (currPiece.checkValidity(curr, end, specialCases)) {
				if (currPiece instanceof Pawn && specialCases.canPromote) {
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
			
		}
	}
	
	public boolean checkPath(Coordinates curr, Coordinates end) {
		
		int row = curr.getRow(), col = curr.getCol(), finalRow = end.getRow(), finalCol = end.getCol();
		
		//Checks if there is any other piece vertical to the coordinates.
		if (curr.getCol() == end.getCol()) {
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
		if (curr.getRow() == end.getRow()) {
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
		
		//Diagonal and Adjacency Check.
		if (curr.diagonalCheck(end)) {
			if (curr.adjacencyCheck(end)) {
				return this.chessboard.getcurrSquare(finalRow, finalCol) != null;
			} else {
				int i = finalRow > row ? 1 : -1, j = finalCol > col ? 1 : -1;
				
				for (int itrRow = row + i; itrRow != finalRow; itrRow = itrRow + i) {
					for (int itrCol = col + j; itrCol != finalCol; itrCol = itrCol = itrCol + j) {
						if (this.chessboard.getcurrSquare(itrRow, itrCol).getcurrPiece() != null){
							return true;
						}
					}
				}
			}
		}
		
		return false;
		
	}
	
	
	public boolean possibleCheck(int row, int col) {
		
		ChessPiece currPiece = this.chessboard.getcurrSquare(row, col).getcurrPiece();
		Coordinates curr = new Coordinates(row, col);
		ArrayList<Coordinates> pieceMove = currPiece.pieceMoveList(curr);
		
		if (pieceMove != null) {
			for (int i = 0; i < pieceMove.size(); i++) {
				if (this.directCheck(curr, pieceMove.get(i))) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean checkOnKing() {
		
		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++) {
				Square currSquare = this.chessboard.getcurrSquare(i, j);
				if (currSquare != null && currSquare.getcurrPiece().getPlayerColor().equals(currPlayer))
					return possibleCheck(i, j);
			}

		return false;
	}
	

	public boolean directCheck(Coordinates curr, Coordinates end) {
		
		if (curr.getCol() == end.getCol()) {
			
			for (int i = curr.getRow()+1; i < end.getRow(); i++) {
				Square check = this.chessboard.getcurrSquare(i, curr.getCol());
				if (check != null) {
					if (check.getcurrPiece() instanceof King) {
						return true;
					} else {
						return false;
					}
				}
			}
		} else if (curr.getRow() == end.getCol()) {
			
			for (int i = curr.getCol()+1; i < end.getCol(); i++) {
				Square check = this.chessboard.getcurrSquare(curr.getRow(), i);
				if (check != null) {
					if (check.getcurrPiece() instanceof King) {
						return true;
					} else {
						return false;
					}
				}
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
	
	public String getcurrPlayer() {
		return this.currPlayer;
	}
	
	public void flipPlayers() {
		if (this.currPlayer.equals("White")) {
			this.currPlayer = "Black";
		} else {
			this.currPlayer = "White";
		}
	}
	
}
