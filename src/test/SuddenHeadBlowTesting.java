package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.doors.SuddenHeadBlow;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class SuddenHeadBlowTesting {
	private SuddenHeadBlow card;
	private Game game;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new SuddenHeadBlow(this.game);
		this.card.setOwner(this.game.getCurrentPlayer());
		this.game.getOtherPlayer().setFaction(Faction.Cultist);
	}

	@After
	public void takeDown() {
		this.card = null;
		this.game = null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.game);
	}
	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(Faction.UNAFFILIATED, this.game.getOtherPlayer().getFaction());
		
		this.card.cardInPlay();
		assertEquals(Faction.Cultist, this.game.getOtherPlayer().getFaction());
	}
}
