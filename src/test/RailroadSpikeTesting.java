package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.treasures.RailroadSpike;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class RailroadSpikeTesting {
	private RailroadSpike card;
	private IPlayer player;
	private Game game;

	@Before
	public void setUp() {
		this.game=new Game(2);
		this.card = new RailroadSpike(this.game);
		this.player = new Player();
		this.card.setOwner(this.player);
		this.player.setFaction(Faction.MonsterWhacker);
	}

	@After
	public void takeDown() {
		this.card=null;
		this.player=null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.game);
		assertNotNull(this.player);
	}
	
	@Test
	public void testCardInHandWithMonsterWhacker(){
		this.card.cardInHand();
		assertEquals(400, this.card.getGold());
		assertFalse(this.card.isDisabled());
	}
	@Test
	public void testCardInHandWithoutMonsterWhacker(){
		this.player.setFaction(Faction.Investigator);
		this.card.cardInHand();
		assertEquals(400, this.card.getGold());
		assertTrue(this.card.isDisabled());
	}
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		
		assertEquals(3, this.card.getBonus());
		assertEquals(Armor.OneHand, this.card.getArmor());
	}
}
