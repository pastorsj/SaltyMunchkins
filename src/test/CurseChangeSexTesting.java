package test;

import static org.junit.Assert.*;

import munchkin.game.Game;
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
	private Game game;

    @Before
    public void setUp() {
		this.game = new Game(2);
    	door = new CurseChangeSex(this.game);
    	door.setOwner(this.game.getCurrentPlayer());
    }

    @After
    public void takeDown() {
    	this.door = null;
		this.game = null;
    }

    @Test
    public void testMale() {
    	this.game.getOtherPlayer().setGender("Male");
    	this.door.cardInHand();
    	this.door.cardInPlay();
    	assertEquals("Female", this.game.getOtherPlayer().getGender());
    	assertEquals(-5, this.game.getOtherPlayer().getCombatLevel());
    }
    
    @Test
    public void testFemale(){
    	this.game.getOtherPlayer().setGender("Female");
    	this.door.cardInHand();
    	this.door.cardInPlay();
    	assertEquals("Male", this.game.getOtherPlayer().getGender());
    	assertEquals(-5, this.game.getOtherPlayer().getCombatLevel());
    }
}
