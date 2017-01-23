//*****************************************
// Player.java
// Written by Haizhi Lai
// Date: 11/4/16
// Creates a Player class for Blackjack
// Tracks the player's hand and balance
//*****************************************

import java.util.ArrayList;

public class Player {
	
	public ArrayList<Card> playerHand; 
	private int balance;
	private int pointSum; 
	private String Face;

	
	public Player() //constructor
	{
		balance = 100;	
		playerHand = new ArrayList<Card>();
	}
	
	//method for adding a certain amount of cards to the player's hand
	public void addtoPlayer(Deck x, int amount) 
	{
		for (int i = 0; i < amount; i ++)
		{
			playerHand.add(x.drawCard());
		}
	}
	
	//returns the total point of the player's hand
	public int getPointSum()
	{
		pointSum = 0; 
		
		for (int i = 0; i < playerHand.size(); i++)
		{	
			Card currentCard = playerHand.get(i); 
			pointSum += currentCard.getValue(); //add each card's value
		}
		
		if (pointSum > 21) //check to see if there are any Ace to turn to 1
		{
			for (int j = 0; j < playerHand.size(); j++)
			{
				Card currentCard2 = playerHand.get(j);
				if (currentCard2.getRank() == 0) //if it is an Ace
				{
					currentCard2.setRank(1);//set it from 11 to 1
					pointSum -= 10; //subtract 10 from the sum
				}
				
			}
		}
		
		return pointSum; 	
	}
	
	public void setPointSum(int number)
	{
		pointSum = number;
	}
	
	public void clearHand()
	{
		playerHand.clear();
	}
	
	
	public String getFace() //get the face name of each card (rank of suit)
	{
		Face = "";
		for (int i = 0; i < playerHand.size(); i++)
		{
			Face += playerHand.get(i).getFace() + "; "; 
		}
		return Face;
	}
	
	//method that allows for adding or subtracting balance
	public void changeBalance(double d)
	{
		balance += d;
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	
}
