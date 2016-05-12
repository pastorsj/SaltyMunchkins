package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.Froggoth;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class FroggothTesting {
	
	private Door door;

    @Before
    public void setUp() {
    	door = new Froggoth();
    	door.setOwner(new Player());
    	
    }

    @After
    public void takeDown() {
    	this.door = null;
    }

    @Test
    public void testMonsterWhacker() {
    	door.getOwner().setFaction(Faction.MonsterWhacker);
    	door.cardInHand();
    	door.cardInPlay();
    	
    	assertEquals(10, door.getLevel());
    	assertEquals(3, door.getTreasures());
    }
    
    @Test
    public void testNonMonsterWhacker(){
    	door.getOwner().setFaction(Faction.Investigator);
    	door.cardInHand();
    	door.cardInPlay();
    	
    	assertEquals(12, door.getLevel());
    	assertEquals(3, door.getTreasures());
    	
    }
    
    @Test
    public void testLoss(){
    	door.cardInHand();
    	door.cardInPlay();
    	door.cardPlayed(false);
    	assertFalse(door.getOwner().isAlive());
    }
    
    @Test
    public void testWin(){
    	door.cardInHand();
    	door.cardInPlay();
    	door.cardPlayed(true);
    	assertTrue(door.getOwner().isAlive());
    }
}
