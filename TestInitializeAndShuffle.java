import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestInitializeAndShuffle {
	Main target = new Main();
	ArrayList<Integer> doorCards = new ArrayList<Integer>(100);
	ArrayList<Integer> treasureCards = new ArrayList<Integer>(68);	
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

}
