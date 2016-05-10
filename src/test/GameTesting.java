package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import munchkin.api.ICard;
import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Action;
import munchkin.game.Game;

public class GameTesting {

	private Game g;
	
	@Before
	public void SetUp(){
		g = new Game(2);
	}
	
	@Test
	public void testGetCurrentPlayer() {
		IPlayer first = g.getPlayers().peek();
		assertEquals(first, g.getCurrentPlayer());
	}
	
	@Test
	public void testGetOtherPlayer() {
		Queue<IPlayer> copy = new LinkedList<IPlayer>(g.getPlayers());
		IPlayer first = copy.poll();
		IPlayer second = copy.poll();
		assertEquals(second, g.getOtherPlayer());
	}
	
	@Test
	public void testShuffle(){
		//not sure how to test this yet
	}
	
	@Test
	public void testDealGivesRightNumCards(){
		//deal happens on game initialization
		for (IPlayer player : g.getPlayers()){
			assertEquals(8, player.getHand().sizeOfHand());
		}
	}
	
	@Test
	public void testDealDoorCard(){
		IPlayer p = g.getCurrentPlayer();
		int init = p.getHand().sizeOfHand();
		ICard card = g.dealNewDoorCard(p);
		assertTrue(card instanceof Door);
		assertEquals(init+1, p.getHand().sizeOfHand());
	}
	
	@Test
	public void testDealTreasureCard(){
		IPlayer p = g.getCurrentPlayer();
		int init = p.getHand().sizeOfHand();
		ICard card = g.dealNewTreasureCard(p);
		assertTrue(card instanceof Treasure);
		assertEquals(init+1, p.getHand().sizeOfHand());
	}
	
	@Test
	public void testDrawACardSuccessfully(){
		g.getCurrentPlayer().getHand().getCards().clear();
		ICard card = g.drawACard(g.getAllCards(), g.getCurrentPlayer());
		System.out.println(card.getName());
		assertTrue(card instanceof ICard);
		assertEquals(1, g.getCurrentPlayer().getHand().sizeOfHand());
	}
	
	@Test
	public void testDiscardSuccessfully(){
		IPlayer p = g.getCurrentPlayer();
		ICard c = p.getHand().getCards().get(0);
		assertTrue(p.getHand().cardInHand(c));
		assertEquals(p,c.getOwner());
		g.discardCard(p, c);
		assertFalse(p.getHand().cardInHand(c));
		assertEquals(null, c.getOwner());
	}
	
	@Test
	public void testDiscardUnsuccessfully(){
		IPlayer p = g.getCurrentPlayer();
		ICard c = p.getHand().getCards().get(0);
		assertTrue(p.getHand().cardInHand(c));
		assertEquals(p,c.getOwner());
		g.discardCard(p, c);
		assertFalse(p.getHand().cardInHand(c));
		assertEquals(null, c.getOwner());
		
		//try to discard again but dont have it anymore
		assertFalse(p.getHand().cardInHand(c));
		assertFalse(g.discardCard(p, c));
	}
	
	@Test
	public void testPlayCard(){
		IPlayer p = g.getCurrentPlayer();
		ICard c = p.getHand().getCards().get(0);
		
		
	}

}
