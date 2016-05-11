package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.treasures.SushiKnifeofDoom;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class SushiKnifeofDoomTesting {

	private SushiKnifeofDoom card;
	private Game game;
	private IPlayer player;
	
    @Before
    public void setUp() {
    	this.game=new Game(2);
    	this.player=new Player();
    	this.card = new SushiKnifeofDoom(this.game);
    	this.card.setOwner(this.player);
    }

    @After
    public void takeDown() {
    	this.game=null;
    	this.card=null;
    }

    @Test
    public void testInit() {
    	assertNotNull(this.card);
    }
    
 	@Test
 	public void testSetAndGetDiscard() {
 		this.card.setDiscard();
 		assertTrue(this.card.checkDiscard());
 	}
 	
	@Test
	public void testCardInHand(){
		this.card.cardInHand();
		assertEquals(300, this.card.getGold());
	}
	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(2, this.card.getBonus());
		assertEquals(Armor.OneHand, this.card.getArmor());
	}
}
