//*****************************************
// Deck.java
// Written by Haizhi Lai
// Date: 11/4/16
// Creates a Deck class for Blackjack
// Defines a deck of cards that shuffles itself
//*****************************************

import java.util.ArrayList;
import java.util.*;


public class Deck {

	private ArrayList<Card> carDeck; //initialize deck as an arraylist of Card
	
	
	public Deck() //add 52 cards to the deck
	{	
		carDeck = new ArrayList<Card>();
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 13; j++)
			{	
				carDeck.add(new Card(i,j));
			}
		}
			
		shuffle(); //shuffle the ordered array list of cards
	}
	
	
	public int sizeDeck() //get the size of the deck
	{
		return carDeck.size();
	}
	
	
	public void shuffle() //method to shuffle the deck
	{
		Collections.shuffle(carDeck); 
	}
	
	
	public Card drawCard() //draws the first card in the deck	
	{
		return carDeck.remove(0); 
	}

	
	
}
