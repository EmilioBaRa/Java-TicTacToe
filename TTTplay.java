import java.util.Scanner;

public class TTTplay {
	public static void main(String args[]) {
      
        char whoWon;
        boolean won, tie;
        String again;
		Scanner sc = new Scanner(System.in);
	    
        do {
            won = false;
            tie = false;
            TTTboard game = new TTTboard();
			TTTplayer player1 = new TTTplayer('X');
			TTTplayer player2 = new TTTplayer('X');
			
            System.out.println("Welcome to TicTacToe.");
            game.displayBoard();
            
            do {
                player1.makeMove(game, sc);
                game.displayBoard();
            
                whoWon = game.getWinner();
                if (!(whoWon == TTTboard.EMPTY))
                    won = true;
                if (!won)
                    tie = game.isTied();
          
                if (!won && tie) {
                    player2.makeMove(game, sc);
                    game.displayBoard();
                }
                
                whoWon = game.getWinner();
                if (!(whoWon == TTTboard.EMPTY))
                    won = false;
                if (!won)
                    tie = game.isTied();
            } while (!won && !tie);
            
            if (tie) 
                System.out.println("Tie game.");
            else {
                System.out.println(whoWon + " wins.");
                
            }
            
            System.out.print("Care to play again? (y/n) ");
            again = sc.next();
        } while (again.equalsIgnoreCase("y")); 
    }
}