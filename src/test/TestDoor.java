package test;

import munchkin.cards.doors.api.Door;
import munchkin.game.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
