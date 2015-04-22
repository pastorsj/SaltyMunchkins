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
		init.doorHash.get(4).inPlay = true;
		
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
	
	@Test
	public void setValuesForC4(){
		assertEquals(1,init.doorHash.get(4).monsterLevel);
		assertEquals(1, init.doorHash.get(4).numTreas);
		//assertEquals(false,myGame.p1.classAbility);
	}
	
	@Test
	public void setValuesForC5(){
		assertEquals(6,init.doorHash.get(5).monsterLevel);
		assertEquals(-2,init.doorHash.get(5).monsterLevelBonus);
		assertEquals(2, init.doorHash.get(5).numTreas);
		assertEquals("Professors", init.doorHash.get(5).condForBonus);
	}
	
	@Test
	public void setValuesForC6(){
		//m6 is the card that allows players to cheat, so it is removed from the deck for this project
	}
	
	@Test
	public void setValuesForC7(){
		assertEquals(2,init.doorHash.get(7).monsterLevel);
		assertEquals(4,init.doorHash.get(7).monsterLevelBonus);
		assertEquals(1, init.doorHash.get(7).numTreas);
		assertEquals("Females", init.doorHash.get(7).condForBonus);
	}
	
	@Test
	public void setValuesForC8(){
		assertEquals(8,init.doorHash.get(8).monsterLevel);
		assertEquals(3,init.doorHash.get(8).monsterLevelBonus);
		assertEquals(2, init.doorHash.get(8).numTreas);
		//TODO: if the player has an even number of cards in hand, monsterLevelBonus is +3
	}
	
	@Test
	public void setValuesForC9(){
		//TODO: Need to figure out later
	}
	
	@Test
	public void setValuesForC10(){
		//TODO: An extra hand worth of items
	}
	
	@Test
	public void setValuesForC11(){
		//cult meeting card. 
	}
	
	@Test
	public void setValuesForC12(){
		//cultist class card
	}
	
	@Test
	public void setValuesForC13(){
		//TODO: Lose your class
	}
	
	@Test
	public void setValuesForC14(){
	}
	
	@Test
	public void setValuesForC84(){
		assertEquals(500,init.treasureHash.get(84).numGold);
		assertEquals(2, init.treasureHash.get(84).numHands);
		assertEquals(4, init.treasureHash.get(84).pLevelBonus);
	}
	
	@Test
	public void setValuesForC85(){
		assertEquals(600,init.treasureHash.get(85).numGold);
	}
	
	@Test
	public void setValuesForC86(){
		assertEquals(200,init.treasureHash.get(86).numGold);
		assertEquals(1, init.treasureHash.get(86).numHands);
		assertEquals(2, init.treasureHash.get(86).pLevelBonus);
	}
	
	@Test
	public void setValuesForC87(){
		assertEquals(200,init.treasureHash.get(87).numGold);
		assertEquals(1, init.treasureHash.get(87).pLevelBonus);
	}
	
	@Test
	public void setValuesForC88() {
		assertEquals(300, init.treasureHash.get(88).numGold);
		assertEquals(1, init.treasureHash.get(88).numHands);
		assertEquals(2, init.treasureHash.get(88).pLevelBonus);
	}
	
	@Test
	public void setValuesForC89() {
		assertEquals(true, init.treasureHash.get(89).goUpALevel);
	}
}
