//*****************************************
//GameTester.java
//Written by Haizhi Lai
//Date: 11/4/16
//Creates the Tester class for Blackjack
//*****************************************

import java.util.Scanner;

public class GameTester {

	public static void main(String[] args) 
	{
		
		Game newGame = new Game();
		newGame.play();
	
		while(newGame.getKeepPlaying()) //while user keeps playing, referees the game
		{
			if (newGame.getLoseStatus() == true) 
			{	
				System.out.println("You lost! Another round? Yes-1 No-0");
				System.out.println("Your current balance: $" + newGame.player.getBalance());
				newGame.playAgain();
			}
			
			else if (newGame.getWinStatus() == true)
			{
				System.out.println("You won! Another round? Yes-1 No-0");
				System.out.println("Your current balance: $" + newGame.player.getBalance());
				newGame.playAgain();
				
			}	
			
			else if (newGame.getTieStatus() == true)
			{
				System.out.println("You tied! Another round? Yes-1 No-0");
				System.out.println("Your current balance: $" + newGame.player.getBalance());
				newGame.playAgain();	
			}	
		}		 		 
	}	
	
}//end
