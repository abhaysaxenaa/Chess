package controller;

import java.awt.Color;
import java.util.Scanner;
import controller.ChessController;
import pieces.*;
import java.util.regex.Pattern;
import chess.Coordinates;

public class DrawChessGame {
	
	public ChessController chessController; 
	
	final Pattern movePattern = Pattern.compile("([a-h][1-8]){1} ([a-h][1-8]){1}( [QNRB])?");
	
	public DrawChessGame(ChessController chessController) {
		this.chessController = chessController;
	}
	String currPlayer = chessController.getcurrPlayer();
	
	
	public  void parseInput(String input) {
		
		input = input.toLowerCase().trim();
		
		if (input.equals("draw?")) {
			chessController.isDrawOption = true;
			chessController.flipPlayers();
			
		}
		
		else if(input.equals("draw")) {
			System.out.println("Draw");
			System.exit(0);
		}
		
		else if (input.equals("resign")) {
			chessController.hasEnded = true;
			chessController.flipPlayers();
			if (currPlayer.equals("w")) {
				System.out.println("White wins.");
			} else {
				System.out.println("Black wins.");
			}
		}
		
	}
	
	
	
	/*For reference 
	 *  https://github.com/GalCohen/Chess/blob/master/src/Chess.java
	 * 
	 * public static void parseInput(String input){
		StringTokenizer st = null;
		int count = 0;
		input = input.toLowerCase();
		input = input.trim();
		
		String[] array = new String[100]; 
		 
		st = new StringTokenizer(input);
		 
		while (st.hasMoreTokens()) {
	        array[count] = st.nextToken();
	        count++;
	    }
		
		if (count > 0 && count < 4){
			if (count == 1){
				if (array[0].equals("resign")){
					if (whiteTurn){
						System.out.println("Black wins");
						System.exit(1);
					}else{
						System.out.println("White wins");
						System.exit(1);
					}
					
				}else if (array[0].equals("draw")){
					if (askForDraw == true){
						System.out.println("Draw");
						System.exit(1);
					}else{
						System.out.println("You must ask the opponent if they are willing to call the game a draw first.");
					}
				}else{
					System.out.println("Invalid input. Please try again. ");
				}
			}else if (count == 2) {
				currentLoc = array[0];
				newLoc = array[1];
				if (currentLoc.length() == 2 && newLoc.length() == 2 ){
					
					executeMove();
				}else{
					System.out.println("Invalid input. Please try again.");
				}
				
			}else if (count == 3){
				currentLoc = array[0];
				newLoc = array[1];
				if (currentLoc.length() == 2 && newLoc.length() == 2 ){
					
					if (array[2].equals("draw?")){
						executeMove();
						askForDraw = true;
					}else if (array[2].equals("q") || array[2].equals("r") || array[2].equals("b") || array[2].equals("n")) {
						thirdArgument = array[2];
						executeMove();
					}else{
						System.out.println("Invalid input. Please try again.");
					}
				}else{
					System.out.println("Invalid input. Please try again.");
				}
			}
		}else{
			System.out.println("Invalid input.Please try again.");
		}
		
		currentLoc = null;
		newLoc = null;
		thirdArgument = null;
	}
	
				
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	/*public void processInput() {

		String input = userInput.nextLine().trim();
		
		System.out.println();

		if (input.toLowerCase().contains("resign")) {
			chesscontroller.hasEnded = true;
			chesscontroller.flipPlayers();
		} else if (input.toLowerCase().contains("draw?")) {
			chesscontroller.isDrawOption = true;
			chesscontroller.flipPlayers();
		} else if (input.toLowerCase().compareTo("draw") == 0 && chesscontroller.isDrawOption) {
			System.exit(0);
		}else if (movePattern.matcher(input).matches()) {
			Coordinates start = new Coordinates(input.charAt(1), input.charAt(0)),
					end = new Coordinates(input.charAt(4), input.charAt(3));
			
			ChessPiece promotion = null;
			
			if (input.length() == 7) {
				char promotionChar = input.charAt(6);
				Color pieceColor = chesscontroller.getcurrPlayer() == Color.WHITE ? Color.WHITE : Color.BLACK;
				Case sc = new Case();
				switch (promotionChar) {
				case 'Q': sc.canPromote = new Queen(pieceColor); break;
				case 'N': promotion = new Knight(pieceColor); break;
				case 'B': promotion = new Bishop(pieceColor); break;
				default: promotion = new Rook(pieceColor); break;
				}
			}
			
			gameController.attemptMove(start, end, promotion);
		} else
			System.out.println("Illegal move, try again.");
		
		System.out.println();
	}*/


	/**
	 * prints prompt for user
	 */
	
	public void printNext() {
		if(chessController.getcurrPlayer().equals("White")) {
			System.out.println("White's Move");
		}
		else {
			System.out.println("Black's Move");
		}
	}
	/**
	 * Draws the board
	 */
	public void drawCurrBoard() {
		System.out.println(this.chessController.getBoard().toString());
	
}
}