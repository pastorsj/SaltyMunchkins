import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class TestInitializeAndShuffle {
	
	ArrayList<Integer> doorCards = new ArrayList<Integer>(100);
	ArrayList<Integer> treasureCards = new ArrayList<Integer>(68);	
	Game target = new Game(doorCards,treasureCards);
	Player targetPlayer = new Player("Player1");
	
	@Before
	public void setUp() {
		for(int i = 0; i < 100; i++) {
			doorCards.add(i);
		}
		for(int i = 0; i < 68; i++) {
			treasureCards.add(i);
		}
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
		assertEquals(true, target.dealNewCard(doorCards, targetPlayer));
	}
	@Test
	public void TestDeal2() {
		targetPlayer.pHand = new ArrayList<Integer>(8);
		assertEquals(false, target.dealNewCard(doorCards, targetPlayer));
	}
}
