package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.CurseChangeSex;
import munchkin.cards.doors.api.Door;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class CurseChangeSexTesting {
	
	private Door door;

    @Before
    public void setUp() {
    	door = new CurseChangeSex();
    	door.setOwner(new Player());
    }

    @After
    public void takeDown() {
    	this.door = null;
    }

    @Test
    public void testMale() {
    	this.door.getOwner().setGender("Male");
    	this.door.cardInHand();
    	this.door.cardInPlay();
    	assertEquals("Female", this.door.getOwner().getGender());
    	assertEquals(-5, this.door.getOwner().getCombatLevel());
    }
    
    @Test
    public void testFemale(){
    	this.door.getOwner().setGender("Female");
    	this.door.cardInHand();
    	this.door.cardInPlay();
    	assertEquals("Male", this.door.getOwner().getGender());
    	assertEquals(-5, this.door.getOwner().getCombatLevel());
    }
}
