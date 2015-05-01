import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class CardFuncTesting {
	public Game myGame;
	public InitializeCards init = new InitializeCards();
	
	
	@Before
	public void setUp() {
		myGame=new Game(init.doors,init.treasure);
		myGame.p1.pHand=myGame.dealCards();
		myGame.p2.pHand=myGame.dealCards();
		
	}
	
	@Test
	public void testPlayClass(){
		//need to test that if player with professor has lowest or tied at lowest level,
		//can discard 3 cards and go up level
		myGame.turnPlayer=1;
		myGame.p1.className="Professor";
	
		
		//write this later when discard is implemented.	
	}
	@Test
	public void func1TestInit() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func1Init();
		assertEquals(cLevel-5, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func1Test() throws IOException {
		myGame.funcs.func1(true);
		assertEquals(1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func1Test2() throws IOException {
		myGame.funcs.func1(false);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func2TestInit() {
		myGame.currentPlayer.className = "Monster Whacker";
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func2Init();
		assertEquals(cLevel-3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func2TestInit2() {
		myGame.currentPlayer.className = "Professor";
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func2Init();
		assertEquals(cLevel, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func2Test() {
		myGame.currentPlayer.className = "Monster Whacker";
		myGame.funcs.func2(true);
		assertEquals(1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func2Test2() {
		myGame.currentPlayer.className = "Monster Whacker";
		myGame.funcs.func2(false);
		assertEquals(0, myGame.currentPlayer.pHand.size());
		assertEquals("", myGame.currentPlayer.className);
	}
	
	@Test
	public void func2Test3() {
		myGame.currentPlayer.className = "Cultist";
		int sizeOfHand = myGame.currentPlayer.pHand.size();
		myGame.funcs.func2(false);
		assertEquals(sizeOfHand, myGame.currentPlayer.pHand.size());
		assertEquals("Cultist", myGame.currentPlayer.className);
	}
	
	@Test
	public void func7TestInit() {
		myGame.currentPlayer.gender = 'F';
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func7Init();
		assertEquals(cLevel+4, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func7TestInit2() {
		myGame.currentPlayer.gender = 'M';
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func7Init();
		assertEquals(cLevel, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func7Test() {
		myGame.funcs.func7(true);
		assertEquals(1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func7Test2() {
		myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		myGame.funcs.func7(false);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func8InitTest() {
		myGame.currentPlayer.pHand = myGame.dealCards();
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func8Init();
		assertEquals(cLevel-3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func8InitTest2() {
		myGame.currentPlayer.pHand = myGame.dealCards();
		myGame.currentPlayer.pHand.remove(0);
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func8Init();
		assertEquals(cLevel, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func8Test() {
		int sizeOfHand = myGame.currentPlayer.pHand.size();
		myGame.funcs.func8(true);
		assertEquals(sizeOfHand + 2, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func8Test2() {
		myGame.currentPlayer.pLevel = 3;
		int pLevel = myGame.currentPlayer.pLevel;
		myGame.funcs.func8(false);
		assertEquals(pLevel-2, myGame.currentPlayer.pLevel);	
	}
	
	@Test
	public void func8Test3() {
		int pLevel = myGame.currentPlayer.pLevel;
		myGame.funcs.func8(false);
		assertEquals(pLevel, myGame.currentPlayer.pLevel);	
	}
	
	@Test
	public void func12InitTest() {
		myGame.funcs.func12Init();
		assertEquals("Cultist", myGame.currentPlayer.className);
	}
	
	@Test
	public void func13Test() {
		myGame.currentPlayer.className = "Monster Whacker"; //Card No: 49
		myGame.dealSpecificDoorCard(49, myGame.currentPlayer);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test2() {
		myGame.currentPlayer.className = "Professor"; //Card No: 57
		myGame.dealSpecificDoorCard(57, myGame.currentPlayer);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test3() {
		myGame.currentPlayer.className = "Investigator"; //Card No: 44
		myGame.dealSpecificDoorCard(44, myGame.currentPlayer);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test4() {
		myGame.currentPlayer.className = "Cultist"; //Card No: 12
		myGame.dealSpecificDoorCard(12, myGame.currentPlayer);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test5() {
		myGame.currentPlayer.className = ""; 
		myGame.funcs.func13();
		assertEquals(0, myGame.currentPlayer.pLevel);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func14Test() {
		myGame.currentPlayer.pHand = myGame.dealCards();
		myGame.currentPlayer.pHand.add(100);
		myGame.funcs.func14();
		assertEquals(8, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func15Test() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func15();
		assertEquals(cLevel-5, myGame.currentPlayer.cLevel);
		assertEquals('M', myGame.currentPlayer.gender);
	}
	
	@Test
	public void func16Test() {
		//Deals with Cultists...
	}
	
	@Test
	public void func17Test() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func17();
		assertEquals(cLevel-3, myGame.currentPlayer.cLevel);
	}
	
}
	

	
	
	

