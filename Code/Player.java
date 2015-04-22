import java.util.*;
import java.io.*;
import javax.swing.*;

public class Player
{
	Queue<Card> hand = new LinkedList<Card>();
	int cardCount = 0;
	Stack<Card> liveCards = new Stack<Card>();
	boolean liveCard;
	JLabel liveCardImage;
	JLabel winnerText;
	boolean winner;
 
	public Player()
	{
		this.liveCard = false;
		this.winner = false;
		this.liveCardImage = new JLabel();
		this.hand = new LinkedList<Card>();
		this.cardCount = 0;
		this.liveCards = new Stack<Card>();
		this.liveCardImage = new JLabel();
		this.winnerText = new JLabel();
	}

	public void setLiveCardImage()
	{
		this.liveCardImage.setIcon(new ImageIcon(this.lookAtTopLiveCard().getImagePath()));
		this.liveCardImage.revalidate();
	}
	
	public void removeLiveCardImage()
	{
		this.liveCardImage.setIcon(null);
		this.liveCardImage.revalidate();
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
		this.liveCard = true;
		return liveCards.push(hand.remove());
	}

	public void roundOver()
	{
		this.liveCard = false;
	}

	public boolean hasLiveCard()
	{
		return this.liveCard;
	}

	public boolean isEmpty()
	{
		return (hand.peek() == null);
	}

	public int getCount()
	{
		return cardCount;
	}

	public void setToWinner()
	{
		this.winner = true;
		this.setWinnerText("You Win this Round");
	}
	public void setWinnerText(String text)
	{
		this.winnerText.setText(text);
		this.revalidate();
	}

	public JLabel getWinnerTextLabel()
	{
		return this.winnerText;  
	}

	public JLabel getLiveCardImage()
	{
		return this.liveCardImage;
	}

	public Card lookAtTopLiveCard()
	{
		return this.liveCards.peek();
	}

	public void takeWinnings(Player looser)
	{
		while(!looser.liveCards.isEmpty())
		{
			this.addCard(looser.liveCards.pop());
		}
	}
}