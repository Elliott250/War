import java.util.*;
import java.io.*;

public class Player
{
	Queue<Card> hand = new LinkedList<Card>();
	int cardCount = 0;
	public Player()
	{

	}

	/**
	*adds card to hand
	*@return true if successful else false
	*/

	public boolean addCard(Card card)
	{
		++cardCount;
		return hand.offer(card);
	}


	public Card playCard()
	{
		--cardCount;
		return hand.remove();
	}

	public boolean isEmpty()
	{
		return (hand.peek() == null);
	}
	public int getCount()
	{
		return cardCount;
	}

}