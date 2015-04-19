/**
*Elliott Asher
*2/27/15
*cs 110
*a card class
*Represents a playing card from a 52 card deck
*/
import java.util.*;
import java.io.*;

public class Card
{
	
	//Number representation of card suit and ranks
	final static int SPADES = 1;
	final static int CLUBS = 2;
	final static int HEARTS = 3;
	final static int DIAMONDS = 4;
	final static int ACE = 1;
	final static int TWO = 2;
	final static int THREE = 3;
	final static int FOUR = 4;
	final static int FIVE = 5;
	final static int SIX = 6;
	final static int SEVEN = 7;
	final static int EIGHT = 8;
	final static int NINE = 9;
	final static int TEN = 10;
	final static int JACK = 11;
	final static int QUEEN = 12;
	final static int KING = 13;
	public int rank; 
	public int suit;
	private String imagePath;
	/**
		card constructor
		Takes a rank and a suit and creates a card object
		@param rank the number representation of the rank of the card
			if the rank is not valid, it sets the rank to one
		@param suit the number representation of the suit of the card
			if the suit is not valid it sets the suit to SPADES
		@note see isValidRank and isValidSuit documentation for more details
	*/
	public Card(int rank, int suit)
	{
		if(isValidRank(rank))
		{
			this.rank = rank;
		}
		else 
		{
			this.rank = ACE;
		}
	
		if(isValidSuit(suit))
		{
			this.suit = suit;
		}
		else
		{
			this.suit = SPADES;
		}
	}

	/**
	determines if a number is a represented by a suit
	SPADES is the suit that corrosponds to 1 and diamonds is the 
	suit that corrosponds to 4. The rank must between those numbers.
	@param rank  rank of a card
	@return boolean, wheather or not the rank is valid

	*/
	public boolean isValidSuit(int suit)
	{
		if(suit >= SPADES || suit <= DIAMONDS)
			return true;
		return false;

	}

	/**
		determines if a number is a represented by a rank
	SPADES is the rank that corrosponds to 1 and diamonds is the 
	rank that corrosponds to two. The rank must between those numbers.
	@param rank  rank of a card
	@return boolean, wheather or not the rank is valid

	*/
	public boolean isValidRank(int rank)
	{
		if(rank >= ACE || rank <= KING)
			return true;
		
		return false;
	}
	/**
	gets the suit of the card
	@ return the suit of the card
	*/
	public int getSuit()
	{
		return this.suit;
	}
	/**
	gets the rank of the card
	@return the rank of the card
	*/
	public int getRank()
	{
		return this.rank;
	}
	/**
	determines of another card is equal to this card
	@return true if they are equal
	*/
	public boolean equals(Card otherCard)
	{
		//check to see if ranks are equivilent
		if( otherCard.getRank() == this.getRank())
			return true;
	
		return false;
	}

	public int compareTo(Card otherCard)
	{
		if( this.getRank() > otherCard.getRank())
			return 1;
		else if(this.equals(otherCard))
			return 0;
		else 
			return -1;
	}
	/**
		gets the string representation of a card.
		@reuturn the string repesentation
	*/
	public String toString()
	{
		String suit = "";
		String rank = "";
		
		//set suit to string
		switch (this.getSuit())
		{
			 case SPADES: suit = "Spades"; break;
			 case CLUBS: suit = "Clubs"; break;
			 case HEARTS: suit = "Hearts"; break;
			 case DIAMONDS: suit = "Diamonds"; break; 
		}
		
		//set rank to string
		switch (this.getRank())
		{ 
			 case ACE: rank = "ace";break;
			 case TWO: rank = "Two";break;
			 case THREE:rank = "Three";break;
			 case FOUR: rank = "Four";break;
			 case FIVE: rank = "Five";break;
			 case SIX : rank = "Six";break;
			 case SEVEN:rank = "Seven";break;
			 case EIGHT:rank = "Eight";break;
			 case NINE: rank = "Nine";break;
			 case TEN: rank  = "Ten";break;
			 case JACK: rank = "Jack";break;
			 case QUEEN: rank = "Queen";break;
			 case KING: rank = "King";break;
		}
	
		return String.format("%s of %s",rank,suit); 
	}
	
	public void setImagePath(String path)
	{
		this.imagePath = path;
	}
	public String getImagePath()
	{
		return this.imagePath;
	}

			
}

