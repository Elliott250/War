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
   // create panel containers
   private JPanel p1,p2,p3,p4,p5,p6;
   Player player1;
   Player player2;
   
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
      JButton backOfCard2 = new JButton(image);  
      backOfCard2.addActionListener(new Player2Listener());

     

      // layout of "this" JFrame
      setLayout(new GridLayout(2,3));
       
      // create individual panels to demonstrate layouts
      

      p1 = new JPanel();
      p1.setBackground(Color.BLUE);
      p1.setLayout(new GridLayout(3,1));
      p1.add(new JLabel("Player 1"));
      p1.add(player1.getWinnerTextLabel());


      p2 = new JPanel();
      p2.setBackground(Color.RED);
      p2.setLayout(new GridLayout(1,1));
      p2.add(backOfCard1);

      p3 = new JPanel();
      p3.add(player1.getLiveCardImage());


      p4 = new JPanel();
      p4.setLayout(new GridLayout(3,1));
      p4.add(new JLabel("Player 2"));
      p4.add(player2.getWinnerTextLabel());


      p5 = new JPanel();
      p5.setBackground(Color.GREEN);
      p5.setLayout(new GridLayout(1,1));
      p5.add(backOfCard2);
    
      p6 = new JPanel();
      p6.add(player1.getLiveCardImage());

    

      add(p1);
      add(p2);
      add(p3);
      add(p4);
      add(p5);
      add(p6);     
   }
   
   public boolean bothPlayed()
   {
    return (player1.hasLiveCard() && player2.hasLiveCard()); 
   }

   public void determineWinner()
   {
      if(War.determineWinner(player1.lookAtTopLiveCard(),player2.lookAtTopLiveCard()) <  0)
        player1.setWinnerText("You are the winner!");
      else
        player2.setWinnerText("You are the winner!");
   }

   public void playCard(Player player)
   {
      if(!player.isEmpty() && !player.hasLiveCard())
      {
        player.playCard();
        player.setLiveCardImage();
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
      public void actionPerformed (ActionEvent e) 
      {
         playCard(player1);
         /*
         if(!player1.isEmpty() && !cardPlayed1)
         {
           liveCards1.push(player1.playCard());
           ImageIcon image = new ImageIcon(liveCards1.peek().getImagePath());
           liveCard1.setIcon(image);    
         }
        
        if(bothPlayed())
        {
          determineWinner(); 
        }
        */
   
      }
      
   }
   
   class Player2Listener implements ActionListener
   {
      public void actionPerformed (ActionEvent e) 
      {
        playCard(player2);
        /*
         if(!player2.isEmpty() && !cardPlayed2)
         {
            liveCards2.push(player2.playCard());
            ImageIcon image = new ImageIcon(liveCards2.peek().getImagePath());
            liveCard2.setIcon(image);    
          //  cardPlayed2 = true;
         }   
        */
      }
   }

}
