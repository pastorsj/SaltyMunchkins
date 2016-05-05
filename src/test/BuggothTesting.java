package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.Buggoth;
import munchkin.cards.treasures.api.Faction;

public class BuggothTesting {
	private Buggoth card;
	private IPlayer player;
	private Faction playerFaction;

	@Before
	public void setUp() {
		this.card = new Buggoth();
		this.player = new Player();
		this.player.addCardToHand(this.card);
		this.player.setFaction(Faction.Investigator);
		this.playerFaction = Faction.Investigator;
		this.card.setOwner(this.player);
	}

	@After
	public void takeDown() {
		this.card = null;
		this.player=null;
	}

	@Test
	public void testCardNotNull() {
		assertNotNull(this.card);
	}
	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(1, this.card.getTreasures());
		assertEquals(1, this.card.getLevel());
		assertNull(this.card.getOwner().getFaction());
	}
	
	@Test
	public void testBadStuff(){
		this.card.cardInPlay();
		this.card.badStuff();
		assertEquals(0,this.card.getOwner().getArmorSet().getArmor().size());
		assertEquals(this.playerFaction, this.card.getOwner().getFaction());
	}
}
