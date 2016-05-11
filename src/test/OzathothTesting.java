package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.Ozathoth;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class OzathothTesting {
	private Ozathoth card;
	private Player player;

	@Before
	public void setUp() {
		this.card = new Ozathoth();
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
	public void testCardInPlayLevel3AndBelow(){
		this.player.addToPlayerLevel(3);
		this.card.cardInPlay();
		assertEquals(5, this.card.getTreasures());
		assertEquals(10000, this.card.getOwner().getRunAwayLevel());
		
	}
	
	@Test
	public void testCardInPlayLevel3AndAbove(){
		this.player.addToPlayerLevel(5);
		this.card.cardInPlay();
		assertEquals(5, this.card.getTreasures());		
	}
	
	@Test
	public void testCardPlayedWin(){
		this.card.cardPlayed(true);
		assertEquals(3, this.card.getOwner().getPlayerLevel());
		assertEquals(5, this.card.getOwner().getNumTreasures());
	}
	@Test
	public void testCardPlayedLose(){
		this.card.cardPlayed(false);
		assertFalse(this.card.getOwner().isAlive());
	
	}
}
