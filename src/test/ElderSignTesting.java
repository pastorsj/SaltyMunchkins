package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.ElderSign;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class ElderSignTesting {
	
	private Treasure treasure;
	private Game game;

    @Before
    public void setUp() {
    	this.game = new Game(2);
    	this.treasure = new ElderSign(game);
    	this.treasure.setOwner(new Player());

    }

    @After
    public void takeDown() {
    	this.treasure = null;
    }

    @Test
    public void testInvestigator() {
    	this.treasure.getOwner().setFaction(Faction.Investigator);
    	this.treasure.cardInHand();
    	this.treasure.cardInPlay();
    	assertEquals(200, this.treasure.getGold());
    	assertEquals(Armor.OneHand, this.treasure.getArmor());
    	assertEquals(3, this.treasure.getOwner().getCombatLevel());
    	
    }
    
    @Test
    public void testNonInvestigator(){
    	this.treasure.getOwner().setFaction(Faction.MonsterWhacker);
    	this.treasure.cardInHand();
    	if(!treasure.isDisabled()){
    		treasure.cardInPlay();
    	}
    	assertEquals(200, this.treasure.getGold());
    	assertEquals(0, this.treasure.getOwner().getCombatLevel());
    	
    }
}
