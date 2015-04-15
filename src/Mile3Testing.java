import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class Mile3Testing {
	public ArrayList<Card> cards;
	
	@Before
	public void setUp() {
		cards = new ArrayList<Card>();
		Card c1 = new Card(1, "");
		Card c2 = new Card(2, "");
		Card c3 = new Card(3, "");
		Card c4 = new Card(4, "");
		
		Card c84 = new Card(84, "");
		Card c85 = new Card(85, "");
		Card c86 = new Card(87, "");
		Card c87 = new Card (88, "");
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c84);
		cards.add(c85);
		cards.add(c86);
		cards.add(c87);
		
		
		
	}
	@Test
	public void CardsNotNull() {
		assertNotNull(cards);
		
	}
	
	@Test
	public void EightCardsAdded(){
		assertEquals(8,cards.size());
	}

}
