package chess;

import controller.ChessController;
import controller.DrawChessGame;

public class Chess {
	
	public static void main(String[] args) {
		//Create game controller instance
		ChessController chessController = new ChessController();
		//Create game view instance
		DrawChessGame chessgame = new DrawChessGame(chessController);
		
		/*while game does not end (call function in gameController):
		 * Draw a new board
		 * Print prompt
		 * Take in an input
		*/
		while (chessController.hasEnded == false) {
			chessgame.drawCurrBoard();
			chessgame.printNext();
			chessgame.getInput();
		}
		
		String currPlayer = chessController.getcurrPlayer();
		if (currPlayer.equals("w")) {
			System.out.println("White wins.");
		} else {
			System.out.println("Black wins.");
		}
	}
}