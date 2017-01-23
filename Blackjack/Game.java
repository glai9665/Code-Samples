//*****************************************
//Game.java
//Written by Haizhi Lai
//Date: 11/4/16
//Creates the Game class for Blackjack
//Defines the major rules for the game
//*****************************************

import java.util.Scanner;

public class Game 
{
	//initialize instance variables
	public Player player; 
	private Dealer dealer; 
	private Deck gameDeck;
	private boolean win;
	private boolean lose;
	private boolean tie;
	private double bet;
	private boolean keepPlaying;
	
	public Game() //construct a deck, a player, a dealer
	{
		gameDeck = new Deck();
		player = new Player(); 
		dealer = new Dealer();
		keepPlaying = true;
		
		System.out.println("Welcome to Blackjack!");
		System.out.println("You have $100 in balance.");
		
	}
		
		
	public void play() //major rules for the game
	{
		
		 if (player.getBalance() < 10) //balance too low; not allowed to play
		 {
			 System.out.println("Insufficient balance; come back with more money!");
			 keepPlaying = false;
		 }
		 
		 else if (player.getBalance() >= 10)
		 {	
			 
			System.out.println("Now enter a bet between $10 and $1000: ");
			 
			Scanner input = new Scanner(System.in); //player enters the bet	
		    bet = input.nextInt();
		    
		    while (bet < 10 || bet > 1000)
		    {
		    	System.out.println("The bet must be between $10 and $1000.");
		    	System.out.println("Please enter again: ");
		    	bet = input.nextInt();
		    }	 
			 		    
		     //reset conditions before each game
			 win = false; 
		 	 lose = false;
			 tie = false;
			 player.setPointSum(0); 
			 dealer.setPointSum(0);
			 player.clearHand();
			 dealer.clearHand();
			 
			 
			 //shuffles the deck when there are less than 12 cards 
			 if (gameDeck.sizeDeck() < 12) 
			 {
				 gameDeck = new Deck();
				 
			 }
			 
			 //deal two cards to player and dealer each
			 Deal();
			 
			 System.out.println("The dealer's top card is " + dealer.getTopCard());
			 
			//player is in the game while under 21 points
			 while (player.getPointSum() <= 21) 
			 {	 
				 //tells what cards player has
				 System.out.println("You have: " + player.getFace());
				 System.out.println("Would you like to Hit or Stand?  Hit-1 Stand-0 ");
				 Scanner input2 = new Scanner(System.in); 
				 int hitOrstand; //player chooses hit or stand
				 hitOrstand = input2.nextInt();	
				 
				 if (hitOrstand == 1)
				 {
					 player.addtoPlayer(gameDeck, 1); //chooses hit
				 }
				 
				 else if (hitOrstand == 0)
				 {
					 System.out.println("Your total point is: " + player.getPointSum());
					 break;
				 }
			 } 
			
			 
			 if (player.getPointSum() > 21) //if player busts
			 {
				lose = true;	
				player.changeBalance(bet * (-1.0)); //loses bet
			 }	
			 
			 else //if player doesn't bust, dealer's turn
			 {
				//hit while under 16, stand while over
				 while (dealer.getPointSum() <= 16)
				 { 
					 dealer.addtoDealer(gameDeck, 1);
				 }
			 }

				 
		 }
			 
			 if (lose == false) //if player is still in the game
			 {	 
				 if (dealer.getPointSum() > 21) //and dealer busts
				 {
					 win = true; //player wins
					 player.changeBalance(bet * 1.5); //wins 1.5 bet
				 }
				 
				 else if (dealer.getPointSum() <= 21)
				 {	 
					 if (dealer.getPointSum() < player.getPointSum())//and dealer scores lower
					 {
						 win = true; //player wins
						 player.changeBalance(bet * 1.5); //wins 1.5 bet
					 }
						 
					 if (dealer.getPointSum() > player.getPointSum()) //dealer scores higher
					 {
						 lose = true; //player loses
						 player.changeBalance(bet * (-1.0)); //loses the bet
					 }
					 
					 if (dealer.getPointSum() == player.getPointSum()) //dealer scores higher
					 {
						 tie = true; //tie, bet stays the same
					 }
				 } 
			 }	 
		 }
		 
	
	
	public void Deal() //add 2 cards to dealer's hand and player's hand
	{
		player.addtoPlayer(gameDeck, 2);
		dealer.addtoDealer(gameDeck, 2);
	}
	
	public boolean getLoseStatus()
	{
		return lose;
	}
	
	public boolean getWinStatus()
	{
		return win;
	}
	
	public boolean getTieStatus()
	{
		return tie;
	}
	
	//let's user decide whether to play again
	public void playAgain()
	{
		Scanner input3 = new Scanner(System.in);
		int yesOrno;
		yesOrno = input3.nextInt();
		if (yesOrno == 1)
		{
			play(); 
		}
	 
		else if (yesOrno == 0)
		{
			keepPlaying = false;
			System.out.println("Hope that was fun. Have a good day!");
		}
		
		while (yesOrno != 1 && yesOrno != 0)
		{
			System.out.println("Another round? Yes-1 No-0");
			yesOrno = input3.nextInt();

			if (yesOrno == 1)
			{
				play(); 
			}
		 
			else if (yesOrno == 0)
			{
				keepPlaying = false;
				System.out.println("Hope that was fun. Have a good day!");
			}

		}		
	}
		
	public boolean getKeepPlaying()
	{
		return keepPlaying;
	}
	
	
}
