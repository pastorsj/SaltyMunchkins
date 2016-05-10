package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.doors.AndItsSpawn;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.Bagpipes;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class AndItsSpawnTesting {
	private Door door;
	private Game game;
	@Before
	public void setUp() {
		this.game = new Game(2);
		this.door = new AndItsSpawn(game);		
		this.door.cardInHand();
	}
	
	@After
	public void takeDown() {
		this.door = null;
	}
	
	@Test
	public void testTreasureNotNull(){
		assertNotNull(this.door);
	}

	
	@Test
	public void testSetAndGetDiscard() {
		this.door.setDiscard();
		assertTrue(this.door.checkDiscard());
	}
	
	@Test
	public void playCard(){
		this.door.cardInPlay();
		assertEquals(5, door.getLevel());

	}
	
	@Test
	public void loss(){
		this.door.cardInPlay();
		this.door.cardPlayed(false);
		assertTrue(this.door.checkDiscard());
		assertEquals(this.door.getTreasures(), 0);
	
	}
	
	@Test
	public void win(){
		this.door.cardInPlay();
		this.door.cardPlayed(true);
		assertTrue(this.door.checkDiscard());
		assertEquals(this.door.getTreasures(), 1);
	}
}
