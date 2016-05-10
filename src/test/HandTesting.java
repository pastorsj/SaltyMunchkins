package test;

import munchkin.api.Hand;
import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.treasures.BowlingPin;
import munchkin.cards.treasures.BrassKnucks;
import munchkin.cards.treasures.api.ITreasure;
import munchkin.game.Action;
import munchkin.game.Game;
import munchkin.game.InitializeCards;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandTesting {

	private Hand hand;
	private Action action;
	private IPlayer player;

	@Before
	public void setUp() {
		player = new Player();
		hand = new Hand(player);
		action = action.getInstance();
	}

	@After
	public void takeDown() {
		hand = null;
	}

	@Test
	public void testAddCard() {
		ITreasure knucks = new BrassKnucks();
		hand.insertCard(knucks);
		assertEquals(1, hand.sizeOfHand());
		assertTrue(hand.cardInHand(knucks));
		assertEquals("inserted BrassKnucks into your hand", action.getAction());
		assertEquals(knucks, hand.getCards().get(0));
	}

	@Test
	public void removeCardFromHand() {
		ITreasure knucks = new BrassKnucks();
		assertFalse(hand.removeCardFromHand(knucks));
		assertEquals("You have no cards to discard!", action.getAction());

		ITreasure bowling = new BowlingPin();
		hand.insertCard(bowling);
		assertFalse(hand.removeCardFromHand(knucks));
		assertEquals("This hand does not contain the card to be discarded", action.getAction());

		assertTrue(hand.removeCardFromHand(bowling));
		assertEquals("Discarded BowlingPin from your hand", action.getAction());

	}

}
