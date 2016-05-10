package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.treasures.Bagpipes;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class BagpipesTesting {

	private Treasure treasure;
	private Game game;
	@Before
	public void setUp() {
		this.game = new Game(2);
		this.treasure = new Bagpipes(game);		
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
		if(this.treasure.action.equals("Dice roll was 6, The monster is attempting to mate with you")){
			assertEquals(this.treasure.getBonus(), 0);
		}
		else{
			assertEquals(this.treasure.getBonus(), 4);
		}
	}
	
	@Test
	public void loss(){
		this.treasure.cardInPlay();
		this.treasure.cardPlayed(false);
		if(this.treasure.action.equals("Dice roll was 6, The monster is attempting to mate with you")){
			assertTrue(this.treasure.checkDiscard());
		}
		else{
			assertFalse(this.treasure.checkDiscard());
		}
	}
	
	@Test
	public void win(){
		this.treasure.cardInPlay();
		this.treasure.cardPlayed(true);
		assertFalse(this.treasure.checkDiscard());
	}
	
	
}
