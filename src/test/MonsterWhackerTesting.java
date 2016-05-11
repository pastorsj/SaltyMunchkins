package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.cards.doors.MonsterWhacker;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class MonsterWhackerTesting {
	private MonsterWhacker card;
	private Game game;
    @Before
    public void setUp() {
    	this.card=new MonsterWhacker();
    	this.game=new Game(2);
    	this.card.setOwner(this.game.getCurrentPlayer());
    }

    @After
    public void takeDown() {
    	this.card=null;
    	this.game=null;
    }

    @Test
    public void testInit() {
    	assertNotNull(this.card);
    	assertNotNull(this.game);
    }
    
    @Test
    public void testCardInPlay(){
    	this.card.cardInPlay();
    	assertEquals(Faction.MonsterWhacker,this.card.getOwner().getFaction());
    }
}
