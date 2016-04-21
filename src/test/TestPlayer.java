package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Hand;
import munchkin.api.Player;
import munchkin.cards.treasures.api.Faction;

public class TestPlayer {
	private Player player;

	@Before
	public void setUp() {
		this.player = new Player();
	}

	@After
	public void takeDown() {
		this.player = null;
	}

	@Test
	public void testGameNotNull() {
		assertNotNull(this.player);
	}

	@Test
	public void testSetAndGetFaction() {
		Faction[] factions = Faction.values();
		for(Faction f : factions){
			this.player.setFaction(f);
			assertEquals(f, this.player.getFaction());
		}
	}
	
	@Test
	public void testSetAndGetHand(){
		Hand hand = new Hand(this.player);
		this.player.setHand(hand);
		assertEquals(hand, this.player.getHand());
	}
	
	@Test
	public void testAddAndGetNumOfTreasures(){
		this.player.addTreasures(5);
		assertEquals(5, this.player.getNumTreasures());
		
		this.player.addTreasures(2);
		assertEquals(7, this.player.getNumTreasures());
	}
	
	@Test
	public void testSetAndGetName(){
		String name = "BOMB";
		this.player.setName(name);
		assertEquals(name, this.player.getName());
	}
	
	@Test
	public void testSetAndGetGender(){
		String gender = "female";
		this.player.setGender(gender);
		assertEquals(gender, this.player.getGender());
	}
	
	@Test
	public void testSetAndGetCombatLevel(){
		this.player.addToCombatLevel(0);
		assertEquals(0, this.player.getCombatLevel());
		
		this.player.addToCombatLevel(2);
		assertEquals(2, this.player.getCombatLevel());
	}
	
	@Test
	public void testSetAndGetRunAwayLevel(){
		this.player.addToRunAwayLevel(0);
		assertEquals(0, this.player.getRunAwayLevel());
		
		this.player.addToRunAwayLevel(2);
		assertEquals(2, this.player.getRunAwayLevel());
	}
	
	@Test
	public void testIsAlive(){
		//code is not finished
		assertTrue(this.player.isAlive());
	}
}
