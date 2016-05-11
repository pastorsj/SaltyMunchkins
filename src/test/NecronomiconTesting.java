package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.Necronomicon;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class NecronomiconTesting {

	private Necronomicon card;
	private Game game;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new Necronomicon(this.game);
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
	public void testCardInHandWithProf() {
		this.game.getCurrentPlayer().setFaction(Faction.Professor);
		this.card.cardInHand();
		assertEquals(800, this.card.getGold());
		assertEquals(Armor.TwoHands, this.card.getArmor());
		assertFalse(this.card.isDisabled());
	}
	@Test
	public void testCardInHandWithoutProf() {
		this.card.cardInHand();
		assertEquals(800, this.card.getGold());
		assertEquals(Armor.TwoHands, this.card.getArmor());
		assertTrue(this.card.isDisabled());
	}

	@Test
	public void testCardInPlay() {
		this.card.cardInPlay();
		assertEquals(5, this.card.getBonus());
	}
}
