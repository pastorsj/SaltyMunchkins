package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.doors.FourDimensional;
import munchkin.cards.doors.api.MonsterEnhancer;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class FourDimensionTesting {
	
	private MonsterEnhancer enhancer;
	private Game game;

    @Before
    public void setUp() {
    	game = new Game(2);
    	enhancer = new FourDimensional(game);
    

    }

    @After
    public void takeDown() {
    	this.enhancer = null;
    }

    @Test
    public void testCombat() {
    	enhancer.cardInHand();
    	enhancer.cardInPlay();
    	assertEquals(10, enhancer.getLevel());
    }
}
