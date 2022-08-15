import java.util.Scanner;

public class TTTplayer {
	/* Attributes
	*/
	private char gamePiece;
	private boolean isHuman;
	
	/* Constructor(s)
	*/
	public TTTplayer(char who, boolean human) {
		gamePiece = who;
		if (human) 
                    isHuman = true;
		else 
                    isHuman = false;
	}
	
	public TTTplayer(char who) {
		gamePiece = who;
		isHuman = true;
	}
	
	/* Instance Methods
	*/
	/* Getters
	*/
	public char getGamePiece() {
		return gamePiece;
	}
	
	public boolean isHuman() {
		return isHuman;
	}
	
	/* Setters
	*/
    public void setGamePiece(char gamePiece) {
        this.gamePiece = gamePiece;
    }
    
    public void setIsHuman(boolean value) {
        isHuman = value;
    }
    
    /* Action Methods
    */
    public void makeMove(TTTboard board, Scanner userInput) {
        boolean moveMade=false;
        int row, column;
        boolean illegal;
        
        do {
            illegal = false;
            do {
                System.out.println("Enter the move for player: " + gamePiece);
                System.out.print("\nRow number: ");
                row = userInput.nextInt();
                System.out.print("\nColumn number: ");
                column = userInput.nextInt();
                if (column <= 0 || column > TTTboard.SIZE || row <=0 || row > TTTboard.SIZE) {
                    illegal = true;
                    System.out.println("Illegal row/column: " + row + ", " + column);
                }
                else
                    illegal = false;
            } while (illegal);
            
            if (board.getBoard(row, column) == ' ') {
               board.setBoard(row-1, column-1, gamePiece);
               moveMade = true;
            }
            else
               System.out.println("That position is taken. Try again.");
        } while (!moveMade);
    }

}