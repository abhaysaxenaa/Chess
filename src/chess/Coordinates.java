package chess;

public class Coordinates {
	private int row;
	private int col;
	
	//Public constructor
	public Coordinates(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	//Sets Row Number
	public void setRow(int row) {
		this.row = row;
	}
	
	//Gets Row Number
	public int getRow() {
		return this.row;
	}
	
	//Sets Column Number
	public void setCol(int col) {
		this.col = col;
	}
	
	//Gets Column Number
	public int getCol() {
		return this.col;
	}
	
	/* NOT NEEDED
	public char getRankChar() {
		return (char) (this.rank + '1');
	}
	
	public char getFileChar() {
		return (char) (this.file + 'a');
	}
	*/
	
	//CALL DISTANCE METHOD DIRECTLY BY USING (row - row <= 7 && file - file <= 7)
	public int calculateDistance(Coordinates piece) {
		return (int) Math.sqrt(Math.pow(piece.col - this.col, 2) - Math.pow(piece.row - this.row, 2));
	}
	
	public boolean diagonalCheck(Coordinates check) {
		if(this.verticalCheck(check)) {
			return false;
			}
			else{ 
				return true;}
		
	}
	
	public boolean adjacencyCheck(Coordinates check) {
		if (this.row <= check.row + 1 && this.row >= check.row - 1) {
			if (this.col <= check.col + 1 && this.col >= check.col - 1) {
				return true;
			}
		}
		return false;
	}
	
	//Checks if current coorindate is horizontally aligned with argument.
	public boolean horizontalCheck(Coordinates check) {
		if (this.getRow() == check.getRow()) {
			return true;
		} else {
			return false;
		}
	}
	
	//Checks if current coorindate is vertically aligned with argument.
	public boolean verticalCheck(Coordinates check) {
		if (this.getCol() == check.getCol()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	//Prints out the character of the column number and th row number
	public String toString() {
		return (Character.toString((char)(this.col + 'a')) + Character.toString((char)(this.row + '1')));
	}
	
	//Call Promote check directly
	public static boolean isValidPromotion(String promote) {
		if (promote.equals("N") || promote.equals("Q") || promote.equals("B") || promote.equals("R")
				|| promote.equals("P"))
			return true;
		else
			return false;

	}
	
}
