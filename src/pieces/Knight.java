package pieces;

import java.awt.Color;
import java.util.ArrayList;

import chess.pieceCoordinate;

public class Knight extends Piece{
	
	public Knight(Color color) {
		super(color);
	}
	
	public Color returnColor() {
		return super.returnColor();
	}
	
	/*public boolean isValidMove(ChessCoordinates start, ChessCoordinates end, SpecialCases specialCases) {
		if (super.isValidMove(start, end, specialCases)) {
			int startRank = start.getRank(), startFile = start.getFile(), endRank = end.getRank(),
					endFile = end.getFile();

			if (startRank + 2 == endRank || startRank - 2 == endRank)
				return startFile + 1 == endFile || startFile - 1 == endFile;
			else if (startFile + 2 == endFile || startFile - 2 == endFile)
				return startRank + 1 == endRank || startRank - 1 == endRank;
		}
		return false;
	}

	public ArrayList<ChessCoordinates> farthestMovesFrom(ChessCoordinates start) {
		ArrayList<ChessCoordinates> farthestMoves = new ArrayList<ChessCoordinates>();

		int startRank = start.getRank(), startFile = start.getFile(), curRank = startRank + 2, curFile = startFile + 1;

		if (curRank < 8 && curRank >= 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		curRank = startRank - 2;
		curFile = startFile + 1;

		if (curRank < 8 && curRank > 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		curRank = startRank + 2;
		curFile = startFile - 1;

		if (curRank < 8 && curRank > 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		curRank = startRank - 2;
		curFile = startFile - 1;

		if (curRank < 8 && curRank >= 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		curRank = startRank + 1;
		curFile = startFile + 2;

		if (curRank < 8 && curRank >= 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		curRank = startRank - 1;
		curFile = startFile + 2;

		if (curRank < 8 && curRank >= 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		curRank = startRank + 1;
		curFile = startFile - 2;

		if (curRank < 8 && curRank >= 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		curRank = 0;
		curFile = 0;

		if (curRank < 8 && curRank >= 0 && curFile < 8 && curFile >= 0)
			farthestMoves.add(new ChessCoordinates(curRank, curFile));

		return farthestMoves;
	}*/
	
	public String toString() {
		return super.toString() + "N";
	}
	
}
