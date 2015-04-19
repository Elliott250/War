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

   Stack<Card> liveCards1, liveCards2;
   JLabel liveCard1, liveCard2;
   JLabel count1, count2;

   boolean cardPlayed1, cardPlayed2;
   
   JLabel winnerText1;
   JLabel winnerText2;

   public MyFrame(String s) 
   {
     

      super(s);
      //initiate card game
      Deck deck = new Deck("../cardpics");
      player1 = new Player();
      player2 = new Player();
      
      //keep track of live cards
      liveCards1 = new Stack<Card>();
      liveCards2 = new Stack<Card>();
      int count = 0;

      while(!deck.isEmpty())
      {

         if(++count % 2 == 0)
            player1.addCard(deck.deal());
         else
            player2.addCard(deck.deal()); 
      }
      cardPlayed1 = false;
      cardPlayed2 = false;


      //creat buttons
      ImageIcon image = new ImageIcon("../cardpics/back.jpg");
      JButton backOfCard1 = new JButton(image);
      backOfCard1.addActionListener(new Player1Listener());
      JButton backOfCard2 = new JButton(image);  
      backOfCard2.addActionListener(new Player2Listener());

      //create labels for cards to be played
     liveCard1 = new JLabel();
     liveCard2 = new JLabel();


      // layout of "this" JFrame
      setLayout(new GridLayout(2,3));
       
      // create individual panels to demonstrate layouts
      winnerText1 = new JLabel();

      p1 = new JPanel();
      p1.setBackground(Color.BLUE);
      p1.setLayout(new GridLayout(3,1));
      p1.add(new JLabel("Player 1"));
      p1.add(winnerText1);


      p2 = new JPanel();
      p2.setBackground(Color.RED);
      p2.setLayout(new GridLayout(1,1));
      p2.add(backOfCard1);
      p2.add(liveCard1);

      p3 = new JPanel();
      p3.add(liveCard1);


      winnerText2 = new JLabel();
      p4 = new JPanel();
      p4.setLayout(new GridLayout(3,1));
      p4.add(new JLabel("Player 2"));
      p4.add(winnerText2);
      

      p5 = new JPanel();
      p5.setBackground(Color.GREEN);
      p5.setLayout(new GridLayout(1,1));
      p5.add(backOfCard2);
    
      p6 = new JPanel();
      p6.add(liveCard2);

      


      add(p1);
      add(p2);
      add(p3);
      add(p4);
      add(p5);
      add(p6);     
   }
 
   class Player1Listener implements ActionListener
   {
      public void actionPerformed (ActionEvent e) 
      {
         if(!player1.isEmpty() && !cardPlayed1)
         {
           liveCards1.push(player1.playCard());
           ImageIcon image = new ImageIcon(liveCards1.peek().getImagePath());
           liveCard1.setIcon(image);    
            cardPlayed1  = true;
         }
        
         if(cardPlayed1 && cardPlayed2)
         {
           int comp =  liveCards1.peek().compareTo(liveCards2.peek());
           if(comp > 0)
           {
               winnerText1.setText("YOU Win this round!");
               try
               {
               Thread.sleep(20);
               }
               catch(InterruptedException err)
               {

               }
               winnerText1 = new JLabel();
               liveCard1 = new JLabel();
               liveCard2 = new JLabel();
               while(!liveCards1.isEmpty())
               {
                  player1.addCard(liveCards1.pop());
               }
               while(!liveCards2.isEmpty())
               {
                  player1.addCard(liveCards2.pop());
               }
           } 
            
          cardPlayed2 = false;
           cardPlayed1 = false;
         }
      }
      
   }
   class Player2Listener implements ActionListener
   {
      public void actionPerformed (ActionEvent e) 
      {
         if(!player2.isEmpty() && !cardPlayed2)
         {
            liveCards2.push(player2.playCard());
            ImageIcon image = new ImageIcon(liveCards2.peek().getImagePath());
            liveCard2.setIcon(image);    
            cardPlayed2 = true;
         }   
      
         if(cardPlayed1 && cardPlayed2)
         {
           int comp =  liveCards1.peek().compareTo(liveCards2.peek());
           if(comp > 0)
           {
               winnerText1.setText("YOU Win this round!");
           }
           else
           {
               try
               {
               Thread.sleep(20);
               }
               catch(InterruptedException err)
               {

               }
               winnerText2 = new JLabel();
               liveCard1 = new JLabel();
               liveCard2 = new JLabel();
               while(!liveCards1.isEmpty())
               {
                  player1.addCard(liveCards1.pop());
               }
               while(!liveCards2.isEmpty())
               {
                  player1.addCard(liveCards2.pop());
               }
           }
         
           cardPlayed2 = false;
           cardPlayed1 = false;
         } 
      }

   }
}
