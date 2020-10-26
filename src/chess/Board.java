package chess;


import java.awt.Color;
import java.util.Arrays;
import pieces.*;
import pieces.Piece;

public class Board {
	
	private class chessBoard {
		private pieceCoordinate coordinates;
		private Piece occupier;
		
		public chessBoard(int rank, int file, Piece occupier) {
			this.coordinates = new pieceCoordinate(rank, file);
			this.occupier = occupier;
		}
		
		public chessBoard(char rank, char file, Piece occupier) {
			this.coordinates = new pieceCoordinate(rank, file);
			this.occupier = occupier;
		}
		
		public Piece getOccupier() {
			return this.occupier;
		}

		public void setOccupier(Piece occupier) {
			this.occupier = occupier;
		}

		public boolean isOccupied() {
			return (this.occupier == null) ? false : true;
		}
		
		public pieceCoordinate getCoordinates() {
			return this.coordinates;
		}

		public int getRank() {
			return this.coordinates.getRank();
		}

		public int getFile() {
			return this.coordinates.getFile();
		}
		
		public String toString() {
			if (this.occupier == null) {
				if ((this.getRank() % 2 == 0 && this.getFile() % 2 == 0)
						|| (this.getRank() % 2 != 0 && this.getFile() % 2 != 0))
					return "  ";

				return "##";
			}
			return this.occupier.toString();
		}
	}
	

	public static final int size = 8;
	
	private chessBoard[][] board;
	
	public Board() {
		this.board = new chessBoard[size][size];
		Color pieceColor = null;

		for (int curRank = 0; curRank < size; curRank++)
			for (int curFile = 0; curFile < size; curFile++) {
				Piece newPiece = null;

				if (curRank == 0 || curRank == 7) { // initialize non-pawns
					pieceColor = curRank == 0 ? Color.BLACK : Color.WHITE;

					if (curFile == 0 || curFile == 7)
						newPiece = new Rook(pieceColor);
					else if (curFile == 1 || curFile == 6)
						newPiece = new Knight(pieceColor);
					else if (curFile == 2 || curFile == 5)
						newPiece = new Bishop(pieceColor);
					else if (curFile == 3)
						newPiece = new Queen(pieceColor);
					else
						newPiece = new King(pieceColor);
				} else if (curRank == 1 || curRank == 6) // initialize pawns
					newPiece = new Pawn(curRank == 1 ? Color.BLACK : Color.WHITE);

				this.board[curRank][curFile] = new chessBoard(curRank, curFile, newPiece);
			}
	}
	
	public chessBoard getSquare(pieceCoordinate coordinates) {
		return this.board[coordinates.getRank()][coordinates.getFile()];
	}
	
	public chessBoard getSquare(int rank, int file) {
		return this.board[rank][file];
	}
	
	public void movePiece(int startRank, int startFile, int endRank, int endFile) {
		this.board[endRank][endFile].occupier = this.board[startRank][startFile].occupier;
		this.board[startRank][startFile].occupier = null;
	}
	
	public String toString() {
		String boardString = "";

		for (int curRank = 0; curRank < size; curRank++) {
			for (int curFile = 0; curFile < size; curFile++) {
				boardString += this.board[curRank][curFile].toString() + " ";
			}

			boardString += (curRank * -1 + 8) + "\n";
		}

		boardString += " a  b  c  d  e  f  g  h\n";

		return boardString;
	}
	
}
