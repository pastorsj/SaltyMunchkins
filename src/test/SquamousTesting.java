package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.doors.Squamous;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class SquamousTesting {
	private Squamous card;
	private Game game;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new Squamous(this.game);
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
	public void testCardInPlay() {
		this.card.cardInPlay();
		assertEquals(5, this.card.getLevel());
	}

	@Test
	public void testCardPlayedWin() {
		this.card.cardPlayed(true);
		assertEquals(1, this.card.getTreasures());
	}

	@Test
	public void testCardPlayedLose() {
		this.card.cardPlayed(false);
		assertEquals(0, this.card.getTreasures());

	}
}
