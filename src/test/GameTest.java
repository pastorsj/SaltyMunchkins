//package test;
//
//import munchkin.game.Game;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class GameTest {
//
//	private ArrayList<Integer> doors;
//	private ArrayList<Integer> treasures;
//	private Game target;
//
//	@Before
//	public void setUp() {
//		this.doors = new ArrayList<Integer>();
//		this.treasures = new ArrayList<Integer>();
//		for (int i = 0; i < 10; i++) {
//			this.doors.add(i);
//			this.treasures.add(10 + i);
//		}
//		this.target = new Game(this.doors, this.treasures);
//	}
//
//	@After
//	public void takeDown() {
//		this.doors = null;
//		this.treasures = null;
//		this.target = null;
//	}
//
//	@Test
//	public void testGameNotNull() {
//		assertNotNull(target);
//	}
//
//	@Test
//	public void testGameDealCardsReturnArrayListOfLength8() {
//		assertEquals(8, target.p1.pHand.size());
//	}
//
//	@Test
//	public void testGameDealCardsReturnArrayListOfUniqueCards() {
//		boolean result = true;
//		for(int j=0;j<target.p1.pHand.size();j++){
//			result &= target.p1.pHand.contains(target.p1.pHand.get(j));
//		}
//		assertEquals(true,result);
//	}
//
//}
