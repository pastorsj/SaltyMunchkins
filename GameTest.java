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
		for (int i = 0; i < 10; i++) {
			doors.add(i);
			treasures.add(10 + i);
		}
		assertEquals(8, target.dealCards().size());
	}

}
