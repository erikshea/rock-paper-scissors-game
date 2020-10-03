/*
____________________________________________________________________ 
FILE NAME : RPSGame.java
FILE LOCATION : /rock-paper-scissors-game/src/rps
DESCRIPTION : Game of rock paper scissors between a human and the computer
AUTHOR : Erik Shea <hoopsnake@gmail.com>
CREATION DATE : 29/09/2020
_____________________________________________________________________
*/

package rps;

public class RPSGame {
	/**
	 * Mini-game: A human plays rock-paper-scissors against the computer. Keeps
	 * going until the player asks to exit, then shows the scores.
	 */
	public static void main(String[] args) {
		RPSPlayer human = new RPSPlayer(), computer = new RPSPlayer(); // Create human and computer players
		
		do {
			computer.setHand( (int) ( 3 * Math.random() + 1 ) ); // Computer picks a random hand (1 to 3).

			while(true)	// Keep asking for a hand shape as long as input is invalid
			{
				System.out.println("[pi]erre, [pa]pier, [ci]seaux?");
				try {
					human.setHandByName(Clavier.lireString());	// Read human player's hand.
					break;									// Break infinite loop if no exception
				} catch (IllegalArgumentException e)
				{
					System.out.println("Choix invalide.");
				}
			}

			System.out.print("Choix de votre adversaire : "
							 + computer.getHandName() + ". " 			// Computer's current hand.
							 + human.getOutcomeAgainst(computer) + "!\n"// Round outcome for current hands.
							 + "Voulez-vous rejouer [o]ui/[n]on) ?"); 	// Play again?
		} while (Clavier.lireString().toLowerCase().startsWith("o"));	// Stop on any input not starting with "o"
		
		// Calculate win %, rounded to the nearest whole number.
		long winPercentage = Math.round(100 * (double) human.getScore() / (human.getScore() + computer.getScore()));
		
		// Show score and win percentage.
		System.out.println(human.getScore() + " jeux gagnés contre " + computer.getScore() + " perdus (" 
							+ winPercentage + "% de pourcentage de victoires)."); 
	}
}