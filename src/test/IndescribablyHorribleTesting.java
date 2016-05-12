package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.doors.IndescribablyHorrible;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class IndescribablyHorribleTesting {
	private IndescribablyHorrible card;

	@Before
	public void setUp() {
		this.card = new IndescribablyHorrible();
	}

	@After
	public void takeDown() {
		this.card = null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
	}

	@Test
	public void testCardInPlay() {
		this.card.cardInPlay();
		assertEquals(10, this.card.getLevel());
	}

	@Test
	public void testCardPlayedWin() {
		this.card.cardPlayed(true);
		assertEquals(2, this.card.getTreasures());
	}
	@Test
	public void testCardPlayedLose() {
		this.card.cardPlayed(false);
		assertEquals(0, this.card.getTreasures());
	}
}
