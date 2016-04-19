package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import munchkin.api.CardsInPlay;
import munchkin.cards.treasures.BrassKnucks;
import munchkin.game.Action;

public class CardsInPlayTesting {

	private CardsInPlay cards;
	private BrassKnucks knucks;
	private Action action;
	
	@Before
	public void setUp(){
		cards = new CardsInPlay();
		knucks = new BrassKnucks();
		action = Action.getInstance();
	}
	
	@Test
	public void testAddCardToPlay() {
		cards.addCardsToPlay(knucks);
		assertTrue(cards.contains(knucks));
		assertEquals("Added BrassKnucks to play", action.getAction());
		
		cards.addCardsToPlay(knucks);
		assertEquals("Can't add the card to play: Card already in play!", action.getAction());
	}
	
	@Test
	public void testRemoveCardFromPlay(){
		cards.removeCardFromPlay(knucks);
		assertEquals("Attempting to remove card that does not exist!",action.getAction());
		
		cards.addCardsToPlay(knucks);
		assertTrue(cards.contains(knucks));
		assertEquals("Added BrassKnucks to play", action.getAction());
		cards.removeCardFromPlay(knucks);
		assertEquals("Removed card from play successfully", action.getAction());
	}

}
