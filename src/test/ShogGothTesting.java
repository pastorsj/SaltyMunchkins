package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.ShogGoth;
import munchkin.cards.doors.TheCrullerOutOfSpace;
import munchkin.cards.treasures.MonsterStompers;
import munchkin.cards.treasures.Necrotelecom;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class ShogGothTesting {
	private ShogGoth card;
	private IPlayer player;
	private Game game;

	@Before
	public void setUp() {
		this.card = new ShogGoth();
		this.player = new Player();
		this.game=new Game(2);
		this.player.addCardToHand(this.card);
		this.card.setOwner(this.player);
		this.player.setFaction(Faction.Investigator);
	}

	@After
	public void takeDown() {
		this.card=null;
		this.player=null;
		this.game=null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.game);
		assertNotNull(this.player);
	}
	
	@Test
	public void testCardInPlayWithoutInvestigator(){
		this.player.addToPlayerLevel(3);
		this.card.cardInPlay();
		assertEquals(14, this.card.getLevel());
		assertEquals(10000, this.card.getOwner().getRunAwayLevel());
	}
	@Test
	public void testCardInPlayWithInvestigator(){
		this.player.addToPlayerLevel(5);
		this.player.setFaction(Faction.Investigator);
		this.card.cardInPlay();
		assertEquals(14, this.card.getLevel());
		assertEquals(0, this.card.getOwner().getRunAwayLevel());
	}
	@Test
	public void testCardPlayedWin(){
		this.card.cardPlayed(true);
		assertEquals(4, this.player.getNumTreasures());
		assertEquals(2, this.player.getPlayerLevel());
		assertEquals(Faction.Investigator, this.player.getFaction());

	}
	@Test
	public void testCardPlayedLose(){
		this.card.cardPlayed(false);
		assertEquals(0, this.player.getNumTreasures());
		assertEquals(0, this.player.getPlayerLevel());
		assertEquals(Faction.Cultist, this.player.getFaction());
	}
}
