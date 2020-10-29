 
/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package chess;

import pieces.*;
import chess.Coordinates;

public class chessBoard {
	
	public class Square {
		
		private Coordinates coordinate;
		private ChessPiece currPiece;
		
		/*
		 * @param row
		 * (type: int) row 
		 * @param col
		 * (type: int) column
		 *            
		 * @param currPiece
		 * The piece thats on the square.
		 *            
		 *
		 */
		public Square(int row, int col, ChessPiece currPiece) {
			this.coordinate = new Coordinates(row, col);
			this.currPiece = currPiece;
		}
		
		/*
		 * @param row
		 *(type: Char) row of square
		 *            
		 * @param col
		 * (type: Char) column of square
		 *            
		 * @param currPiece
		 * The piece thats on the square.
		 *            
		 *
		 */
		public Square(char row, char col, ChessPiece currPiece) {
			this.coordinate = new Coordinates(row, col);
			this.currPiece = currPiece;
		}
		

		/**
		 * 
		 * @return ChessPiece 
		 */
		public ChessPiece getcurrPiece() {
			return this.currPiece;
		}
		
		/**

		 * 
		 * @param newPiece
		 *  sets the current piece  
		 */
		
		public void setcurrPiece(ChessPiece newPiece) {
			this.currPiece = newPiece;
		}
		
		/**
		 * 
		 * @return Coordinates
		 * returns the coordinates for the pieces to be set
		 */
		public Coordinates getCoordinates() {
			return this.coordinate;
		}
		
		/**
		 * 
		 * @return int
		 * returns the row for the pieces to be set
		 */
		public int getRow() {
			return this.coordinate.getRow();
		}
		
		/**
		 * 
		 * @return int
		 *  returns the column for the pieces to be set
		 */
		public int getCol() {
			return this.coordinate.getCol();
		}
		
		/**
		 * 
		 * @return String
		 * returns what element should be in the square 
		 */
		
		public String checkMod() {
			if ((this.getRow() % 2 == 0 && this.getCol() % 2 == 0) || (this.getRow() % 2 != 0 && this.getCol() % 2 != 0)) {
				return "  ";
				} 
			else {
				return "##";
			}
		}
		/**
		 * 
		 * 
		 * @return String
		 * returns square to be printed 
		 */
		
		public String printSquare() {
			if (this.currPiece != null) {
				return this.currPiece.printPiece();
			} 
			else { return checkMod();	
			}
		}
	}
	
	private Square[][] chessboard;
	
	//Constructor,  set up the board with all the pieces.
	public chessBoard() {
		this.chessboard = new Square[8][8];
		String pieceColor = null;

		for (int curRank = 0; curRank < 8; curRank++) {
			for (int curFile = 0; curFile < 8; curFile++) {
				ChessPiece newPiece = null;

				if (curRank == 0 || curRank == 7) {
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
				} else if (curRank == 1 || curRank == 6)
					newPiece = new Pawn(curRank == 1 ? "Black" : "White");

				this.chessboard[curRank][curFile] = new Square(curRank, curFile, newPiece);
			}
		}
	}
	
		
	
	/**
	 * 
	 * 
	 * @param coordinate
	 *   the coordinates of the current square
	 * @return Square
	 * returns the current square with current coordinates
	 */
	public Square getcurrSquare(Coordinates coordinate) {
		return this.chessboard[coordinate.getRow()][coordinate.getCol()];
	}
	
	/**
	 * Returns a square given a rank and file
	 * 
	 * @param row 
	 * (type int):current square row
	 * @param col 
	 * (type int):current square col
	 * @return Square
	 * returns the current square with row and col
	 */
	public Square getcurrSquare(int row, int col) {
		return this.chessboard[row][col];
	}
	
	/**
	 * 
	 * @param currRow 
	 * (Type int)-> current row of the piece
	 * @param currCol 
	 * (Type int)-> current column of the piece
	 * @param FinalRow 
	 * (Type int)-> final row of the piece to be placed
	 * @param 
	 * FinalCol (Type int)-> final column of the piece to be placed
	 */ 
	public void makeMove(int currRow, int currCol, int finalRow, int finalCol) {
		this.chessboard[finalRow][finalCol].currPiece = this.chessboard[currRow][currCol].currPiece;
		this.chessboard[currRow][currCol].currPiece = null;
	}
	
	/**
	 * 
	 * 
	 * @return String
	 * returns board in the format of string
	 */
	
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