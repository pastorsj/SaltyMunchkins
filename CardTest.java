import static org.junit.Assert.*;

import org.junit.Test;


public class CardTest {
	
	@Test
	public void testCardNotNull() {
		Card target = new Card(10, "BOOO");
		assertNotNull(target);
	}
	
}
