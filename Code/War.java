public class War
{
	Player player1;
	Player player2;
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
        player1.setLiveCard(false);
        player2.setLiveCard(false);	
      	player1.setWinnerText("WAR!");
      	player2.setWinnerText("WAR!");
      }
      else if(War.determineWinner(player1.lookAtTopLiveCard(),player2.lookAtTopLiveCard()) <  0)
      {
        player1.setToWinner();
        player1.takeWinnings(player2);

        player1.setCardsInHand();
        player2.setCardsInHand();
      }
      else
      {
        player2.setToWinner();
        player2.takeWinnings(player1);
        player1.setCardsInHand();
        player2.setCardsInHand();
      }
   }

   public void playCard(Player player)
   {
      //play face down card during war
      if(this.war && !player.hasLiveCard())
  	  {
  	  	player.playCard();
  	  	player.setSecretCardImage();
  	  }	  
  	  //start of fresh round
      else if(!player.isEmpty() && !player.hasLiveCard())
      {
        player.playCard();
        player.setLiveCardImage();
      }
      //play first faceup card after war
      else if(this.war && this.bothPlayed())
      {
      	this.war = false;
      	player1.setLiveCard(false);
      	player2.setLiveCard(false);
      	player.playCard();
      	player.setLiveCardImage();
      }
      //determine the winner
      if(this.bothPlayed() && !this.war)
      {
      	this.determineWinner();
      }

  	}
}