package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.Ruggoth;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class RuggothTesting {
	private IPlayer player;
	private Ruggoth card;
    @Before
    public void setUp() {
    	this.player=new Player();
    	this.card=new Ruggoth();
    	this.card.setOwner(player);
    	this.player.setFaction(Faction.Investigator);
    }

    @After
    public void takeDown() {
    	this.player=null;
    	this.card=null;
    }

    @Test
    public void testInit() {
    	assertNotNull(this.card);
    	assertNotNull(this.player);
    }
    
    @Test
    public void testCardInPlay(){
    	this.card.cardInPlay();
    	assertEquals(1, this.card.getTreasures());
    	assertEquals(2, this.card.getLevel());
    }
    
    @Test
    public void testBadStuff(){
    	this.card.badStuff();
    	assertEquals(Faction.Cultist, this.card.getOwner().getFaction());
    }
}
