package chess;

public class pieceCoordinate {
	
	private int rank, file;

	public pieceCoordinate(int rank, int file) {
		this.rank = rank;
		this.file = file;
	}
	
	public pieceCoordinate(char rank, char file) {
		this.rank = rank - '1';
		this.rank = this.rank * -1 + 7;
		this.file = file - 'a';
		
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setFile(int file) {
		this.file = file;
	}
	
	public int getRank() {
		return this.rank;
	}

	public int getFile() {
		return this.file;
	}
	
	public char getRankChar() {
		return (char) (this.rank + '1');
	}
	
	public char getFileChar() {
		return (char) (this.file + 'a');
	}
	
	public String toString() {
		return Character.toString(getFileChar()) + Character.toString(getRankChar());
	}
	
	public static boolean isValidPromotion(String promote) {
		if (promote.equals("N") || promote.equals("Q") || promote.equals("B") || promote.equals("R")
				|| promote.equals("P"))
			return true;
		else
			return false;

	}
	
	public boolean equals(pieceCoordinate other) {
		return this.rank == other.rank && this.file == other.file;
	}
	
}
