import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class PlayWar 
{
	public static void main(String [] args) 
	{
		JFrame frame = new MyFrame("War");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

class MyFrame extends JFrame 
{
	private JPanel p1,p2,p3,p4,p5,p6;
	War war;

	public MyFrame(String s) 
	{

		super(s);
		//initiate card game
		this.war = new War();      

		//creat buttons
		ImageIcon image = new ImageIcon("../cardpics/back.jpg");
		JButton backOfCard1 = new JButton(image);
		backOfCard1.addActionListener(new Player1Listener());
		backOfCard1.setFocusable(false);
		JButton backOfCard2 = new JButton(image);  
		backOfCard2.addActionListener(new Player2Listener());
		backOfCard2.setFocusable(false);

		setLayout(new GridLayout(2,3));

		//Block for Player 1 game data
		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(new JLabel("Player 1"));
		p1.add(this.war.getPlayer1().getWinnerTextLabel());
		p1.add(this.war.getPlayer1().getCardsInHandLabel());
		p1.setBackground(Color.GREEN);

		//block for player1's deck of cards
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1,1));
		p2.add(backOfCard1);
		p2.setBackground(Color.GREEN);

		//block for player1's face up cards
		p3 = new JPanel();
		p3.add(this.war.getPlayer1().getLiveCardImage());
		p3.setBackground(Color.GREEN);

		//Block for Player 2 game data
		p4 = new JPanel();
		p4.setLayout(new GridLayout(3,1));
		p4.add(new JLabel("Player 2"));
		p4.add(this.war.getPlayer2().getWinnerTextLabel());
		p4.add(this.war.getPlayer2().getCardsInHandLabel());
		p4.setBackground(Color.GREEN);

		//block for player2's deck of cards
		p5 = new JPanel();
		p5.setLayout(new GridLayout(1,1));
		p5.add(backOfCard2);
		p5.setBackground(Color.GREEN);

		//block for player2's face up cards
		p6 = new JPanel();
		p6.add(this.war.getPlayer2().getLiveCardImage());
		p6.setFocusable(false);
		p6.setBackground(Color.GREEN);

		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);
		addKeyListener(new NewRoundListener()); 
		setFocusable(true);
	}

	class Player1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			war.playCard(war.getPlayer1());     
			war.checkForLoser(war.getPlayer1());
		}
	}

	class Player2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			war.playCard(war.getPlayer2());
			war.checkForLoser(war.getPlayer2());
		}
	}

	class NewRoundListener implements KeyListener
	{
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyChar() == KeyEvent.VK_ENTER && war.roundWinner)
			{
				war.getPlayer1().removeLiveCardImage();
				war.getPlayer2().removeLiveCardImage();
				war.getPlayer1().setWinnerText(null);
				war.getPlayer2().setWinnerText(null);
				war.getPlayer1().roundOver(); war.getPlayer2().roundOver();
				war.roundWinner = false;
			}
		}

	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

	}
}
