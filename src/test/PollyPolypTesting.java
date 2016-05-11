package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.PollyPolyp;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class PollyPolypTesting {
	private PollyPolyp card;
	private Player player;

	@Before
	public void setUp() {
		this.card = new PollyPolyp();
		this.player = new Player();
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
	public void testCardInPlayWithProf(){
		this.player.setFaction(Faction.Professor);
		
		this.card.cardInPlay();
		assertEquals(1, this.card.getTreasures());
		assertEquals(5, this.card.getLevel());
		
	}
	@Test
	public void testCardInPlayWithoutProf(){		
		this.card.cardInPlay();
		assertEquals(1, this.card.getTreasures());
		assertEquals(2, this.card.getLevel());
	}
	@Test
	public void testBadStuff(){
		this.card.badStuff();
		assertEquals("You lose! Lose a Level", this.card.getAction().getAction());
		assertEquals(0, this.card.getOwner().getPlayerLevel());
	}
}
