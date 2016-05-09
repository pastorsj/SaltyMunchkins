package test;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTreasure {
	class TreasureMock extends Treasure{
		public TreasureMock(){
			super();
		}
		
		public TreasureMock(Game game){
			super(game);
		}
	}
	private Treasure treasure;
	@Before
	public void setUp() {
		this.treasure = new TreasureMock();		
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
	public void testSetAndGetGold(){
		this.treasure.setGold(1);
		assertEquals(1, this.treasure.getGold());
	}
	
	@Test
	public void testSetAndGetBonus(){
		this.treasure.setBonus(1);
		assertEquals(1, this.treasure.getBonus());
	}
	
	@Test
	public void testSetAndGetArmor(){
		Armor[] armors= Armor.values();
		for(Armor a : armors){
			this.treasure.setArmor(a);
			assertEquals(a, this.treasure.getArmor());
		}
	}
}
