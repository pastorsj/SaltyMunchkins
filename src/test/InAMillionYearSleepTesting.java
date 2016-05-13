package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.InAMillionYearSleep;
import munchkin.cards.doors.api.Door;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class InAMillionYearSleepTesting {
	
	private Door door;
	private Game game;

    @Before
    public void setUp() {
    	game = new Game(2);
    	door = new InAMillionYearSleep(game);
    	door.setOwner(new Player());
    	
    	
    	
    }

    @After
    public void takeDown() {
    	this.door = null;
    }

    @Test
    public void testUse() {
    	door.setLevel(8);
    	door.cardInHand();
    	door.cardInPlay();
    	assertEquals(3, door.getLevel());
    }
}
