package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.FakeTentacle;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class FakeTentacleTesting {
	
	private Treasure treasure;
	private Game game;

    @Before
    public void setUp() {
    	this.game = new Game(2);
    	this.treasure = new FakeTentacle(game);
    	this.treasure.setOwner(new Player());
    	
    	
    }

    @After
    public void takeDown() {
    	this.treasure = null;
    }

    @Test
    public void testUse() {
    	treasure.cardInHand();
    	treasure.cardInPlay();
    	assertEquals(1, treasure.getOwner().getRunAwayLevel());
    	assertEquals(200, treasure.getGold());
    	
    }
}
