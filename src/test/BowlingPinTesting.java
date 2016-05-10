package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.Bagpipes;
import munchkin.cards.treasures.BowlingPin;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class BowlingPinTesting {
    
	private Treasure treasure;
	private Game game;
	@Before
	public void setUp() {
		this.game = new Game(2);
		this.treasure = new BowlingPin();		
		this.treasure.cardInHand();
	}
	
	@After
	public void takeDown() {
		this.treasure = null;
	}
	
	@Test
	public void testTreasureNotNull(){
		assertNotNull(this.treasure);
	}

	
	@Test
	public void testSetAndGetDiscard() {
		this.treasure.setDiscard();
		assertTrue(this.treasure.checkDiscard());
	}
	
	@Test
	public void playCard(){
		this.treasure.cardInPlay();
		assertEquals(2, this.treasure.getBonus());
		assertEquals(Armor.OneHand, this.treasure.getArmor());
	}
	
	@Test
	public void loss(){
		this.treasure.cardInPlay();
		this.treasure.cardPlayed(false);
		assertFalse(this.treasure.checkDiscard());
	}
	
	@Test
	public void win(){
		this.treasure.cardInPlay();
		this.treasure.cardPlayed(true);
		assertFalse(this.treasure.checkDiscard());
	}
	
}
