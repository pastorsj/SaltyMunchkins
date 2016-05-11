package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.MysticScribble;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class MysticScribbleTesting {
	private MysticScribble card;
	private Game game;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new MysticScribble(this.game);
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
	public void testCardInHandWithCultist() {
		this.game.getCurrentPlayer().setFaction(Faction.Cultist);
		this.card.cardInHand();
		assertEquals(300, this.card.getGold());
		assertTrue(this.card.isDisabled());
		assertEquals(Armor.OneHand, this.card.getArmor());
	}

	@Test
	public void testCardInHandWithoutCultist() {
		this.card.cardInHand();
		assertEquals(300, this.card.getGold());
		assertFalse(this.card.isDisabled());
		assertEquals(Armor.OneHand, this.card.getArmor());
	}

	@Test
	public void testCarInPlay() {
		this.card.cardInPlay();
		assertEquals(2, this.card.getBonus());
	}
}
