package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.Flamethrower;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class FlamethrowerTesting {
	
	private Treasure treasure;
	

    @Before
    public void setUp() {
    	this.treasure = new Flamethrower();
    	treasure.setOwner(new Player());
    	
    }

    @After
    public void takeDown() {
    	this.treasure = null;
    }

    @Test
    public void testUse() {
    	treasure.cardInHand();
    	treasure.cardInPlay();
    	assertEquals(Armor.TwoHands, treasure.getArmor());
    	assertEquals(800, treasure.getGold());
    	assertEquals(4, treasure.getOwner().getCombatLevel());
    }
}
