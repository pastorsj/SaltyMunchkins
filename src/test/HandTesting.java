package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import munchkin.api.Hand;
import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.treasures.BrassKnucks;
import munchkin.cards.treasures.api.ITreasure;

public class HandTesting {
	
	private Hand hand;
	
	@Before
	public void setUp(){
		IPlayer player = new Player();
		hand = new Hand(player);
	}

	@Test
	public void testAddCard() {
		ITreasure knucks = new BrassKnucks();
		hand.insertCard(knucks);
		assertEquals(1, hand.sizeOfHand());
		assertTrue(hand.cardInHand(knucks));
		assertEquals(knucks, hand.getCards().get(0));
	}
	
	@Test
	public void addTooManyCards(){
		ITreasure knucks = new BrassKnucks();
		for(int i = 0; i < 8; i++){
			assertTrue(hand.insertCard(knucks));
			assertEquals(i+1, hand.sizeOfHand());
		}
		assertFalse(hand.insertCard(knucks));
	}
	
	@Test
	public void removeCardFromHand(){
		
	}

}
