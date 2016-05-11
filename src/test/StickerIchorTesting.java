package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.StickerIchor;
import munchkin.cards.treasures.WandOfWalloping;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class StickerIchorTesting {
	private StickerIchor card;
	private Game game;
	
    @Before
    public void setUp() {
    	this.game=new Game(2);
    	this.card = new StickerIchor(this.game);
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
 	public void testCardPlayed() {
 		this.card.cardPlayed(true);
 		assertTrue(this.card.checkDiscard());
 		
 		this.card.cardPlayed(false);
 		assertTrue(this.card.checkDiscard());
 	}
 	
	@Test
	public void testCardInHand(){
		this.card.cardInHand();
		assertEquals(300, this.card.getGold());
		assertEquals(SpecificCardType.Ichor, this.card.getSpecificCardType());
	}

	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(4, this.card.getBonus());
		assertEquals("A bonus of 4 was applied during combat", this.card.getAction().getAction());
	}
}
