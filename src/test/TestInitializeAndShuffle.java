package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.game.Card;
import munchkin.game.Game;
import munchkin.game.Player;


public class TestInitializeAndShuffle {
	HashMap<Integer,Card> doorHash = new HashMap<Integer, Card>();
	HashMap<Integer, Card> treasureHash=new HashMap<Integer, Card>();
	ArrayList<Integer> doorCardArray = new ArrayList<Integer>();
	ArrayList<Integer> treasureCardArray = new ArrayList<Integer>();
	ArrayList<Integer> doorCards = new ArrayList<Integer>(100);
	ArrayList<Integer> treasureCards = new ArrayList<Integer>(68);
	Player targetPlayer = new Player("Player1");
	Game target;
	
	@Before
	public void setUp() {
		for(int i = 0; i < 100; i++) {
			doorCards.add(i);
		}
		for(int i = 0; i < 68; i++) {
			treasureCards.add(i);
		}
		for(int i = 0; i < 8; i++) {
			targetPlayer.pHand.add(i);
		}
		target = new Game(doorCards,treasureCards);
	}
	
	@After
	public void takeDown() {
		this.doorCards = null;
		this.treasureCards = null;
		this.targetPlayer = null;
		this.target = null;
	}
	@Test
	public void TestShuffle1() {
		ArrayList<Integer> testCards = new ArrayList<Integer>();
		assertEquals(testCards, target.shuffle(new ArrayList<Integer>()));
	}
	@Test
	public void TestShuffle2() {
		assertEquals(doorCards.size(), target.shuffle(doorCards).size());
	}
	@Test
	public void TestShuffle3() {
		assertNotEquals(Arrays.toString(doorCards.toArray()), Arrays.toString(target.shuffle(doorCards).toArray()));
	}
	@Test
	public void TestShuffle4() {
		assertNotEquals(target.shuffle(doorCards).toArray()[10], target.shuffle(doorCards).toArray()[10]);
	}
	@Test
	public void TestDeal1() {
		targetPlayer.pHand.remove(7);
		assertEquals(true, target.dealNewCard(doorCards, targetPlayer));
	}
	@Test
	public void TestDeal2() {
		assertEquals(false, target.dealNewCard(doorCards, targetPlayer));
	}
	@Test
	public void TestDeal3() {
		targetPlayer.pHand.remove(7);
		assertEquals(true, target.dealNewCard(doorCards, targetPlayer));
		target.dealNewCard(doorCards, targetPlayer);
		assertEquals(8, targetPlayer.pHand.size());
	}
	@Test
	public void TestDeal4() {
		//game initialization deals 4 door cards to each player
		targetPlayer.pHand.remove(7);
		assertEquals(true, target.dealNewCard(doorCards, targetPlayer));
		//deal one more card
		assertEquals(91, doorCards.size());
	}
	@Test
	public void TestDiscard1() {
		targetPlayer.pHand.remove(7);
		assertEquals(false, target.mustDiscard(targetPlayer));
	}
	@Test
	public void TestDiscard2() {
		assertEquals(true, target.mustDiscard(targetPlayer));
	}
	@Test
	public void TestDiscard3() {
		targetPlayer.pHand.add(9);
		assertEquals(true,target.mustDiscard(targetPlayer));
	}
	@Test
	public void TestDiscard4() {
		assertEquals(true, target.discardCard(targetPlayer, 1));
	}
	@Test
	public void TestDiscard5() {
		assertEquals(true, target.discardCard(targetPlayer, 1));
		assertEquals(7, targetPlayer.pHand.size());
	}
	@Test
	public void TestDiscard6() {
		assertEquals(true, target.discardCard(targetPlayer, 1));
		assertEquals(7, targetPlayer.pHand.size());
		assertEquals(1, target.returnDiscardPile().size());
	}
}
