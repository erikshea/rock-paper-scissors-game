package rps;

public class RPSPlayer {
	private int score; 	// Current score, starts at 0 and increments with each win
	private int hand; 	// Current hand shape, in the form of a number between 1 and 3
	private String lastOutcome;	// Last game outcome, eg. "Gagné".
	
	public RPSPlayer() {
		this.score = 0; // TODO: see if can get rid of
	}

	/**
	 * Determines if the current hand beats an opponent's current hand. Changes both
	 * players' relevant parameters according to the outcome.
	 * 
	 * @param opponent to play against
	 */
	public void play(RPSPlayer opponent) {
		if (this.hand == opponent.getHand())					// Draw.
		{
			this.lastOutcome = opponent.lastOutcome = "Match nul";
		} else if (this.hand == 1 && opponent.getHand() == 3 	// Win if rock vs. scissors
				|| this.hand == 2 && opponent.getHand() == 1 	// 	   or paper vs. rock
				|| this.hand == 3 && opponent.getHand() == 2) 	//     or scissors vs. paper
		{
			this.winsAgaint(opponent);
		} else 													// Loss otherwise
		{
			opponent.winsAgaint(this);
		}
	}

	/**
	 * Handle parameter changes when a win occurs.
	 * 
	 * @param opponent who lost
	 */
	private void winsAgaint(RPSPlayer opponent) {
		this.score++;
		this.lastOutcome = "Gagné";
		opponent.lastOutcome = "Perdu";
	}

	/**
	 * Returns string corresponding to current hand (eg. 1 returns "pierre").
	 * 
	 * @return String equivalent of hand number
	 */
	public String getHandString() // TODO: see if possible to share hand names with setHand(string)
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

	/**
	 * Sets hand at random
	 */
	public void setRandomHand() {
		this.hand = (int) (3 * Math.random() + 1); // random int from 1 to 3 inclusive
	}


	/***** Setters *****/

	public int getHand() {
		return this.hand;
	}

	public int getScore() {
		return this.score;
	}
	
	public String getLastOutcome() {
		return this.lastOutcome;
	}
	
	public void setHand(int hand) {
		this.hand = hand;
	}
	
	/**
	 * Set hand using its name (eg. "pierre" becomes 1). Only looks at the first two
	 * letters.
	 */
	public void setHand(String handString) throws IllegalArgumentException {
		handString = handString.toLowerCase();	// Ignore capitalization

		if (handString.startsWith("pi")) {
			this.hand = 1;
		} else if (handString.startsWith("pa")) {
			this.hand = 2;
		} else if (handString.startsWith("ci")) {
			this.hand = 3;
		} else { // If none of these three, invalid parameter.
			throw new IllegalArgumentException("Nom de main invalide: " + handString);
		}
	}
	
}
