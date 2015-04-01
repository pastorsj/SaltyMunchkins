import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class GameTest {
	ArrayList<Integer> doors = new ArrayList<Integer>();
	ArrayList<Integer> treasures = new ArrayList<Integer>();
	Game target = new Game(doors, treasures);
	@Test
	public void testGameNotNull() {
		assertNotNull(target);
	}
	
	@Test
	public void testGameDealCardsReturnArrayListOfLength8() {
		assertEquals(8, target.dealCards());
	}
	
}
