package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.CreatedUsingCinematicRules;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreatedUsingCinematicRulesTesting {
	private CreatedUsingCinematicRules card;
	private IPlayer player;
	
	@Before
	public void setUp() {
		this.card = new CreatedUsingCinematicRules();
		this.player = new Player();
		this.player.addCardToHand(this.card);
		this.card.setOwner(this.player);
	}

	@After
	public void takeDown() {
		this.card = null;
		this.player=null;
	}

	@Test
	public void testCardNotNull(){
		assertNotNull(this.card);
	}
	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(3, this.card.getOwner().getArmorSet().getMaxHands());
	}
	
}
