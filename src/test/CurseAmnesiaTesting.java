package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.CurseAmnesia;
import munchkin.cards.treasures.api.Faction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CurseAmnesiaTesting {
	private CurseAmnesia card;
	private IPlayer player;
	
	@Before
	public void setUp() {
		this.card = new CurseAmnesia();
		this.player = new Player();
		this.player.setFaction(Faction.Investigator);
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
		assertEquals(Faction.Investigator, this.card.getOwner().getFaction());

		this.card.cardInPlay();
		//lose a class
		assertEquals(Faction.UNAFFILIATED, this.card.getOwner().getFaction());
		
		this.card.cardInPlay();
		assertEquals(Faction.UNAFFILIATED, this.card.getOwner().getFaction());
		//lose a level if no class
		assertEquals(4, this.card.getOwner().getPlayerLevel());
	}
	
}
