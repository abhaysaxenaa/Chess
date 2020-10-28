package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class Pawn extends ChessPiece{
	
	public Pawn(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case edgeCases) {
		
		boolean blackPlayer = this.getPlayerColor().equals("Black");
		if (blackPlayer) {
			edgeCases.isFirstMove = curr.getRow() == 1 ? true : false;
			edgeCases.canPromote = end.getRow() == 7 ? true : false;
		} else {
			edgeCases.isFirstMove = curr.getRow() == 6 ? true : false;
			edgeCases.canPromote = end.getRow() == 0 ? true : false;
		}

		if (super.checkValidity(curr, end, edgeCases)) {

			if (edgeCases.isCapturing) {
				if (curr.getCol() - 1 == end.getCol() || curr.getCol() + 1 == end.getCol()) {
					if (blackPlayer) {
						return (curr.getRow() + 1 == end.getRow());
					}
					else {
						return (curr.getRow() - 1 == end.getRow());
					}
				} else {
					return false;
				}
			} else if (curr.getCol() == end.getCol()) {
				if (edgeCases.isFirstMove) {
					return blackPlayer ? curr.getRow() + 1 == end.getRow() || curr.getRow() + 2 == end.getRow()
							: curr.getRow() - 1 == end.getRow() || curr.getRow() - 2 == end.getRow();
				}
				else if (edgeCases.isPromoting) {
					return blackPlayer ? curr.getRow() + 1 == end.getRow() && edgeCases.canPromote
							: curr.getRow() - 1 == end.getRow() && edgeCases.canPromote;
				}
				else {
					return blackPlayer ? curr.getRow() + 1 == end.getRow() : curr.getRow() - 1 == end.getRow();
				}
			}
		}
		return false;
	}
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates curr) {
		return null;
	}
	
	public String printPiece() {
		return super.printPiece() + "p";
	}
}