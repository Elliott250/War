import java.util.*;
import java.io.*;

public class Deck
{
	ArrayList<Card> deck;
	String cardImageDirectory;
	public Deck()
	{
		deck = new ArrayList<Card>();
		for(int i = Card.SPADES; i <= Card.DIAMONDS; ++i)
			for(int j = Card.ACE; j <= Card.KING; ++j)
				deck.add(new Card(j,i));
	}

	public Deck(String cardImageDirectory)
	{	
		this.cardImageDirectory = cardImageDirectory;
		deck = new ArrayList<Card>();
		for(int i = Card.SPADES; i <= Card.DIAMONDS; ++i)
		{
			for(int j = Card.ACE; j <= Card.KING; ++j)
			{	
				Card card = new Card(j,i);
				String cardImagePath = getImagePathForCard(card);
				card.setImagePath(cardImagePath);
				deck.add(card);
			}
		}		
	}

	public String getImagePathForCard(Card card)
	{
		String picFileName = CardPicUtil.cardToCardPicFormat(card);
		return String.format("%s/%s",cardImageDirectory,picFileName);
	}
	
}