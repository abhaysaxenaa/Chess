package pieces;

import java.awt.Color;
import java.util.ArrayList;

import chess.pieceCoordinate;

public class Pawn extends Piece{
	
	public Pawn(Color color) {
		super(color);
	}
	
	public Color returnColor() {
		return super.returnColor();
	}
	
	/*public boolean isValidMove(ChessCoordinates start, ChessCoordinates end, SpecialCases specialCases) {
		boolean isBlack = this.getColor().equals(Color.BLACK);
		if (isBlack) {
			specialCases.isFirstMove = start.getRank() == 1 ? true : false;
			specialCases.canPromote = end.getRank() == 7 ? true : false;
		} else {
			specialCases.isFirstMove = start.getRank() == 6 ? true : false;
			specialCases.canPromote = end.getRank() == 0 ? true : false;
		}

		if (super.isValidMove(start, end, specialCases)) {
			int startRank = start.getRank(), startFile = start.getFile(), endRank = end.getRank(),
					endFile = end.getFile();

			if (specialCases.isCapturing) {
				if (startFile - 1 == endFile || startFile + 1 == endFile) {
					if (isBlack)
						return (startRank + 1 == endRank);
					else
						return (startRank - 1 == endRank);
				} else
					return false;
			} else if (start.isVerticalTo(end)) {
				if (specialCases.isFirstMove)
					return isBlack ? startRank + 1 == endRank || startRank + 2 == endRank
							: startRank - 1 == endRank || startRank - 2 == endRank;
				else if (specialCases.isPromoting)
					return isBlack ? startRank + 1 == endRank && specialCases.canPromote
							: startRank - 1 == endRank && specialCases.canPromote;
				else
					return isBlack ? startRank + 1 == endRank : startRank - 1 == endRank;
			}
		}
		return false;
	}

	public ArrayList<ChessCoordinates> farthestMovesFrom(ChessCoordinates start) {
		return null;
	}*/
	
	public String toString() {
		return super.toString() + "p";
	}
	
}
