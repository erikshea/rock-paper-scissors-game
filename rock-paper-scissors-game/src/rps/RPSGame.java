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

import java.util.Scanner;

public class RPSGame {
	/**
	 * Mini-game: A human plays rock-paper-scissors against the computer. Keeps
	 * going until the player asks to exit, then shows the scores.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		RPSPlayer human = new RPSPlayer();
		RPSPlayer computer = new RPSPlayer();
		
		do {
			computer.setRandomHand(); // Computer picks a random hand.
			
			while(true)
			{
				System.out.println("[pi]erre, [pa]pier, [ci]seaux?");
				try {
					human.setHand(sc.nextLine());
					break;
				} catch (IllegalArgumentException e)
				{
					System.out.println("Choix invalide.");
				}
			}

			human.play(computer);
			System.out.print("Choix de votre adversaire : "
							 + computer.getHandString() + ". " 			// Computer's hand.
							 + human.getLastOutcome() + "!\n" 			// Round outcome.
							 + "Voulez-vous rejouer [o]ui/[n]on) ?"); 	// Play again?
		} while (sc.nextLine().toLowerCase().startsWith("o"));			// Stop on any input not starting with "o"
		
		// Calculate win %, rounded to the nearest whole number.
		long winPercentage = Math.round(100 * (double) human.getScore() / (human.getScore() + computer.getScore()));
		
		// Show scores and win percentage.
		System.out.println(human.getScore() + " jeux gagnés contre " + computer.getScore() + " perdus (" 
				+ winPercentage + "% de pourcentage de victoires)."); 	
		
		sc.close();
	}
}
