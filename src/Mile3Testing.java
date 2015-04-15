import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class Mile3Testing {
	public ArrayList<Integer> p1cards;
	public ArrayList<Integer> p2cards;
	
	@Before
	public void setUp() {
		p1cards = new ArrayList<Integer>();
		p2cards= new ArrayList<Integer>();
		
		p1cards.add(1);
		p1cards.add(2);
		p2cards.add(3);
		p2cards.add(4);
		p1cards.add(84);
		p1cards.add(85);
		p2cards.add(86);
		p2cards.add(87);
		
		
	}
	@Test
	public void CardsNotNull() {
		assertNotNull(p1cards);
		assertNotNull(p2cards);
		
	}
	
	@Test
	public void EightCardsAdded(){
		assertEquals(4,p1cards.size());
		assertEquals(4,p2cards.size());
	}
	
	@Test
	public void setPlayerHands(){
		 Game myGame = new Game();
		 assertNotNull(myGame.p1.pHand);
	}

}
