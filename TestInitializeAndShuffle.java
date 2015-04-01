import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestInitializeAndShuffle {
	Main target = new Main();
	@Test
	public void TestShuffle1() {
		ArrayList<Card> testCards = new ArrayList<Card>();
		assertEquals(testCards, target.shuffle(new ArrayList<Card>()));
	}

}
