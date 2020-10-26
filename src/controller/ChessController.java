package controller;

import java.awt.Color;
import java.util.ArrayList;

import chess.Board;
//import chess.Board.chessboard;
import chess.pieceCoordinate;
import pieces.*;

public class ChessController {
	
	private Board board;
	public boolean isEndGame;
	private Color curPlayer;
	
	public ChessController() {
		this.board = new Board();
		this.isEndGame = false;
		this.curPlayer = Color.WHITE;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	/*public void makeMove(pieceCoordinate curr, pieceCoordinate limit, Piece promotion) {
		if (curr.equals(limit)) {
			System.out.println("Illegal move, try again");
			return;
		}

		Piece movingPiece = this.board.getchessBoard(curr).getOccupier(),
				takenPiece = this.board.getchessBoard(limit).getOccupier();
		Case specialCases = new Case();

		specialCases.isCapturing = takenPiece == null ? false : true;
		specialCases.isPromoting = promotion == null ? false : true;
		specialCases.pieceInPath = this.isPieceInPath(curr, limit);

		if (movingPiece == null || !movingPiece.getColor().equals(curPlayer)
				|| takenPiece != null && takenPiece.getColor().equals(curPlayer))
			System.out.println("Illegal move, try again");
		else if (movingPiece.isValidMove(curr, limit, specialCases)) {
			int startRank = start.getRank(), startFile = curr.getFile(), endRank = limit.getRank(),
					endFile = end.getFile();

			if (movingPiece instanceof Pawn && specialCases.canPromote)
				this.board.getSquare(endRank, endFile).setOccupier(promotion);
			else
				this.board.getSquare(endRank, endFile).setOccupier(movingPiece);

			this.board.getSquare(startRank, startFile).setOccupier(null);

			if (takenPiece instanceof King) {
				this.isEndGame = true;
				System.out.println("Checkmate");
			} else if (kingIsInCheck())
				System.out.println("Check");
			switchCurPlayer();
		} else {
			System.out.println("Illegal move, try again");
		}
	}*/
	
}
