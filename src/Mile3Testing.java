import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class Mile3Testing {
	public ArrayList<Card> cards;
	
	@Before
	public void setUp() {
	}
	@Test
	public void CardsNotNull() {
		assertNotNull(cards);
		
	}

}
