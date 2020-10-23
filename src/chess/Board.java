package chess;

import java.util.Arrays;

import pieces.Piece;

public class Board {
	
	private class Square {
		private pieceCoordinate coordinates;
		private Piece occupier;
		
		public Square(int rank, int file, Piece occupier) {
			this.coordinates = new pieceCoordinate(rank, file);
			this.occupier = occupier;
		}
	}
	
}
