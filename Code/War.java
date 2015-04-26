public class War
{
	Player player1;
	Player player2;
	boolean roundWinner = false;
    boolean war = false;

    public War()
    {
      player1 = new Player();
      player2 = new Player();

      //deal cards to players
      Deck deck = new Deck("../cardpics");

      int count = 0;
      while(!deck.isEmpty())
      {
         if(++count % 2 == 0)
            player1.addCard(deck.deal());
         else
            player2.addCard(deck.deal()); 
      }

    }

    public Player getPlayer1()
    {
    	return this.player1;
    }

    public Player getPlayer2()
    {
    	return this.player2;
    }

	public static boolean determineWar(Card card1, Card card2)
	{
		return card1.equals(card2);
	}

	public static int determineWinner(Card card1, Card card2)
	{
		if(card1.compareTo(card2) > 0)
			return -1;
		else 
			return 1;
	}

	public boolean bothPlayed()
    {
    	return (player1.hasLiveCard() && player2.hasLiveCard()); 
    }

   public void determineWinner()
   {
      this.war = War.determineWar(player1.lookAtTopLiveCard(),player2.lookAtTopLiveCard());
      if(this.war)
      {
        player1.playWar();
        player2.playWar();
        
        roundWinner = false;
      }
      else if(War.determineWinner(player1.lookAtTopLiveCard(),player2.lookAtTopLiveCard()) <  0)
      {
        player1.setToWinner();
        player1.takeWinnings(player2);

        player1.setCardsInHand();
        player2.setCardsInHand();
        roundWinner = true;

      }
      else
      {
        player2.setToWinner();
        player2.takeWinnings(player1);
        player1.setCardsInHand();
        player2.setCardsInHand();
        roundWinner = true;

      }
   }
   public void playCard(Player player)
   {
      if(!player.isEmpty() && !player.hasLiveCard() && !roundWinner)
      {
        player.playCard();
        player.setLiveCardImage();
      }
  
      if(this.bothPlayed())
      {
        this.determineWinner();
      }
  	}



}