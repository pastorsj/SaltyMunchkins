package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.Cultist;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class CultistTesting {

	private Cultist cultist;
	private Game game;

    @Before
    public void setUp() {
    	this.game = new Game(2);
    	cultist = new Cultist(game);
    	
    }

    @After
    public void takeDown() {
    	this.cultist = null;
    }

    @Test
    public void getBonus() {
    	this.cultist.setOwner(game.getCurrentPlayer());
    	this.game.getOtherPlayer().setFaction(Faction.Cultist);
    	this.cultist.cardInHand();
    	this.cultist.cardInPlay();
    	assertEquals(2, this.cultist.getLevel());
    	
    	
    }
    
    @Test
    public void noBonus() {
    	
    }
}
