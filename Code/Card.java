import java.util.*;
import java.io.*;

public class Card
{

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

	public boolean isValidSuit(int suit)
	{
		if(suit >= SPADES || suit <= DIAMONDS)
			return true;
		return false;

	}

	public boolean isValidRank(int rank)
	{
		if(rank >= ACE || rank <= KING)
			return true;
		
		return false;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
	
	public int getRank()
	{
		return this.rank;
	}
	
	public boolean equals(Card otherCard)
	{
		if(otherCard.getRank() == this.getRank())
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
