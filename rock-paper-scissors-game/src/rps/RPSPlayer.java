package rps;

public class RPSPlayer {
	private int score;
	private int hand;
	private String lastOutcome;
	
	public RPSPlayer()
	{
		this.score=0;
	}
	
	public void play(RPSPlayer opponent)
	{
		if ( this.hand == opponent.getHand() ) 					// Draw.
		{
			this.draw(opponent);								// Win conditions:
		} else if (	this.hand == 1 && opponent.getHand() == 3	// -rock vs. scissors
				|| 	this.hand == 2 && opponent.getHand() == 1	// -paper vs. rock
				|| 	this.hand == 3 && opponent.getHand() == 2 )	// -scissors vs. paper
		{
			this.win(opponent);
		} else 													// Loss otherwise
		{
			opponent.win(this);
		}
	}
	
	public void win(RPSPlayer opponent)
	{
		this.incrementScore();
		this.lastOutcome = "Gagné";
		
		opponent.setLastOutcome("Perdu");
	}
	
	public void draw(RPSPlayer opponent)
	{
		this.lastOutcome = "Match nul";
		opponent.setLastOutcome( this.lastOutcome );
	}
	
	/**
	 * Converts a choice in the form of a number to its corresponding string.
	 * 
	 * @param choice int between 1 and 3
	 * @return "pierre" if choice is 1, "papier" if 2, "ciseaux" otherwise
	 */
	public String getHandString()
	{
		String handString;

		if (this.hand == 1) {
			handString = "pierre";
		} else if (this.hand == 2) {
			handString = "papier";
		} else {
			handString = "ciseaux";
		}

		return handString;
	}
	
	public void setRandomHand()
	{
		this.hand = (int) (3 * Math.random() + 1);
	}
	
	private void incrementScore()
	{
		this.score++;
	}
	
	/** SETTERS **/
	
	public void setLastOutcome(String outcome)
	{
		this.lastOutcome = outcome;
	}
	
	public String getLastOutcome()
	{
		return this.lastOutcome;
	}
	
	public void setHand(int hand)
	{
		this.hand = hand;
	}
	
	public int getHand()
	{
		return this.hand;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	/**
	 * Asks user to enter one of three options: "pierre", "papier", or "ciseaux".
	 * If anything else is entered, keeps asking.
	 * 
	 * @return int : 1 for "pierre", 2 for "papier", 3 for "ciseaux"
	 */
	public void setHand(String handString) throws IllegalArgumentException
	{
		handString = handString.toLowerCase();
		
		if (handString.startsWith("pi")) {
			this.hand = 1;
		} else if (handString.startsWith("pa")) {
			this.hand = 2;
		} else if (handString.startsWith("ci")) {
			this.hand = 3;
		} else { // If none of these three, ask again.
			throw new IllegalArgumentException ("Main invalide: " + handString);
		}
	}
}
