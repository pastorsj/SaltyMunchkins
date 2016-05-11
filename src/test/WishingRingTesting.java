package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.CurseAmnesia;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.WishingRing;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class WishingRingTesting {
	private WishingRing treasure;
	private AbstractCurse curse;
	private munchkin.game.Game game;
	private IPlayer player;

    @Before
    public void setUp() {
    	this.game = new Game(2);
    	this.treasure = new WishingRing(this.game);
    	this.treasure.cardInHand();
    	this.curse = new CurseAmnesia(this.game);
    	this.player=new Player();
    	this.player.addCardToHand(this.treasure);
    	this.player.addCardToHand(this.curse);
    	this.treasure.setOwner(this.player);
    	this.curse.setOwner(this.player);
    	this.game.getCardsInPlay().addCardsToPlay(this.curse);
    	this.game.getCardsInPlay().addCardsToPlay(this.treasure);
    }

    @After
    public void takeDown() {
    	this.treasure=null;
    }

    @Test
    public void testInit() {
    	assertNotNull(this.treasure);
    }	
    
	@Test
	public void testSetAndGetDiscard() {
		this.treasure.setDiscard();
		assertTrue(this.treasure.checkDiscard());
	}

	@Test
	public void testCardInHand(){
		this.treasure.cardInHand();
		assertEquals(500, this.treasure.getGold());
	}
	
	@Test
	public void testCardInPlay(){
		assertEquals(1, this.game.getCardsInPlay().getCardsInPlay().size());
		assertEquals(1, this.game.getDiscardedCards().getAllCards().size());
	}
	
	@Test
	public void testCardPlayed(){
		this.treasure.cardPlayed(true);
		assertTrue(this.treasure.checkDiscard());

		this.treasure.cardPlayed(false);
		assertTrue(this.treasure.checkDiscard());
	}
}
