class PicCard extends Card
{

	String imagePath;
	String cardImageDirectory;
	public PicCard(int rank, int suit, String cardImageDirectory)
	{
		super(rank,suit);
		this.cardImageDirectory = cardImageDirectory;
		String cardImagePath = getImagePathForCard();
		this.setImagePath(cardImagePath);
	}

	public String getImagePathForCard()
	{
		String picFileName = CardPicUtil.cardToCardPicFormat(this);
		return String.format("%s/%s",cardImageDirectory,picFileName);
	}

	public void setImagePath(String path)
	{
		this.imagePath = path;
	}

	public String getImagePath()
	{
		return this.imagePath;
	}

}