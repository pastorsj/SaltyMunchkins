package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.ICard;
import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.Buggoth;
import munchkin.cards.doors.Coggoth;

public class CoggothTesting {
	private Coggoth card;
	private IPlayer player;
	
	@Before
	public void setUp() {
		this.card = new Coggoth();
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
		assertEquals(8, this.card.getLevel());
		
		ICard newCard = new Buggoth();
		this.player.addCardToHand(newCard);
		this.card.cardInPlay();
		assertEquals(11, this.card.getLevel());
		
		assertEquals(2, this.card.getTreasures());
	}
	
	@Test
	public void testBadStuff(){
		this.card.cardInPlay();
		this.player.addLevel(3);
		this.card.badStuff();
		assertEquals(1, this.player.getPlayerLevel());
	}
	
}
