public class War
{
	Deck cardDeck;
	Player player1;
	Player player2;

	public War()
	{
		player1 = new Player();
		player2 = new Player();
		cardDeck = new Deck("../cardpics");
		int dealCount = 0;
	
		while(!cardDeck.isEmpty())
		{
			 if(dealCount % 2 == 0)
			 	player1.addCard(cardDeck.deal());
			 else
			 	player2.addCard(cardDeck.deal());
		}
	
	}


}