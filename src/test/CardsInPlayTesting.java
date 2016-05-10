package test;

import munchkin.api.CardsInPlay;
import munchkin.api.Player;
import munchkin.cards.treasures.BrassKnucks;
import munchkin.game.Action;
import munchkin.game.Game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardsInPlayTesting {

	private CardsInPlay cards;
	private BrassKnucks knucks;
	
	@Before
	public void setUp(){
		cards = new CardsInPlay(new Game(2));
		knucks = new BrassKnucks();
	}
	
	@Test
	public void testAddCardToPlay() {
		cards.addCardsToPlay(knucks);
		assertTrue(cards.contains(knucks));
		assertFalse(cards.addCardsToPlay(knucks));
	}
	
	@Test
	public void testRemoveCardFromPlay(){
		assertFalse(cards.removeCardFromPlay(knucks));
		assertTrue(cards.addCardsToPlay(knucks));
		assertTrue(cards.removeCardFromPlay(knucks));
	}

}
