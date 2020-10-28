package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class Knight extends ChessPiece{
	
	public Knight(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (curr.calculateDistance(end) <= 7 && curr.checkBoardLimits(end)) {
			if (knightCondition(curr, end)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	private boolean knightCondition(Coordinates curr, Coordinates end) {
		if (curr.getRow() + 2 == end.getRow() || curr.getRow() - 2 == end.getRow()) {
			return (curr.getCol() + 1 == end.getCol() || curr.getCol() - 1 == end.getCol()) ? true : false;
		} else if (curr.getCol() + 2 == end.getCol() || curr.getCol() - 2 == end.getCol()) {
			return (curr.getRow() + 1 == end.getRow() || curr.getRow() - 1 == end.getRow()) ? true : false;
		}
		return false;
	}

	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		
		int X[] = { 2, 1, -1, -2, -2, 0, 1, 2 };
		int Y[] = { 1, 2, 2, 1, -1, 0, -2, -1 };
		
		ArrayList<Coordinates> pieceMove = new ArrayList<Coordinates>();
		//int currRow = curr.getRow(), currCol = curr.getCol();
		//int Rank = currRow + 2, File = currCol + 1;
		
		for (int i = 0; i <= 7; i++) {
			int currRow = curr.getRow() + X[i], currCol = curr.getCol() + Y[i];
			if (currRow < 8 && currRow >= 0 && currCol < 8 && currCol >= 0) {
				pieceMove.add(new Coordinates(currRow, currCol));
			}
		}
		
		
		/*if (Rank < 8 && Rank >= 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));

		Rank = currRow - 2;
		File = currCol + 1;

		if (Rank < 8 && Rank > 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));

		Rank = currRow + 2;
		File = currCol - 1;

		if (Rank < 8 && Rank > 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));

		Rank = currRow - 2;
		File = currCol - 1;

		if (Rank < 8 && Rank >= 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));

		Rank = currRow + 1;
		File = currCol + 2;

		if (Rank < 8 && Rank >= 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));

		Rank = currRow - 1;
		File = currCol + 2;

		if (Rank < 8 && Rank >= 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));

		Rank = currRow + 1;
		File = currCol - 2;

		if (Rank < 8 && Rank >= 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));

		Rank = 0;
		File = 0;

		if (Rank < 8 && Rank >= 0 && File < 8 && File >= 0)
			pieceMove.add(new Coordinates(Rank, File));*/

		return pieceMove;
	}
	
	public String printPiece() {
		return super.printPiece() + "N";
	}
}