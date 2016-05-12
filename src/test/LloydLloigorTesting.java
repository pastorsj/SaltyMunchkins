package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.LloydLloigor;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class LloydLloigorTesting {
	private LloydLloigor card;
	private Player player;

	@Before
	public void setUp() {
		this.player = new Player();
		this.card = new LloydLloigor();
		this.card.setOwner(this.player);
	}

	@After
	public void takeDown() {
		this.player = null;
		this.card = null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.player);
	}

	@Test
	public void testCardInPlayWithCultist() {
		this.player.setFaction(Faction.Cultist);
		this.card.cardInPlay();
		assertEquals(2, this.card.getTreasures());
		assertEquals(6, this.card.getLevel());
	}
	@Test
	public void testCardInPlayWithoutCultist() {
		this.card.cardInPlay();
		assertEquals(2, this.card.getTreasures());
		assertEquals(8, this.card.getLevel());
	}
	@Test
	public void testBadStuff() {
		this.card.badStuff();
		assertEquals(-1, this.card.getOwner().getPlayerLevel());
		assertEquals("You lost! As a result, you lose two levels", this.card.getAction().getAction());
	}
}
