package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.CurseDraggedOffToSnarkhamAsylum;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurseDraggedOffToSnarkhamAsylumTesting {

	private CurseDraggedOffToSnarkhamAsylum card;
	private IPlayer player;
	private Game game;
	
	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new CurseDraggedOffToSnarkhamAsylum(this.game);
		this.player = this.game.getOtherPlayer();
		this.player.setFaction(Faction.Investigator);
		this.player.addCardToHand(this.card);
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
		assertEquals(Faction.Investigator, this.game.getOtherPlayer().getFaction());

		this.card.cardInPlay();
		//change to cultist
		assertEquals(Faction.Cultist, this.game.getOtherPlayer().getFaction());
		
		this.card.cardInPlay();
		//become a noncultist
		assertTrue(!Faction.Cultist.equals(this.game.getOtherPlayer().getFaction()));
	}
	
}
