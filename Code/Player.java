import java.util.*;
import java.io.*;
import javax.swing.*;

public class Player
{
	boolean liveCard;
	Queue<Card> hand = new LinkedList<Card>();
	Stack<Card> liveCards = new Stack<Card>();

	public Player()
	{
		this.liveCard = false;
		this.hand = new LinkedList<Card>();
		this.liveCards = new Stack<Card>();
	}

	public boolean addCard(Card card)
	{
		System.out.println("added card");
		return hand.add(card);
	}

	public Card playCard()
	{
		this.liveCard = true;
		return liveCards.push(hand.remove());
	}

	public void takeWinnings(Player looser)
	{
		while(!looser.liveCards.isEmpty())
		{
			this.addCard(looser.liveCards.pop());

		}
		while(!this.liveCards.isEmpty())
		{
			this.addCard(this.liveCards.pop());
		}
	}

	public void roundOver()
	{
		this.liveCard = false;
	}

	public boolean hasLiveCard()
	{
		return this.liveCard;
	}

	public void setLiveCard(boolean bool)
	{
		this.liveCard = bool;
	}

	public boolean isEmpty()
	{
		return (hand.peek() == null);
	}

	public int getHandSize()
	{
		return this.hand.size();
	}

	public Card lookAtTopLiveCard()
	{
		return this.liveCards.peek();
	}
}
