package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.GreatCthulhu;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class GreatCthulhuTesting {
	
	private Door door;

    @Before
    public void setUp() {
    	door = new GreatCthulhu();
    	door.setOwner(new Player());
    	
    }

    @After
    public void takeDown() {
    	door = null;
    }

    @Test
    public void testNonCultist() {
    	door.getOwner().setFaction(Faction.MonsterWhacker);
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(5, door.getTreasures());
    	assertEquals(24, door.getLevel());
    }
    
    @Test
    public void testCultist(){
    	door.getOwner().setFaction(Faction.Cultist);
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(5, door.getTreasures());
    	assertEquals(20, door.getLevel());
    }
}
