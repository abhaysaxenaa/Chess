/**
 * @author Abhay Saxena (ans192)

 * @author Venkata Sai Karthik Gandrath (vg311)
 */

package chess;

public class Coordinates {
	private int row;
	private int col;
	
	
	/**
	 * Public constructor
	 * @param row 
	 * (type int) 
	 * 
	 * @param col
	 * (type col)
	 */
	public Coordinates(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	
	/**
	 * Sets Row Number
	 * @param row 
	 * (type int)
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/*
	 * Gets Row Number
	 * @return int
	 * returns row
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * Sets Column Number
	 * @param col 
	 * (type int)
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
	/*
	 * Gets Column Number
	 * @return  int
	 */
	public int getCol() {
		return this.col;
	}
	
	/**
	 * 
	 * @param check 
	 * @return boolean 
	 * returns boolean depending on vertical check 
	 */
	//Checks if current coorindate is vertically aligned with argument.
	public boolean verticalCheck(Coordinates check) {
		if (this.getCol() == check.getCol()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param check 
	 * @return boolean 
	 * returns boolean depending on horizontal check 
	 */
	
	//Checks if current coorindate is horizontally aligned with argument.
	public boolean horizontalCheck(Coordinates check) {
		if (this.getRow() == check.getRow()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param check
	 * @return boolean 
	 * returns boolean depending on diagonal check 
	 */
	//Checks if current coordinate is diagonal to the argument coordinate.
	public boolean diagonalCheck(Coordinates check) {
		if (this.verticalCheck(check)) return false;
		if ((check.col - this.col) / (check.row - this.row) == 1 || (check.col - this.col) - (check.row - this.row) == -1){
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param check 
	 * @return boolean 
	 * returns boolean depending on adjacency check 
	 */
	//Checks if current coordinate is adjacent to thee argument coordinate.
	public boolean adjacencyCheck(Coordinates check) {
		if (this.row <= check.row + 1 && this.row >= check.row - 1) {
			if (this.col <= check.col + 1 && this.col >= check.col - 1) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param check 
	 * @return boolean 
	 * returns boolean depending on coordinates check 
	 */
	//Checks if coordinates are out of bounds. 
	public boolean checkBoardLimits(Coordinates check) {
		return ((check.getRow() < 0 || check.getCol() < 0) || (check.getRow() >= 8 || check.getCol() >= 8) ||
				(this.getRow() < 0 || this.getCol() < 0) || (this.getRow() >= 8 || this.getCol() >= 8));
	}
	
	/**
	 * 
	 * @param promote
	 * @return boolean
	 */
	
	//Call Promote check directly
	public static boolean isPromoted(String promote) {
		if (promote.equals("P") || promote.equals("N") || promote.equals("Q") || promote.equals("B")
				|| promote.equals("R"))
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @param piece]
	 * @return int 
	 * returns distance between two squares
	 */
	//Considers diagonal distances to give the distance between two coordinates using the Pythagorean Theorem.
	public int calculateDistance(Coordinates piece) {
		int xDist = piece.row - this.row, yDist = piece.col - this.col;
		int xDisplacement = xDist * xDist, yDisplacement = yDist * yDist;
		int distSq = yDisplacement - xDisplacement;
		return (int) Math.sqrt(distSq);
	}
	
	
	/**
	 * @return String 
	 * returns string of the column number and the row number 
	 */
	//Prints out the character of the column number and the row number
	public String toString() {
		return (Character.toString((char)(this.col + 'a')) + Character.toString((char)(this.row + '1')));
	}
	
	
	
}