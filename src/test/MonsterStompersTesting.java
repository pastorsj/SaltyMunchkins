package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.MonsterStompers;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class MonsterStompersTesting {

	private MonsterStompers card;
	private Game game;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new MonsterStompers(this.game);
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
	public void testCardInHandWithMonsterWhacker() {
		this.card.getOwner().setFaction(Faction.MonsterWhacker);
		this.card.cardInHand();
		assertEquals(600, this.card.getGold());
		assertEquals(Armor.FootGear, this.card.getArmor());
		assertFalse(this.card.isDisabled());
	}
	@Test
	public void testCardInHandWithoutMonsterWhacker() {
		this.card.cardInHand();
		assertEquals(600, this.card.getGold());
		assertEquals(Armor.FootGear, this.card.getArmor());
		assertTrue(this.card.isDisabled());
	}
	@Test
	public void testCardInPlay() {
		this.card.cardInPlay();
		assertEquals(3, this.card.getBonus());
	}
}
