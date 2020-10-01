/*
____________________________________________________________________ 
FILE NAME : RockPaperScissors.java
FILE LOCATION : \cda-tp-java\src\tpjava
DESCRIPTION : Game of rock paper scissors between a human and the computer
AUTHOR : Erik Shea <hoopsnake@gmail.com>
CREATION DATE : 29/09/2020
_____________________________________________________________________
*/

package rps;

import java.util.Scanner;

public class RockPaperScissorsGame {

	protected static int playerScore = 0, computerScore = 0;

	/**
	 * Mini-game: A human plays rock-paper-scissors against the computer. Keeps
	 * going until the player asks to exit, then shows the scores.
	 */
	public static void main(String[] args) {
		int playerHand, computerHand; // Hand shapes will be stored as numbers.
		Scanner sc = new Scanner(System.in);
		
		do {
			playerHand = getPlayerHandInput(sc); // Get player's hand as an integer between 1 and 3.
			computerHand = (int) (3 * Math.random() + 1); // Computer picks an integer between 1 and 3.

			System.out.print("Choix de votre adversaire : "
							 + intHandToString(computerHand) + ". " 		// Computer's hand.
							 + playRound(playerHand, computerHand) + "!\n" 	// Round outcome.
							 + "Voulez-vous rejouer [o]ui/[n]on) ?"); 		// Play again?
		} while (sc.nextLine().toLowerCase().startsWith("o"));	// Stop on any input not starting with "o"
		
		// Calculate win %, rounded to the nearest whole number.
		long winPercentage = Math.round(100 * (double) playerScore / (playerScore + computerScore));
		
		// Show scores and win percentage.
		System.out.println(playerScore + " jeux gagnés contre " + computerScore + " perdus (" 
				+ winPercentage + "% de pourcentage de victoires)."); 							
	}

	/**
	 * Asks user to enter one of three options: "pierre", "papier", or "ciseaux".
	 * If anything else is entered, keeps asking.
	 * 
	 * @return int : 1 for "pierre", 2 for "papier", 3 for "ciseaux"
	 */

	private static int getPlayerHandInput(Scanner sc) {	// TODO: redo with InputStream for testing
		int userChoiceInt = 0;

		while (userChoiceInt == 0) { // No return until user enters one of three options.
			System.out.println("[pi]erre, [pa]pier, [ci]seaux?");

			String userChoiceStr = sc.nextLine().toLowerCase(); 	// Get player choice in lowercase
			
			// Return the number corresponding to the first 2 letters of each option
			if (userChoiceStr.startsWith("pi")) {
				userChoiceInt = 1;
			} else if (userChoiceStr.startsWith("pa")) {
				userChoiceInt = 2;
			} else if (userChoiceStr.startsWith("ci")) {
				userChoiceInt = 3;
			} else { // If none of these three, ask again.
				System.out.println("Choix invalide.");
			}
		}

		return userChoiceInt;
	}

	
	protected static String playRound(int humanHand, int computerHand) {
		String outcome;

		if (humanHand == computerHand) 						// Draw.
		{
			outcome = "Match nul";							// Win conditions for player:
		} else if (	humanHand == 1 && computerHand == 3		// -rock vs. scissors
				|| 	humanHand == 2 && computerHand == 1		// -paper vs. rock
				|| 	humanHand == 3 && computerHand == 2)	// -scissors vs. paper
		{
			playerScore++;
			outcome = "Gagné";
		} else 												// Loss otherwise
		{
			computerScore++;
			outcome = "Perdu";
		}

		return outcome;
	}

	/**
	 * Converts a choice in the form of a number to its corresponding string.
	 * 
	 * @param choice int between 1 and 3
	 * @return "pierre" if choice is 1, "papier" if 2, "ciseaux" otherwise
	 */
	protected static String intHandToString(int choice) {
		String choiceString;

		if (choice == 1) {
			choiceString = "pierre";
		} else if (choice == 2) {
			choiceString = "papier";
		} else {
			choiceString = "ciseaux";
		}

		return choiceString;
	}
	
}
