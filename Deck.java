import java.util.*;
import java.io.*;

public class Deck
{
	ArrayList<Card> deck;

	public Deck()
	{
		deck = new ArrayList<Card>();
		for(int i = Card.SPADES; i < Card.DIAMONDS; ++i)
			for(int j = Card.ONE; j < Card.ACE; ++j)
				deck.add(new Card(j,i));
	}

	public static ArrayList<String> getListOfCardPicsFrom(String pathToDirectory)
	{
		File folder = new File(pathToDirectory);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> listOfCardPics = new ArrayList<String>();
		for(int i = 0; i < listOfFiles.length; ++i)
		{
			listOfCardPics.add(String.format("%s/%s",pathToDirectory,listOfFiles[i].getName()));
		}

		return listOfCardPics;
	}
	public void assignPicturesToDeck(String pathToDirectory)
	{
		ArrayList<String> listOfFiles = getListOfCardPicsFrom(pathToDirectory);

			
	}
	public static String cardToCardPicFormat(Card c)
	{
		/*
			final static int SPADES = 1;
			final static int CLUBS = 2;
			final static int HEARTS = 3;
			final static int DIAMONDS = 4;
		*/
		HashMap<Integer,String> numberToSuit = new HashMap<Integer,String>();
		numberToSuit.set(Card.SPADES, "s");
		numberToSuit.set(Card.CLUBS, "c");
		numberToSuit.set(Card.HEARTS,"h");
		numberToSuit.st(Card.DIAMONDS,"d");
		
	}
	public static void main(String[] args)
	{
		ArrayList<String> cardPics = getListOfCardPicsFrom("cardpics");
		for(String s : cardPics)
			System.out.println(s);
	}



}