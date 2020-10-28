package controller;

import java.awt.Color;
import java.util.Scanner;
import controller.ChessController;
import pieces.*;
import java.util.regex.Pattern;
import chess.Coordinates;

public class DrawChessGame {
	
	public ChessController chessController;
	public boolean drawCondition;
	final Pattern movePattern = Pattern.compile("([a-h][1-8]){1} ([a-h][1-8]){1}( [QNRB])?");
	Scanner inputText = new Scanner(System.in);
	
	public DrawChessGame(ChessController chessController) {
		this.chessController = chessController;
	}
	
	public void drawCurrBoard() {
		System.out.println(this.chessController.getBoard().printBoard());
	}
	
	public void printNext() {
		if (chessController.getcurrPlayer().equals("White")) {
			System.out.println("White's move: ");
		} else {
			System.out.println("Black move: ");
		}
		
	}
	
	public void getInput() {
		String parsedText = inputText.nextLine().trim().toLowerCase();
		System.out.println();
		
		if (parsedText.contains("resign")) {
			chessController.hasEnded = true;
			Switch();
		} else if (parsedText.contains("draw?")) {
			drawCondition = true;
			Switch();
		} else if (parsedText.equals("draw") && (drawCondition == true)) {
			System.exit(0);
		} else if (movePattern.matcher(parsedText).matches()) {
			
			Coordinates curr = new Coordinates(parsedText.charAt(1), parsedText.charAt(0));
			Coordinates end = new Coordinates(parsedText.charAt(4), parsedText.charAt(3));
			
			ChessPiece promote = null;
			
			if (parsedText.length() == 7) {
				char promotionChar = parsedText.charAt(6);
				String pieceColor = chessController.getcurrPlayer().equals("White") ? "White" : "Black";
				switch (promotionChar) {
				case 'Q': promote = new Queen(pieceColor); break;
				case 'N': promote = new Knight(pieceColor); break;
				case 'B': promote = new Bishop(pieceColor); break;
				default: promote = new Rook(pieceColor); break;
			}
		}
			
			chessController.makeMove(curr, end, promote);
	} else {
			System.out.println("Illegal move, try again.");
			System.out.println();
		}
	}
	
	public void Switch() {
		chessController.flipPlayers();
	}
}