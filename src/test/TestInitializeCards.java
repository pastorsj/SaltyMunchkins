package test;

import munchkin.api.ICard;
import munchkin.game.Game;
import munchkin.game.InitializeCards;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TestInitializeCards {
	private Game game;
	private InitializeCards initCards;
	@Before
	public void setUp() {
		game = new Game(2);
		initCards= new InitializeCards(game);
		
	}

	@Test
	public void testGameNotNull() {
		assertNotNull(this.initCards);
	}
	@After
	public void takeDown() {
		this.game=null;
		this.initCards=null;
	}
	@Test
	public void TestAllCardsInit() {
		List<ICard> allCards = this.initCards.getAllCards();
		assertEquals(94, allCards.size());
	}
	@Test
	public void TestTreasureCardsInit() {
		List<ICard> treasureCards = this.initCards.getTreasureCards();
		assertEquals(47, treasureCards.size());
	}
	
	@Test
	public void TestDoorCardsInit() {
		List<ICard> doorCards = this.initCards.getDoorCards();
		assertEquals(47, doorCards.size());
	}
}
