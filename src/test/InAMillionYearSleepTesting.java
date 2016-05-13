package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    	
    	
    	
    }

    @After
    public void takeDown() {

    }

    @Test
    public void testInit() {

    }
}
