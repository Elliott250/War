/**
*utility class used to assign card pictures to a PicCard object
*/
import java.util.*;
import java.io.*;

public class CardPicUtil
{
	/**
	*generates string that matches a card object with its respective picture
	*
	*card picure match example c2.jpg matches a two of clubs
	*@param card 
	*@return path to card
	*/
	public static String cardToCardPicFormat(Card card)
	{
		
		String suit = formatSuit(card);
		String rank = formatRank(card);
		
		return String.format("%s%s.jpg",rank,suit);
	}
	
	/**
	* formats rank of card for its respective picture.
	* @return formatted rank of card 
	*/
	private static String formatRank(Card card)
	{
		String rank = "";

		switch (card.getRank())
		{ 
			 case Card.ACE: rank = "ace";break;
			 case Card.TWO: rank = "2";break;
			 case Card.THREE:rank = "3";break;
			 case Card.FOUR: rank = "4";break;
			 case Card.FIVE: rank = "5";break;
			 case Card.SIX : rank = "6";break;
			 case Card.SEVEN:rank = "7";break;
			 case Card.EIGHT:rank = "8";break;
			 case Card.NINE: rank = "9";break;
			 case Card.TEN: rank  = "10";break;
			 case Card.JACK: rank = "jack";break;
			 case Card.QUEEN: rank = "queen";break;
			 case Card.KING: rank = "king";break;
		}

		return rank;
	}

	/**
	* formats suit of card for its respective picture.
	* @return formatted suit of card 
	*/
	private static String formatSuit(Card card)
	{
		String suit = "";

		switch(card.getSuit())
		{ 
			case Card.SPADES: suit = "s"; break;
			case Card.CLUBS: suit = "c"; break;
			case Card.HEARTS: suit = "h"; break;
			case Card.DIAMONDS: suit = "d"; break;
		}
		
		return suit;
	}
}