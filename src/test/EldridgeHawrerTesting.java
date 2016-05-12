package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.EldridgeHawrer;
import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class EldridgeHawrerTesting {
	
	private AbstractMonster door;
	

    @Before
    public void setUp() {
    	door = new EldridgeHawrer();
    	door.setOwner(new Player());
    }

    @After
    public void takeDown() {
    	this.door = null;
    }

    @Test
    public void testWin() {
    	door.cardInHand();
    	door.cardInPlay();
    	door.cardPlayed(true);
    	assertTrue(door.checkDiscard());
    	assertEquals(0, door.getOwner().getDiscardGoldAmount());
    }
    
    @Test
    public void testLoss(){
    	door.cardInHand();
    	door.cardInPlay();
    	door.cardPlayed(false);
    	assertTrue(door.checkDiscard());
    	assertEquals(500, door.getOwner().getDiscardGoldAmount());
    	
    }
    
    @Test
    public void testInvestiator(){
    	door.getOwner().setFaction(Faction.Investigator);
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(3, door.getLevel());
    }
    
    @Test
    public void testNonInvestiator(){
    	door.getOwner().setFaction(Faction.MonsterWhacker);
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(1, door.getLevel());
    	
    }
    
}
