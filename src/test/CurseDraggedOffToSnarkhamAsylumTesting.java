package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.CurseDraggedOffToSnarkhamAsylum;
import munchkin.cards.treasures.api.Faction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurseDraggedOffToSnarkhamAsylumTesting {
	private CurseDraggedOffToSnarkhamAsylum card;
	private IPlayer player;
	
	@Before
	public void setUp() {
		this.card = new CurseDraggedOffToSnarkhamAsylum();
		this.player = new Player();
		this.player.setFaction(Faction.Investigator);
		this.player.addCardToHand(this.card);
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
		assertEquals(Faction.Investigator, this.card.getOwner().getFaction());

		this.card.cardInPlay();
		//change to cultist
		assertEquals(Faction.Cultist, this.card.getOwner().getFaction());
		
		this.card.cardInPlay();
		//become a noncultist
		assertTrue(!Faction.Cultist.equals(this.card.getOwner().getFaction()));
	}
	
}
