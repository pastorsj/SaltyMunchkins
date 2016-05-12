package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.GramSmoker;
import munchkin.cards.doors.api.Door;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class GramSmokerTesting {
	
	private Door door;

    @Before
    public void setUp() {
    	this.door = new GramSmoker();
    	door.setOwner(new Player());
    	
    	
    }

    @After
    public void takeDown() {
    	this.door = null;
    }
    
    @Test
    public void testTreasures(){
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(1, door.getTreasures());
    }

    @Test
    public void testMaleLoss() {
    	door.getOwner().setGender("Male");
    	door.getOwner().addLevel(1);
    	assertEquals(2, door.getOwner().getPlayerLevel());
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(5, door.getLevel());
    	
    	door.cardPlayed(false);
    	assertEquals(1, door.getOwner().getPlayerLevel());
    }
    
    @Test
    public void testMaleWin() {
    	door.getOwner().setGender("Male");
    	door.getOwner().addLevel(1);
    	assertEquals(2, door.getOwner().getPlayerLevel());
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(5, door.getLevel());
    	
    	door.cardPlayed(true);
    	assertEquals(2, door.getOwner().getPlayerLevel());
    }
    
    @Test
    public void testFemaleLoss() {
    	door.getOwner().setGender("Female");
    	door.getOwner().addLevel(1);
    	assertEquals(2, door.getOwner().getPlayerLevel());
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(2, door.getLevel());
    	
    	door.cardPlayed(false);
    	assertEquals(1, door.getOwner().getPlayerLevel());
    }
    
    @Test
    public void testFemaleWin() {
    	door.getOwner().setGender("Female");
    	door.getOwner().addLevel(1);
    	assertEquals(2, door.getOwner().getPlayerLevel());
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(2, door.getLevel());
    	
    	door.cardPlayed(true);
    	assertEquals(2, door.getOwner().getPlayerLevel());
    }
}
