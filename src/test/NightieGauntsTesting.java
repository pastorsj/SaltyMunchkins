package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.doors.NightieGaunts;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class NightieGauntsTesting {
	private NightieGaunts card;
	private Player player;
    @Before
    public void setUp() {
    	this.card=new NightieGaunts();
    	this.player=new Player();
    	this.card.setOwner(this.player);
    }


	@After
	public void takeDown() {
		this.player = null;
		this.card = null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.player);
	}
	
	@Test
	public void testCardInPlayMale(){
		this.player.setGender("Male");
		this.card.cardInPlay();
		assertEquals(4, this.card.getTreasures());
		assertEquals(17, this.card.getLevel());
	}
	@Test
	public void testCardInPlayFemale(){
		this.player.setGender("Female");
		this.card.cardInPlay();
		assertEquals(4, this.card.getTreasures());
		assertEquals(14, this.card.getLevel());
	}

}
