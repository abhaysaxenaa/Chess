package pieces;

import java.awt.Color;
import java.util.ArrayList;

import chess.pieceCoordinate;

public class Piece {
	
	public class Square{
		
		private pieceCoordinate coordinates;
		private Piece occupier;
		
		public Square(int rank, int file, Piece occupier) {
			this.coordinates = new pieceCoordinate(rank, file);
			this.occupier = occupier;
		}
		
		public Square(char rank, char file, Piece occupier) {
			this.coordinates = new pieceCoordinate(rank, file);
			this.occupier = occupier;
		}
		
		
		
	}
}
