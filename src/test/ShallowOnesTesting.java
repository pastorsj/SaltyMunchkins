package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.ShallowOnes;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class ShallowOnesTesting {
	private ShallowOnes card;
	private IPlayer player;
    @Before
    public void setUp() {
    	this.player= new Player();
    	this.card=new ShallowOnes();
    	this.card.setOwner(this.player);
    }

    @After
    public void takeDown() {
    	this.card= null;
    	this.player=null;
    }

    @Test
    public void testInit() {
    	assertNotNull(this.card);
    	assertNotNull(this.player);
    }
    
    @Test
    public void testCardInPlayProfessor(){
    	this.player.setFaction(Faction.Professor);
    	this.card.cardInPlay();
    	assertEquals(2, this.card.getTreasures());
    	assertEquals(10, this.card.getLevel());
    }
    @Test
    public void testCardInPlayNoProfessor(){
    	this.card.cardInPlay();
    	assertEquals(2, this.card.getTreasures());
    	assertEquals(8, this.card.getLevel());
    }
    @Test
    public void testBadStuff(){
    	this.card.badStuff();
    	assertEquals(false,this.card.getOwner().isAlive());
    }
}
