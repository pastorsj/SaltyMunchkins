import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class Mile3Testing {
	public ArrayList<Integer> p1cards;
	public ArrayList<Integer> p2cards;
	public Game myGame;
	public InitializeCards init = new InitializeCards();
	
	@Before
	public void setUp() {
		p1cards = new ArrayList<Integer>();
		p2cards= new ArrayList<Integer>();
		myGame=new Game(init.doors,init.treasure);
		
		p1cards.add(1);
		p1cards.add(2);
		p2cards.add(3);
		p2cards.add(4);
		p1cards.add(84);
		p1cards.add(85);
		p2cards.add(86);
		p2cards.add(87);
		
		 myGame.p1.pHand=p1cards;
		 myGame.p2.pHand=p2cards;
		init.doorHash.get(1).addNum=5;
		
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
		 assertNotNull(myGame.p1.pHand);
		 assertNotNull(myGame.p2.pHand);
	}
	
	@Test
	public void setAddNumForC1(){
		assertEquals(5,init.doorHash.get(1).addNum);
	}
	
	@Test
	public void setValuesForC2(){
		assertEquals(2,init.doorHash.get(2).monsterLevel);
		assertEquals(3,init.doorHash.get(2).monsterLevelBonus);
		assertEquals(1, init.doorHash.get(2).numTreas);
		assertEquals("Monster Whacker", init.doorHash.get(2).condForBonus);
	}

	@Test
	public void setValuesForC3(){
		assertEquals(3,init.doorHash.get(3).addNum);
	}
}
