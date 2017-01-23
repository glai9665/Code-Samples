//*****************************************
// Card.java
// Written by Haizhi Lai
// Date: 11/4/16
// Creates a Card class for Blackjack
// Define each card's properties
//*****************************************



public class Card {

	//initialize instance variables
	private String [] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	private int cardSuit;
	private int cardRank;
	private int cardValue;  
	
	
	public Card(int suitIndex, int rankIndex)//constructor
	{
		this.cardSuit = suitIndex;//assigns the suit of the card
		this.cardRank = rankIndex;//assigns the rank of the card
	} 
	
	
	public String getFace() //return the card's name
	{
		return ranks[cardRank] + " of " + suits[cardSuit];
	}

	public int getRank() 
	{
		return cardRank;
	}
	
	public void setRank(int x) //allows u to reset the rank
	{
		cardValue = x;
	}
		
	public int getValue()
	{
		 if (cardRank > 8) //10, jack, queen, king equal to 10 points
		 {
			 cardValue = 10;
		 }
		 
		 else if (cardRank == 0)
		 {
			 cardValue = 11;
		 }
		 
		 else 
		 {
			 cardValue = cardRank + 1;
		 }
		 
		 return cardValue;
	}

}
