import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class GuiPlayer extends Player
{
	JLabel liveCardImage;
	JLabel winnerText;
	JLabel cardsInHand;

	public GuiPlayer()
	{
		super();
		this.liveCardImage = new JLabel();
		this.winnerText = new JLabel();
		this.cardsInHand = new JLabel();
	
	}

	public void setToWinner()
	{
		this.setWinnerText("You Win This Round");
	}

	public void setWinnerText(String text)
	{
		this.winnerText.setText(text);
		this.winnerText.revalidate();
	}

	public void setCardsInHand()
	{
		this.cardsInHand.setText(String.format("You have %d cards",this.getHandSize()));
		this.cardsInHand.revalidate();
	}

	public JLabel getCardsInHandLabel()
	{
		return this.cardsInHand;
	}

	public JLabel getWinnerTextLabel()
	{
		return this.winnerText;  
	}

	public void setLiveCardImage()
	{
		this.liveCardImage.setIcon(new ImageIcon(this.lookAtTopLiveCard().getImagePath()));
		this.liveCardImage.revalidate();
	}

	public JLabel getLiveCardImage()
	{
		return this.liveCardImage;
	}
	
	public void setSecretCardImage()
	{
		ImageIcon image = new ImageIcon("../cardpics/back.jpg");

		this.liveCardImage.setIcon(image);
		this.liveCardImage.revalidate();
	}
	
	public void removeLiveCardImage()
	{
		this.liveCardImage.setIcon(null);
		this.liveCardImage.revalidate();
	}
}