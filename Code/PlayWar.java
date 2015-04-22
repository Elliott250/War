import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class PlayWar 
{
   public static void main(String [] args) 
   {
      JFrame frame = new MyFrame("New Frame ...");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

   }
}

class MyFrame extends JFrame 
{
   private JPanel p1,p2,p3,p4,p5,p6;
   Player player1;
   Player player2;
   boolean roundWinner = false;
  
   public MyFrame(String s) 
   {
  
      super(s);
      //initiate card game
      Deck deck = new Deck("../cardpics");
      player1 = new Player();
      player2 = new Player();
      
      //deal cards to players
      int count = 0;
      while(!deck.isEmpty())
      {
         if(++count % 2 == 0)
            player1.addCard(deck.deal());
         else
            player2.addCard(deck.deal()); 
      }

      //creat buttons
      ImageIcon image = new ImageIcon("../cardpics/back.jpg");
      JButton backOfCard1 = new JButton(image);
      backOfCard1.addActionListener(new Player1Listener());
      backOfCard1.setFocusable(false);
      JButton backOfCard2 = new JButton(image);  
      backOfCard2.addActionListener(new Player2Listener());
      backOfCard2.setFocusable(false);
     

      // layout of "this" JFrame
      setLayout(new GridLayout(2,3));
       
      // create individual panels to demonstrate layouts
      

      p1 = new JPanel();
      p1.setLayout(new GridLayout(3,1));
      p1.add(new JLabel("Player 1"));
      p1.add(player1.getWinnerTextLabel());
      p1.setBackground(Color.GREEN);

      p2 = new JPanel();
      p2.setLayout(new GridLayout(1,1));
      p2.add(backOfCard1);
      p2.setBackground(Color.GREEN);

      p3 = new JPanel();
      p3.add(player1.getLiveCardImage());
      p3.setBackground(Color.GREEN);

      p4 = new JPanel();
      p4.setLayout(new GridLayout(3,1));
      p4.add(new JLabel("Player 2"));
      p4.add(player2.getWinnerTextLabel());
      p4.setBackground(Color.GREEN);

      p5 = new JPanel();
      p5.setLayout(new GridLayout(1,1));
      p5.add(backOfCard2);
      p5.setBackground(Color.GREEN);

      p6 = new JPanel();
      p6.add(player2.getLiveCardImage());
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
   
   public boolean bothPlayed()
   {
    return (player1.hasLiveCard() && player2.hasLiveCard()); 
   }

   public void determineWinner()
   {
      if(War.determineWinner(player1.lookAtTopLiveCard(),player2.lookAtTopLiveCard()) <  0)
      {
        player1.setToWinner();
        player1.takeWinnings(player2);
      }
      else
      {
        player2.setToWinner();
        player2.takeWinnings(player1);
      }
      
      roundWinner = true;
   }

   public void playCard(Player player)
   {
      if(!player.isEmpty() && !player.hasLiveCard() && !roundWinner)
      {
        player.playCard();
        player.setLiveCardImage();
      }
  
      if(bothPlayed())
      {
        determineWinner();
      }
  }
  
  public void pauseScreen(int sec)
  {
    try
    {
      Thread.sleep(sec);
    }
    catch(Exception ex){}
  }

  class Player1Listener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
    playCard(player1);     
    }
  }

  class Player2Listener implements ActionListener
  {
    public void actionPerformed(ActionEvent e) 
    {
      playCard(player2);
    }
  }

  class Player1WarListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {

    }
  }

 class Player2WarListener implements ActionListener
 {
   public void actionPerformed(ActionEvent e)
    {

    }
 }
 class NewRoundListener implements KeyListener
 {
  
  public void keyPressed(KeyEvent e)
  {
    if(e.getKeyChar() == KeyEvent.VK_ENTER && roundWinner)
    {
      player1.removeLiveCardImage();
      player2.removeLiveCardImage();
      player1.setWinnerText(null);
      player2.setWinnerText(null);
      player1.roundOver(); player2.roundOver();
      roundWinner = false;
    }
  }
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}

 }
}
