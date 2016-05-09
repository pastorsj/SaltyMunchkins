package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.TheKinginPink;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TheKinginPinkTesting {
	private TheKinginPink card;
	private IPlayer player;

	@Before
	public void setUp() {
		this.card = new TheKinginPink();
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
	public void testCardInPlayWhenPlayerLevelIsLessThan3(){
		this.card.cardInPlay();
		assertEquals(0, this.card.getTreasures());
		assertEquals(0, this.card.getLevel());
	}
	@Test
	public void testCardInPlayWhenPlayerLevelGreaterThan3AndMale(){
		this.player.addToPlayerLevel(5);
		this.player.setGender("Male");
		this.card.cardInPlay();
		assertEquals(4, this.card.getTreasures());
		assertEquals(14, this.card.getLevel());
	}
	@Test
	public void testCardInPlayWhenPlayerLevelGreaterThan3AndFemale(){
		this.player.addToPlayerLevel(5);
		this.player.setGender("Female");
		this.card.cardInPlay();
		assertEquals(4, this.card.getTreasures());
		assertEquals(16, this.card.getLevel());
	}
	
	@Test
	public void testBadStuff(){
		this.player.addToPlayerLevel(3);
		int numCardsInHand=this.card.getOwner().getHand().getCards().size();
		int playerLevel = this.player.getPlayerLevel();
		this.card.cardInPlay();
		this.card.badStuff();
		assertEquals(playerLevel-numCardsInHand,this.player.getPlayerLevel());
	}
}
