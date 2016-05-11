package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.Necrocomicon;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class NecrocomiconTesting {

	private Necrocomicon card;
	private Game game;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new Necrocomicon(this.game);
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
	public void testCardInHand() {
		this.card.cardInHand();
		assertEquals(100, this.card.getGold());
		assertEquals(Armor.OneHand, this.card.getArmor());
	}

	@Test
	public void testCardInPlay() {
		this.card.cardInPlay();
		assertEquals(1, this.card.getBonus());
	}

}
