package pieces;

import java.util.ArrayList;
import chess.Coordinates;

public class Rook extends ChessPiece{
	
	public Rook(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (super.checkValidity(curr, end, specialCase) && rookConditionCheck(curr, end, specialCase)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		ArrayList<Coordinates> pieceMove = new ArrayList<Coordinates>(4);
		
		pieceMove.add(new Coordinates(start.getRow(), 7));
		pieceMove.add(new Coordinates(start.getRow(), 0));
		pieceMove.add(new Coordinates(7, start.getCol()));
		pieceMove.add(new Coordinates(0, start.getCol()));
		
		return pieceMove;
	}
	
	public boolean rookConditionCheck(Coordinates curr, Coordinates end, Case specialCase) {
		return (!specialCase.pieceInPath && ((curr.getRow() == end.getRow()) || (curr.getCol() == end.getCol())));
	}
	
	public String printPiece() {
		return super.printPiece() + "R";
	}
}