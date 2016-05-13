package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.HPMunchcraft;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class HPMunchcraftTesting {
	
	private Door door;

    @Before
    public void setUp() {
    	this.door = new HPMunchcraft();
    	this.door.setOwner(new Player());
    	

    }

    @After
    public void takeDown() {
    	this.door = null;
    }

    @Test
    public void testInvestigator() {
    	this.door.getOwner().setFaction(Faction.Investigator);
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(9, door.getLevel());
    	assertEquals(Faction.Cultist, door.getOwner().getFaction());
    	assertEquals(2, door.getTreasures());
    }
    
    @Test
    public void testNonInvestigator() {
    	this.door.getOwner().setFaction(Faction.MonsterWhacker);
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(6, door.getLevel());
    	assertEquals(Faction.Cultist, door.getOwner().getFaction());
    	assertEquals(2, door.getTreasures());
    }
}
