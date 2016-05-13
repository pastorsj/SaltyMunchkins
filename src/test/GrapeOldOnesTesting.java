package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.GrapeOldOnes;
import munchkin.cards.doors.api.Door;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class GrapeOldOnesTesting {
	
	private Door door;

    @Before
    public void setUp() {
    	door = new GrapeOldOnes();
    	door.setOwner(new Player());

    }

    @After
    public void takeDown() {
    	this.door = null;

    }

    @Test
    public void testMale() {
    	door.getOwner().setGender("Male");
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(12, door.getLevel());
    	assertEquals(3, door.getTreasures());
    	
    }
    
    @Test
    public void testFemale(){
    	door.getOwner().setGender("Female");
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(10, door.getLevel());
    	assertEquals(3, door.getTreasures());
    }
}
