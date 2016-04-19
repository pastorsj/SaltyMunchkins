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
		List<ICard> treasures = this.initCards.getAllCards();
		//TODO: hard coded 16 cards for testing purpose
		assertEquals(treasures.size(), 16);
	}
	@Test
	public void TestTreasureCardsInit() {
		List<ICard> treasures = this.initCards.getTreasureCards();
		//TODO: hard coded 8 treasure cards for testing purpose
		assertEquals(treasures.size(), 8);
	}
	
	@Test
	public void TestDoorCardsInit() {
		List<ICard> treasures = this.initCards.getDoorCards();
		//TODO: hard coded 8 door cards for testing purpose
		assertEquals(treasures.size(), 8);
	}
}
