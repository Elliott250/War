import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
*gives player jlabels to display player data in gui frame
*/
class GuiPlayer extends Player
{
	JLabel liveCardImage;
	JLabel winnerText;
	JLabel cardsInHand;

	/**
	*creates a GuiPlayer
	*/
	public GuiPlayer()
	{
		super();
		this.liveCardImage = new JLabel();
		this.winnerText = new JLabel();
		this.cardsInHand = new JLabel();
	
	}

	/**
	*sets winner text to "you win this round"
	*
	*/
	public void setToWinner()
	{
		this.setWinnerText("You Win This Round");
	}

	/**
	*sets winner text to text
	*@param text 
	*/
	public void setWinnerText(String text)
	{
		this.winnerText.setText(text);
		this.winnerText.revalidate();
	}
	/**
	*sets cards in hand label to the number of cards in the players hand
	*/
	public void setCardsInHand()
	{
		this.cardsInHand.setText(String.format("You have %d cards",this.getHandSize()));
		this.cardsInHand.revalidate();
	}

	/**
	*gets label that displays the amount of cards in hand
	*@return cardsInHand JLabel that describes the cards in the players hand
	*/
	public JLabel getCardsInHandLabel()
	{
		return this.cardsInHand;
	}

	/**
	*gets label that notifies the winning player
	*@return winnerTest JLabel that notifies the winning player
	*/
	public JLabel getWinnerTextLabel()
	{
		return this.winnerText;  
	}

	/**
	*sets the image of the top live card to be the live card image
	*/
	public void setLiveCardImage()
	{
		this.liveCardImage.setIcon(new ImageIcon(this.lookAtTopLiveCard().getImagePath()));
		this.liveCardImage.revalidate();
	}

	/**
	*gets jlabel for top live card
	*Note, used to place reference to live card when configuring MyFrame
	*@return JLabel holds the current image of a live card 
	*/
	public JLabel getLiveCardImage()
	{
		return this.liveCardImage;
	}
	
	/**
	*sets the back of a card to be the live card image
	*/
	public void setSecretCardImage()
	{
		ImageIcon image = new ImageIcon("../cardpics/back.jpg");

		this.liveCardImage.setIcon(image);
		this.liveCardImage.revalidate();
	}
	
	/**
	*removes any image of a live card
	*/
	public void removeLiveCardImage()
	{
		this.liveCardImage.setIcon(null);
		this.liveCardImage.revalidate();
	}
}