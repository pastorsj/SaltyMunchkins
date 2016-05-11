package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.NonEuclideanMap;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class NonEuclideanMapTesting {

	private NonEuclideanMap card;
	private Game game;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new NonEuclideanMap(this.game);
		this.card.setOwner(this.game.getCurrentPlayer());
	}

	@After
	public void takeDown() {
		this.game = null;
		this.card = null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.game);
	}

	@Test
	public void testCardPlayedWin() {
		this.card.cardPlayed(true);
		assertEquals(1, this.card.getOwner().getNumTreasures());
	}

	@Test
	public void testCardPlayedLose() {
		this.card.cardPlayed(false);
		assertEquals(0, this.card.getOwner().getNumTreasures());
	}

	@Test
	public void testCardInHand() {
		this.card.cardInHand();
		assertEquals(400, this.card.getGold());
	}

	@Test
	public void testCardInPlay() {
		this.card.cardInPlay();
		assertEquals(-1, this.card.getOwner().getRunAwayLevel());
	}
}
