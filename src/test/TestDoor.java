package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;
import test.TestTreasure.TreasureMock;

public class TestDoor {
	class DoorMock extends Door{
		public DoorMock(){
			super();
		}
		
		public DoorMock(Game game){
			super(game);
		}
	}
	private DoorMock door;
	@Before
	public void setUp() {
		this.door = new DoorMock();		
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
	public void testSetAndGetLevel(){
		this.door.setLevel(1);
		assertEquals(1, this.door.getLevel());
	}
	
	@Test
	public void testSetAndGetTreasures(){
		this.door.setTreasures(1);
		assertEquals(1, this.door.getTreasures());
	}
}
