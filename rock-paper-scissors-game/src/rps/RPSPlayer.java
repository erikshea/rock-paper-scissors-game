package rps;

/**
 * Represents a player for the game rock-paper-scissors.
 * Players can play against each other, and their scores are saved.
 */
public class RPSPlayer {
	private int score = 0; 	// Current score, starts at 0 and increments with each win
	private int hand; 		// Current hand shape, in the form of a number between 1 and 3

	/**
	 * Get game outcome, using both players' current hand properties.
	 * 
	 * @param RPSPlayer we play against
	 * @return String outcome, eg "Gagné"
	 */
	public String getOutcomeAgainst(RPSPlayer opponent) {
		String outcome;
		
		if (this.hand == opponent.getHand())					// Draw.
		{
			outcome = "Match nul";
		} else if (this.hand == 1 && opponent.getHand() == 3 	// Win if rock vs. scissors
				|| this.hand == 2 && opponent.getHand() == 1 	// 	   or paper vs. rock
				|| this.hand == 3 && opponent.getHand() == 2) 	//     or scissors vs. paper
		{
			outcome = "Gagné";
			this.score++;		// Increment score
		} else 													// Loss otherwise
		{
			outcome="Perdu";
			opponent.score++;	// Increment opponent score
		}
		
		return outcome;
	}

	/**
	 * Get game outcome, specifying the hand numbers of both opponents
	 * @param RPSPlayer we play against
	 * @param myHand hand number of current instance
	 * @param opponentHand hand number of opponent
	 * @return String outcome, eg "Gagné"
	 */
	public String getOutcomeAgainstForHands(RPSPlayer opponent, int myHand, int opponentHand)
	{
		this.setHand(myHand);
		opponent.setHand(opponentHand);
		return this.getOutcomeAgainst(opponent);
	}

	/**
	 * Returns string corresponding to current hand 
	 * 
	 * @return String hand in string form (eg. 1 returns "pierre").
	 */
	public String getHandName()
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
	 * Set hand number from passed hand name. Only looks at the first two letters.
	 * @param handString name of hand, eg. "pierre"
	 * @throws IllegalArgumentException if name isn't a valid hand name
	 */
	public void setHand(String handString) throws IllegalArgumentException {
		handString = handString.toLowerCase();	// Ignore capitalization

		if (handString.startsWith("pi")) {
			this.hand = 1;
		} else if (handString.startsWith("pa")) {
			this.hand = 2;
		} else if (handString.startsWith("ci")) {
			this.hand = 3;
		} else {								// If none of these three, invalid parameter.
			throw new IllegalArgumentException("Nom de main invalide: " + handString);
		}
	}
	
	/**
	 * Sets hand property to passed int
	 * @param number hand number
	 * @throws IllegalArgumentException if invalid hand number
	 */
	public void setHand(int number) throws IllegalArgumentException {
		if ( 1 <= number && number <= 3)	// Make sure number isn't between 1 and 3 inclusive
		{
			this.hand = number;
		} else {							// Throw exception if it isn't
			throw new IllegalArgumentException("Numéro de main invalide: " + number);
		}
	}
	
	/*** Generic Getters and Setters ***/

	public int getHand() {
		return this.hand;
	}

	public int getScore() {
		return this.score;
	}
	

}
