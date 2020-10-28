package pieces;

import java.util.ArrayList;

import chess.Coordinates;

public class Queen extends ChessPiece{
	
	public Queen(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (super.checkValidity(curr, end, specialCase) && queenConditionCheck(curr, end)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Coordinates> pieceMoveList(Coordinates start) {
		ArrayList<Coordinates> pieceMove = new ArrayList<Coordinates>();
		
		pieceMove.add(new Coordinates(start.getRow(), 7));
		pieceMove.add(new Coordinates(0, start.getCol()));
		pieceMove.add(new Coordinates(7, start.getCol()));
		pieceMove.add(new Coordinates(start.getRow(), 0));
		
		return pieceMove;
	}
	
	public boolean queenConditionCheck(Coordinates curr, Coordinates end){
		return (curr.getCol() == end.getCol() || curr.diagonalCheck(end) || curr.getRow() == end.getRow());
	}
	
	public String printPiece() {
		return super.printPiece() + "Q";
	}
}