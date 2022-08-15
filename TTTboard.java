import java.util.Scanner;

public class TTTboard {
    /* Class constants
    */
    public static final int SIZE = 3; 
    public static final char EMPTY = ' '; 
    
    /* Attribute: instance variable
	*/
    private final char board[][];
	    
	/* Constructor(s)
	*/
	public TTTboard() {
		board = new char[SIZE][SIZE];
		for (int i=0; i < SIZE; i++)
			for (int j=0; j < SIZE; j++)
				setBoard(i,j,EMPTY);
	}
	

	/* Getters
	*/
    public char getBoard(int row, int col) {
		return board[row][col];
	}

    
    /* Setters
    */
    public void setBoard(int row, int col, char gamePiece) {
        board[row][col] = gamePiece;
    }
    
 
    /* Actions: Instance Methods
    */
	public void displayBoard() {
		System.out.println("Board is: ");
		for (int i=0; i < SIZE; i++) {
			for (int j=0; j < SIZE; j++)
				if (getBoard(i,j) != EMPTY)
					System.out.print(board[i][j] + " ");
			else
				System.out.print("* ");
			System.out.println();
		} 
	}
	
	public boolean isTied() {
		boolean tie = true;
		for (int i=0; i < SIZE && tie; i++)
			for (int j=0; j < SIZE && tie; j++) 
				if (getBoard(i,j) == EMPTY)
					tie = false;
		return(tie);
	}
	
	public char getWinner() {
		char whoWon=EMPTY;
		boolean won=false;
	
		// check for a row win
		for (int i=0; i < SIZE && !won; i++) {
			if ( (getBoard(i,0) == getBoard(i,1)) && (getBoard(i,1) == getBoard(i,2)) && getBoard(i,0) != EMPTY) {
				whoWon = getBoard(i,0);
				won = true;
			}
		}
		
		if (!won) {
			// check for a column win
			for (int i=0; i < SIZE && !won; i++) {
				if ( (getBoard(0,i) == getBoard(1,i)) && (getBoard(1,i) == getBoard(2,i)) && getBoard(0,i) != EMPTY) {
					whoWon = getBoard(0,i);
					won = true;
				}
			}
		}
		
		if (!won) {
			// check for a diagonal win
			if ( (getBoard(0,0) == getBoard(1,1)) && (getBoard(1,1) == getBoard(2,2) && getBoard(1,1) != EMPTY) ||
				(getBoard(0,2) == getBoard(1,1)) && (getBoard(1,1) == getBoard(2,0)) && getBoard(1,1) != EMPTY) {
					whoWon = getBoard(1,1);
					won = true;
			}
		}
		return(whoWon);
	}

}