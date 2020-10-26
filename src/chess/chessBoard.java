package chess;

import pieces.*;
import chess.Coordinates;

public class chessBoard {
	
	public class Square {
		
		private Coordinates coordinate;
		private ChessPiece currPiece;
		
		public Square(int row, int col, ChessPiece currPiece) {
			this.coordinate = new Coordinates(row, col);
			this.currPiece = currPiece;
		}
		
		public Square(char row, char col, ChessPiece currPiece) {
			this.coordinate = new Coordinates(row, col);
			this.currPiece = currPiece;
		}
		
		public ChessPiece getcurrPiece() {
			return this.currPiece;
		}
		
		public void setcurrPiece(ChessPiece newPiece) {
			this.currPiece = newPiece;
		}
		
		public Coordinates getCoordinates() {
			return this.coordinate;
		}
		
		public int getRow() {
			return this.coordinate.getRow();
		}
		
		public int getCol() {
			return this.coordinate.getCol();
		}
		
		public String printSquare() {
			if (this.currPiece != null) {
				return this.currPiece.toString();
			} else {
				 if (this.getRow() + this.getCol() % 2 == 0 || this.getRow() + this.getCol() % 2 != 0) {
					 return " ";
				 } else {
					 return "##";
				 }
			}
		}
	}
	
	private Square[][] chessboard;
	
	public chessBoard() {
		
		this.chessboard = new Square[8][8];
		String playerColor;
		ChessPiece createPiece;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (i == 0 || i == 7) {
					
					playerColor = i == 0 ? "Black" : "White";
					
					if (j == 3) {
						createPiece = new Queen(playerColor);
					} else if (j == 2 || j == 5) {
						createPiece = new Bishop(playerColor);
					} else if (j == 1 || j == 6) {
						createPiece = new Knight(playerColor);
					} else if (j == 0 || j == 7) {
						createPiece = new Rook(playerColor);
					} else {
						createPiece = new King(playerColor);
					}
				} else if (i == 1 || i == 6) {
					playerColor = i == 0 ? "Black" : "White";
					createPiece = new Pawn(playerColor);
				}
				
				this.chessboard[i][j] = new Square(i, j, createPiece);
			}
		}
		
		/*private final Piece[][] STANDARD_SETUP = {
        { new Rook(WHITE), new Knight(WHITE), new Bishop(WHITE),
                new Queen(WHITE), new King(WHITE), new Bishop(WHITE),
                new Knight(WHITE), new Rook(WHITE) },
        { new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE),
                new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE),
                new Pawn(WHITE), new Pawn(WHITE) },
        { null, null, null, null, null, null, null, null },
        { null, null, null, null, null, null, null, null },
        { null, null, null, null, null, null, null, null },
        { null, null, null, null, null, null, null, null },
        { new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK),
                new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK),
                new Pawn(BLACK), new Pawn(BLACK) },
        { new Rook(BLACK), new Knight(BLACK), new Bishop(BLACK),
                new Queen(BLACK), new King(BLACK), new Bishop(BLACK),
                new Knight(BLACK), new Rook(BLACK) } };*/
	}
	
	public Square getcurrSquare(Coordinates coordinate) {
		return this.chessboard[coordinate.getRow()][coordinate.getCol()];
	}
	
	public Square getcurrSquare(int row, int col) {
		return this.chessboard[row][col];
	}
	
	public void makeMove(int currRow, int currCol, int finalRow, int finalCol) {
		this.chessboard[finalRow][finalCol].currPiece = this.chessboard[currRow][currCol].currPiece;
		this.chessboard[currRow][currCol].currPiece = null;
	}
	
	public String printBoard() {
		String boardPrint = "";

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boardPrint += this.chessboard[i][j].toString() + " ";
			}

			boardPrint += (i * -1 + 8) + "\n";
		}

		boardPrint += " a  b  c  d  e  f  g  h\n";

		return boardPrint;
	}
}
