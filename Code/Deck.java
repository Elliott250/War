import java.util.*;
import java.io.*;

public class Deck
{
	ArrayList<Card> deck;
	public Deck()
	{
		deck = new ArrayList<Card>();
		for(int i = Card.SPADES; i <= Card.DIAMONDS; ++i)
			for(int j = Card.ACE; j <= Card.KING; ++j)
				deck.add(new Card(i,j));
		
		this.shuffle();
	}

	public Deck(String cardImageDirectory)
	{	
		deck = new ArrayList<Card>();
		for(int i = Card.ACE; i <= Card.KING; ++i)
		{
			for(int j = Card.SPADES; j <= Card.DIAMONDS; ++j)
			{	
				PicCard card = new PicCard(i,j,cardImageDirectory);
				deck.add(card);
			}
		}		
	
	this.shuffle();
	}
	
	public void shuffle()
	{
		Collections.shuffle(this.deck);
	}

	public ArrayList<Card> getDeck()
	{
		return this.deck;
	}
	public boolean isEmpty()
	{
		return this.deck.isEmpty();
	}
	public Card deal()
	{
		int firstItem = 0;
		Card firstCard = this.deck.get(firstItem);
		this.deck.remove(firstCard);
		return firstCard;

	}





}