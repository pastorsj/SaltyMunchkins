package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.BugSpray;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class BugSprayTesting {

	private Treasure treasure;
	@Before
	public void setUp() {
		this.treasure = new BugSpray();		
		this.treasure.setOwner(new Player());
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
		assertEquals(300, this.treasure.getGold());
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
