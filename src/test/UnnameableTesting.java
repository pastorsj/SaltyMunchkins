package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.Unnameable;
import munchkin.cards.treasures.api.Faction;

public class UnnameableTesting {
	private Unnameable card;
	private IPlayer player;
	
	@Before
	public void setUp() {
		this.card = new Unnameable();
		this.player = new Player();
		this.player.setFaction(Faction.Professor);
		this.player.addCardToHand(this.card);
		this.player.addLevel(5);
		this.card.setOwner(this.player);
	}

	@After
	public void takeDown() {
		this.card = null;
		this.player=null;
	}

	@Test
	public void testCardNotNull(){
		assertNotNull(this.card);
	}
	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(10,this.card.getLevel());
		
		this.card.getOwner().setFaction(Faction.UNAFFILIATED);
		this.card.cardInPlay();
		assertEquals(5,this.card.getLevel());
	}
	
	@Test
	public void testCardPlayedWin(){
		this.card.cardPlayed(true);
		assertEquals(1,this.card.getTreasures());
	}
	
	@Test
	public void testCardPlayerLose(){
		this.card.cardPlayed(false);
		assertEquals(0,this.card.getTreasures());
	}
	
}
