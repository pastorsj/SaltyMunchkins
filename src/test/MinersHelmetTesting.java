package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.MinersHelmet;
import munchkin.cards.treasures.api.Armor;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class MinersHelmetTesting {
	private MinersHelmet card;

	@Before
	public void setUp() {
		this.card = new MinersHelmet();
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
	public void testCardInHandWithCultist() {
		this.card.cardInHand();
		assertEquals(400, this.card.getGold());
		assertEquals(Armor.HeadGear, this.card.getArmor());
	}

	@Test
	public void testCarInPlay() {
		this.card.cardInPlay();
		assertEquals(2, this.card.getBonus());
	}
}
