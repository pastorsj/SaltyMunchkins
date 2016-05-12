package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.FezofFazooli;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class FezofFazooliTesting {
	
	private Treasure treasure;
	private Game game;

    @Before
    public void setUp() {
    	game = new Game(2);
    	treasure = new FezofFazooli(game);
    	treasure.setOwner(new Player());
    	

    }

    @After
    public void takeDown() {
    	treasure = null;
    }

    @Test
    public void testMonsterWhacker() {
    	treasure.getOwner().setFaction(Faction.MonsterWhacker);
    	treasure.cardInHand();
    	treasure.cardInPlay();
    	assertTrue(treasure.isDisabled());
    }
    
    @Test
    public void testNonMonsterWhacker(){
    	treasure.getOwner().setFaction(Faction.Investigator);
    	treasure.cardInHand();
    	treasure.cardInPlay();
    	assertFalse(treasure.isDisabled());
    	assertEquals(700, treasure.getGold());
    	assertEquals(Armor.HeadGear, treasure.getArmor());
    	
    	
    }
}
