package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.AughostDerwraith;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class AughostDewraithTesting {
	private Door door;
	private Game game;
	@Before
	public void setUp() {
		this.game = new Game(2);
		this.door = new AughostDerwraith();		
		this.door.cardInHand();
		this.door.setOwner(new Player());
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
	public void playCardAsMonsterWhacker(){
		door.getOwner().setFaction(Faction.MonsterWhacker);
		this.door.cardInPlay();
		assertEquals(5, door.getLevel());

		
	}
	
	@Test
	public void playCardAsNotMonsterWhacker(){
		door.getOwner().setFaction(Faction.Cultist);
		this.door.cardInPlay();
		assertEquals(2, door.getLevel());
		
	}
	
	@Test
	public void lossNonCultist(){
		this.door.getOwner().setFaction(Faction.MonsterWhacker);
		this.door.cardInPlay();
		this.door.cardPlayed(false);
		assertTrue(this.door.checkDiscard());
		assertEquals(this.door.getOwner().getFaction(), Faction.UNAFFILIATED);
		
	
	}
	
	@Test
	public void lossAsCultist(){
		this.door.getOwner().setFaction(Faction.Cultist);
		this.door.cardInPlay();
		this.door.cardPlayed(false);
		assertTrue(this.door.checkDiscard());
		assertEquals(this.door.getOwner().getFaction(), Faction.Cultist);
		
	
	}
	
	@Test
	public void win(){
		this.door.cardInPlay();
		this.door.cardPlayed(true);
		assertTrue(this.door.checkDiscard());
		assertEquals(this.door.getTreasures(), 1);
	}
}

