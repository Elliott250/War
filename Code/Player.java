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

	/**
	*adds card to hand
	*@return true if successful else false
	*/
	public boolean addCard(Card card)
	{
		System.out.println("added card");
		return hand.add(card);
	}

	/**
	*removes card from hand and places into live cards
	*@return card played
	*/
	public Card playCard()
	{
		this.liveCard = true;
		return liveCards.push(hand.remove());
	}

	/**
	*places all live cards from the current player and the loosing player 
	*and places them into the winners deck
	*@param looser the loosing player
	*/
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

	/**
	*when the round is over the player no loger has any live cards
	*set it to false
	*/
	public void roundOver()
	{
		this.liveCard = false;
	}

	/**
	*determins if a player has live cards or not
	*@return bool true if the player has live cards in play
	*/
	public boolean hasLiveCard()
	{
		return this.liveCard;
	}

	/**
	*sets live card.
	*@param bool to set live card
	*/
	public void setLiveCard(boolean bool)
	{
		this.liveCard = bool;
	}

	/**
	*determins if a players hand is empty
	*@return true if hand is empty else false
	*/
	public boolean isEmpty()
	{
		return (hand.peek() == null);
	}
	
	/**
	*gets the number of cards in a players hand
	*@return number of cards in hand.
	*/
	public int getHandSize()
	{
		return this.hand.size();
	}

	/**
	*looks that the top live card
	*@return card the top live card
	*/
	public Card lookAtTopLiveCard()
	{
		return this.liveCards.peek();
	}
}
