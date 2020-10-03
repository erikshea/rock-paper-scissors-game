package rps;

import static org.junit.Assert.*;

import org.junit.Test;

public class RPSGameTest extends RPSGame {
	/**
	 * Check all possible hand permutations for a given player. Make sure round
	 * outcomes are correct , as well as scores.
	 */
	@Test
	public void getOutcomeForHands_shouldGiveCorrectOutcomeAndUpdateScores() {
		RPSPlayer player1 = new RPSPlayer();
		RPSPlayer player2 = new RPSPlayer();

		assertEquals("Match nul", player1.getOutcomeAgainstForHands(player2, 1, 1));
		assertEquals("Match nul", player1.getOutcomeAgainstForHands(player2, 2, 2));
		assertEquals("Match nul", player1.getOutcomeAgainstForHands(player2, 3, 3));
		assertEquals(player1.getScore(), 0);
		assertEquals(player2.getScore(), 0);

		assertEquals("Gagné", player1.getOutcomeAgainstForHands(player2, 1, 3));
		assertEquals("Gagné", player1.getOutcomeAgainstForHands(player2, 2, 1));
		assertEquals("Gagné", player1.getOutcomeAgainstForHands(player2, 3, 2));
		assertEquals(player1.getScore(), 3);
		assertEquals(player2.getScore(), 0);

		assertEquals("Perdu", player1.getOutcomeAgainstForHands(player2, 3, 1));
		assertEquals("Perdu", player1.getOutcomeAgainstForHands(player2, 1, 2));
		assertEquals("Perdu", player1.getOutcomeAgainstForHands(player2, 1, 2));
		assertEquals(player1.getScore(), 3);
		assertEquals(player2.getScore(), 3);
	}

	/**
	 * Set a hand number property, and check that converting it to a string returns
	 * the correct hand name
	 */
	@Test
	public void getHandName_shouldReturnCorrectHandName() {
		RPSPlayer player = new RPSPlayer();
		player.setHand(1);
		assertEquals(player.getHandName(), "pierre");

		player.setHand(2);
		assertEquals(player.getHandName(), "papier");

		player.setHand(3);
		assertEquals(player.getHandName(), "ciseaux");
	}

	/**
	 * Check that setting hand by String assigns the correct number to the hand
	 * property
	 */
	@Test
	public void setHand_shouldSetCorrectHandNumber() {
		RPSPlayer player = new RPSPlayer();

		player.setHand("pierre");
		assertEquals(player.getHand(), 1);

		player.setHand("papier");
		assertEquals(player.getHand(), 2);

		player.setHand("ciseaux");
		assertEquals(player.getHand(), 3);

		// Check that only the first two letters are needed, ignoring capitalization
		player.setHand("pIsdfklm");
		assertEquals(player.getHand(), 1);

		player.setHand("pAsqkmf");
		assertEquals(player.getHand(), 2);

		player.setHand("cIdqsqsdqsd");
		assertEquals(player.getHand(), 3);
	}

	/*** Argument validation ***/
	
	/**
	 * Check that an int argument to setHand not within 1 to 3 inclusive throws
	 * IllegalArgumentException
	 */
	@Test
	public void setHand_shouldThrowIllegalArgumentException_WhenIntArgumentOutOfBounds() {
		RPSPlayer player = new RPSPlayer();
		String failMessage = "setHand failed to throw IllegalArgumentException on invalid int input";
		
		try {
			player.setHand(4);
			fail(failMessage);
		} catch (IllegalArgumentException e) {
		}
		try {
			player.setHand(0);
			fail(failMessage);
		} catch (IllegalArgumentException e) {
		}
		try {
			player.setHand(-27);
			fail(failMessage);
		} catch (IllegalArgumentException e) {
		}
	}
	
	/**
	 * Check that a string argument to setHand not corresponding to the first 2 letters
	 * of one of the valid hands throws IllegalArgumentException
	 */
	@Test
	public void setHand_shouldThrowIllegalArgumentException_WhenStringArgumentInvalid() {
		RPSPlayer player = new RPSPlayer();
		String failMessage = "setHand failed to throw IllegalArgumentException on invalid int input";
		
		try {
			player.setHand("");
			fail(failMessage);
		} catch (IllegalArgumentException e) {
		}
		try {
			player.setHand("dsfSQFdfdfdsfdf");
			fail(failMessage);
		} catch (IllegalArgumentException e) {
		}
		try {
			player.setHand("---------");
			fail(failMessage);
		} catch (IllegalArgumentException e) {
		}
	}
}