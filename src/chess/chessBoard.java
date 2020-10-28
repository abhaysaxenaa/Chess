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
				return this.currPiece.printPiece();
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
		String pieceColor = null;

		for (int curRank = 0; curRank < 8; curRank++)
			for (int curFile = 0; curFile < 8; curFile++) {
				ChessPiece newPiece = null;

				if (curRank == 0 || curRank == 7) { // initialize non-pawns
					pieceColor = curRank == 0 ? "Black" : "White";

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
					newPiece = new Pawn(curRank == 1 ? "Black" : "White");

				this.chessboard[curRank][curFile] = new Square(curRank, curFile, newPiece);
			}
	}
		
		//USE THIS CONSTRUCTOR INSTEAD
		
		/*public chessBoard(){
		 * this.chessboard = new Square[8][8];
		 * 
		 * this.chessBoard = {
        { new Rook("White"), new Knight("White"), new Bishop("White"),
                new Queen("White"), new King("White"), new Bishop("White"),
                new Knight("White"), new Rook("White") },
        { new Pawn("White"), new Pawn("White"), new Pawn("White"),
                new Pawn("White"), new Pawn("White"), new Pawn("White"),
                new Pawn("White"), new Pawn("White") },
        { null, null, null, null, null, null, null, null },
        { null, null, null, null, null, null, null, null },
        { null, null, null, null, null, null, null, null },
        { null, null, null, null, null, null, null, null },
        { new Pawn("Black"), new Pawn("Black"), new Pawn("Black"),
                new Pawn("Black"), new Pawn("Black"), new Pawn("Black"),
                new Pawn("Black"), new Pawn("Black") },
        { new Rook("Black"), new Knight("Black"), new Bishop("Black"),
                new Queen("Black"), new King("Black"), new Bishop("Black"),
                new Knight("Black"), new Rook("Black") } };
                
        }*/
	
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
				boardPrint += this.chessboard[i][j].printSquare() + " ";
			}

			boardPrint += (i * -1 + 8) + "\n";
		}

		boardPrint += " a  b  c  d  e  f  g  h\n";

		return boardPrint;
	}
}