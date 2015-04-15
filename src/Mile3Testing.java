import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class Mile3Testing {
	public ArrayList<Card> p1cards;
	public ArrayList<Card> p2cards;
	
	@Before
	public void setUp() {
		p1cards = new ArrayList<Card>();
		p2cards= new ArrayList<Card>();
		Card c1 = new Card(1, "");
		Card c2 = new Card(2, "");
		Card c3 = new Card(3, "");
		Card c4 = new Card(4, "");
		
		Card c84 = new Card(84, "");
		Card c85 = new Card(85, "");
		Card c86 = new Card(87, "");
		Card c87 = new Card (88, "");
		
		p1cards.add(c1);
		p1cards.add(c2);
		p2cards.add(c3);
		p2cards.add(c4);
		p1cards.add(c84);
		p1cards.add(c85);
		p2cards.add(c86);
		p2cards.add(c87);
		
		
	}
	@Test
	public void CardsNotNull() {
		assertNotNull(cards);
		
	}
	
	@Test
	public void EightCardsAdded(){
		assertEquals(8,cards.size());
	}
	
	@Test
	public void setAddNum(){
		 Game myGame = new Game();
		 myGame.p1.pHand=
	}

}
