//*****************************************
// Dealer.java
// Written by Haizhi Lai
// Date: 11/4/16
// Creates a Dealer class for Blackjack
// Tracks the dealer's hand and points
//*****************************************

import java.util.ArrayList;

public class Dealer {
	
	private ArrayList<Card> dealerHand;
	private int pointSum; 
	private String Face;

	
	public Dealer()
	{	
		pointSum = 0;
		dealerHand = new ArrayList<Card>();
	}
	
	//method for adding cards to dealer's hand
	public void addtoDealer(Deck deck, int amount) 
	{
		for (int i = 0; i < amount; i ++)
		{
			dealerHand.add(deck.drawCard());
		}
	}
	
	//calculate the total point of dealer's hand
	public int getPointSum()
	{
		pointSum = 0;
		for (int i = 0; i < dealerHand.size(); i++)
		{	
			Card currentCard = dealerHand.get(i);  
			pointSum += currentCard.getValue(); 
		}
		
		return pointSum;
	}
	
	public void setPointSum(int number)
	{
		pointSum = number;
	}
	
	public void clearHand()
	{
		dealerHand.clear();
	}
	
	//method allows to reveal dealer's top card
	public String getTopCard()
	{
		return dealerHand.get(0).getFace();
	}
	
	//get the face name of each dealer card (rank of suit)
	public String getFace()
	{
		Face = "";
		for (int i = 0; i < dealerHand.size(); i++)
		{
			Face += dealerHand.get(i).getFace() + "; "; 
		}
		return Face;
	}
	
}//end

