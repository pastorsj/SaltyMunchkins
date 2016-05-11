package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.treasures.WandOfWalloping;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class WandOfWallopingTesting {
	private WandOfWalloping card;
	private Game game;
	private IPlayer player;
	
    @Before
    public void setUp() {
    	this.game=new Game(2);
    	this.player=new Player();
    	this.card = new WandOfWalloping(this.game);
    	this.card.setOwner(this.player);
    	this.player.setFaction(Faction.Investigator);
    }

    @After
    public void takeDown() {
    	this.game=null;
    	this.card=null;
    }

    @Test
    public void testInit() {
    	assertNotNull(this.card);
    }
    
 	@Test
 	public void testSetAndGetDiscard() {
 		this.card.setDiscard();
 		assertTrue(this.card.checkDiscard());
 	}
 	
	@Test
	public void testCardInHandWithInvestigator(){
		this.card.cardInHand();
		assertEquals(400, this.card.getGold());
		assertTrue(this.card.isDisabled());
		assertEquals(Armor.OneHand, this.card.getArmor());

	}
	@Test
	public void testCardInHandWithoutInvestigator(){
		this.player.setFaction(Faction.MonsterWhacker);
		this.card.cardInHand();
		assertEquals(400, this.card.getGold());
		assertFalse(this.card.isDisabled());

	}

	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(3, this.card.getBonus());
	}
}
