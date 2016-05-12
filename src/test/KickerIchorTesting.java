package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.KickerIchor;
import munchkin.cards.treasures.MonsterStompers;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class KickerIchorTesting {
	private KickerIchor card;
	private Game game;
	
    @Before
    public void setUp() {
    	this.game=new Game(2);
    	this.card = new KickerIchor(this.game);
    	this.card.setOwner(this.game.getCurrentPlayer());
    }

    @After
    public void takeDown() {
    	this.game=null;
    	this.card=null;
    }

    @Test
    public void testInit() {
    	assertNotNull(this.card);
    	assertNotNull(this.game);
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
		assertEquals(200, this.card.getGold());
		assertEquals(SpecificCardType.Ichor, this.card.getSpecificCardType());
	}

	
	@Test
	public void testCardInPlayWithoutFootgear(){
		this.card.cardInPlay();
		assertNull(this.card.getOwner().getArmorSet().removeFootgear());
	}
	
	@Test
	public void testCardInPlayWithFootgear(){
		this.card.getOwner().setFaction(Faction.MonsterWhacker);
		MonsterStompers m = new MonsterStompers(this.game);
		m.setOwner(this.card.getOwner());
		this.game.getCardsInPlay().addCardsToPlay(m);
		m.cardInHand();
		
		this.card.getOwner().getArmorSet().addFootGear(m);
		this.card.cardInPlay();
		assertEquals(6, this.card.getBonus());
	}
}
