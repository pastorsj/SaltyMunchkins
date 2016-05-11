package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.CurseAmnesia;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CurseAmnesiaTesting {
	private CurseAmnesia card;
	private IPlayer player;
	private Game game;
	
	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new CurseAmnesia(this.game);
		this.player = this.game.getOtherPlayer();
		this.player.setFaction(Faction.Investigator);
		this.player.addCardToHand(this.card);
		this.player.addLevel(5);
		this.card.setOwner(this.game.getCurrentPlayer());
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
		assertEquals(Faction.Investigator, this.player.getFaction());

		this.card.cardInPlay();
		//lose a class
		assertEquals(Faction.UNAFFILIATED, this.card.getOwner().getFaction());
		assertEquals(Faction.UNAFFILIATED, this.player.getFaction());
		
		this.card.cardInPlay();
		assertEquals(Faction.UNAFFILIATED, this.card.getOwner().getFaction());
		//lose a level if no class
		assertEquals(5, this.player.getPlayerLevel());
	}
	
}
