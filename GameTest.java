import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;


public class GameTest {
	ArrayList<Integer> doors = new ArrayList<Integer>();
	ArrayList<Integer> treasures = new ArrayList<Integer>();
	Game target = new Game(doors, treasures);
	@Test
	public void testCardNotNull() {
		assertNotNull(target);
	}
}
