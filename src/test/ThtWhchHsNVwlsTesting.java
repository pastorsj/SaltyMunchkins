package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.ThtWhchHsNVwls;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ThtWhchHsNVwlsTesting {
	private ThtWhchHsNVwls card;
	private IPlayer player;

	@Before
	public void setUp() {
		this.card = new ThtWhchHsNVwls();
		this.player = new Player();
		this.player.addToPlayerLevel(3);
		this.player.addCardToHand(this.card);
		this.card.setOwner(this.player);
	}

	@After
	public void takeDown() {
		this.card = null;
		this.player=null;
	}

	@Test
	public void testCardNotNull() {
		assertNotNull(this.card);
	}
	
	@Test
	public void testCardInPlayWhenPlayerLevelIsLessThan4(){
		this.card.cardInPlay();
		assertEquals(0, this.card.getTreasures());
		assertEquals(0, this.card.getLevel());
	}
	@Test
	public void testCardInPlayWhenPlayerLevelGreaterThanFour(){
		this.player.addToPlayerLevel(5);
		this.card.cardInPlay();
		assertEquals(5, this.card.getTreasures());
		assertEquals(18, this.card.getLevel());
	}
	@Test
	public void testBadStuff(){
		this.card.cardInPlay();
		this.card.badStuff();
		assertEquals(0,this.card.getOwner().getHand().getCards().size());
	}
}
