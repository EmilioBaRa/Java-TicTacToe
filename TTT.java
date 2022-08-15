import java.util.Scanner;
import java.util.Random;


public class TTT {
    static final int SIZE = 3;
    /*
        Declare a 2-d character array called board with SIZE rows and SIZE columns.
        Be sure to use the static modifier in the declaration.
    */
	static char[][] board = new char[SIZE][SIZE];

    static final char PLAYER1 = 'X';
    static final char PLAYER2 = 'O';
    static Scanner userInput = new Scanner(System.in);
    
    public static void initializeBoard() {
        /*
            Initialize each position of the board array to a space character.
        */
        for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = ' ';	
			}	
		}
    }
    
    public static void displayBoard() {
        /*
            Displays the tic-tac-toe board
            to the screen. If a board position is available, that is, if it is
            a space, output an asterisk followed by a space ("* ".)
        */
        System.out.println("Board is: ");
        for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				if(board[i][j] == ' '){
					System.out.print("*" + board[i][j]);
				}
				else{
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
		}
    }
    
    /*
        The method will return true if the game is tied and
        false otherwise.
        The method assumes that there is no winning pattern on the board.
    */
	
	public static boolean isTied(){
		boolean tieBoard = true;
		
		//This will check if the game is completed 
		for(int i = 0; i < board.length; i++){ 
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == ' '){
					tieBoard = false;
				}
			}
		}
		
		return tieBoard;
	}
 
 
    
    public static void playerMove(char player) {
        /*
            This method makes a move for the
            player indicated by the formal parameter.
            Prompt the user to enter a row and column until they
            enter a legal row and column (The row and column must
            be between 1 and 3, inclusive.)
            
            If, once a legal row and column has been entered,
            the specified position is already occupied (ie not a space)
            then inform the user and prompt them to enter another
            row and column.
        */
		int i;
		int j;
		int row;
		int column;
		boolean invalidRowColumn = true; 
		
		do{
			System.out.println("Enter the move for player: " + player);
			System.out.print("\nRow number: ");
			i = userInput.nextInt();
			
			System.out.print("\nColumn number: ");
			j = userInput.nextInt();
			
			row = i - 1;
			column = j - 1;
			
			if((row > 2) || (row < 0) || (column > 2) || (column < 0)){
				System.out.println("Illegal row/column: " + i + ", " + j);	
			}
			else if (board[row][column] != ' '){
				System.out.println("That position is taken. Try again.");
			}
			else{
				invalidRowColumn = false;
				board[row][column] = player;		
			}
			
        }while(invalidRowColumn);
    }
    
    public static char getWinner() {
        /*
            Returns a character indicating which player has won.
            If no player has won, the method will return a space.
            The check for a row win has been done for you.
            You must write the checks for a column win and a diagonal win.
        */
        char whoWon=' ';
        boolean won=false;
        
        // check for a row win
		for (int i=0; i < SIZE && !won; i++) {
			if ( (board[i][0] == board[i][1]) && (board[i][1] == board[i][2]) && board[i][0] != ' ') {
				whoWon = board[i][0];
                won = true;
			}
		}
			
		// check for a column win
        for (int i=0; i < SIZE && !won; i++) {
			if ( (board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && board[0][i] != ' ') {
				whoWon = board[0][i];
                won = true;
			}
		}    
        
      // check for a diagonal win
		if ( (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && board[0][0] != ' ') {
				whoWon = board[0][0];
		}    
		else if ( (board[2][0] == board[1][1]) && (board[1][1] == board[0][2]) && board[2][0] != ' ') {
				whoWon = board[2][0];
		}    
            
        return(whoWon);
    }
    

    
    public static void main(String args[]) {
        char whoWon;
        boolean won, tie;
        String again;
        
        do {
            won = false;
            tie = false;
            initializeBoard();
            System.out.println("Welcome to TicTacToe.");
            displayBoard();
            
            do {
                playerMove(PLAYER1);
                displayBoard();
            
                whoWon = getWinner();

                if (!(whoWon == ' '))
                    won = true;
            
                if (!won)
                    tie = isTied();

                if (!won && !tie) {
                    playerMove(PLAYER2);
                    displayBoard();
                }
                
                whoWon = getWinner();
                if (!(whoWon == ' '))
                    won = true;
                if (!won)
                    tie = isTied();
            } while (!won && !tie);
            
            if (tie) 
                System.out.println("Tie game.");
            else if (whoWon == PLAYER1)
                System.out.println("Player 1 wins.(" + PLAYER1 + ")");
            else
                System.out.println("Player 2 wins.(" + PLAYER2 + ")");
            
            System.out.print("Care to play again? (y/n) ");
            again = userInput.next();
        } while (again.equalsIgnoreCase("y")); 
    }
}