public class War
{

	public static boolean determineWar(Card card1, Card card2)
	{
		return card1.equals(card2);
	}

	public static Card determineWinner(Card card1, Card card2)
	{
		if(card1.compareTo(card2) > 0)
			return card1;
		else 
			return card2;
	}

}