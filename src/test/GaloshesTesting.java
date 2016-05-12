package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.Galoshes;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class GaloshesTesting {
	
	private Treasure treasure;

    @Before
    public void setUp() {
    	this.treasure = new Galoshes();
    	this.treasure.setOwner(new Player());
    }

    @After
    public void takeDown() {
    	this.treasure = null;
    }

    @Test
    public void testCombat() {
    	assertEquals(0, treasure.getOwner().getCombatLevel());
    	treasure.cardInHand();
    	treasure.cardInPlay();
    	
    	assertEquals(Armor.PseudoFootGear, treasure.getArmor());
    	assertEquals(300, treasure.getGold());
    	assertEquals(1, treasure.getOwner().getCombatLevel());
    }
}
