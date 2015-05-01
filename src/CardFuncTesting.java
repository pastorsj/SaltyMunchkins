import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class CardFuncTesting {
	public Game myGame;
	
	
	@Before
	public void setUp() {
		ArrayList<Integer> doors = new ArrayList<Integer>(82);
		ArrayList<Integer> treasures = new ArrayList<Integer>(67);
		for(int i = 1; i <= 82; i++) {
			doors.add(i);
		}
		for(int i = 1; i <= 67; i++) {
			treasures.add(82 + i);
		}
		myGame=new Game(doors, treasures);
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
		myGame.currentPlayer.pHand.add(49);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test2() {
		myGame.currentPlayer.className = "Professor"; //Card No: 57
		myGame.currentPlayer.pHand.add(57);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test3() {
		myGame.currentPlayer.className = "Investigator"; //Card No: 44
		myGame.currentPlayer.pHand.add(44);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test4() {
		myGame.currentPlayer.className = "Cultist"; //Card No: 12
		myGame.currentPlayer.pHand.add(12);
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
	
	@Test
	public void func17Test2() {
		//Miner's Helmet is 111
		//Two Handed Flashlight is 146
		myGame.dealSpecificTreasureCard(111, myGame.currentPlayer);
		myGame.dealSpecificTreasureCard(146, myGame.currentPlayer);
		myGame.funcs.func17();
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func18Test() {
		//Need to test for armor somehow?
	}
	
	@Test
	public void func19Test() {
		//Need to test for head armor...
	}
	
	@Test
	public void func20Test() {
		myGame.currentPlayer.className = "Monster Whacker"; //Card No: 49
		myGame.currentPlayer.pHand.add(49);
		myGame.funcs.func20();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func20Test2() {
		myGame.currentPlayer.className = "Professor"; //Card No: 57
		myGame.currentPlayer.pHand.add(57);
		myGame.funcs.func20();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func20Test3() {
		myGame.currentPlayer.className = "Investigator"; //Card No: 44
		myGame.currentPlayer.pHand.add(44);
		myGame.funcs.func20();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func20Test4() {
		myGame.currentPlayer.className = "Cultist"; //Card No: 12
		myGame.currentPlayer.pHand.add(12);
		myGame.funcs.func20();
		assertEquals("Cultist", myGame.currentPlayer.className);
		assertEquals(1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func21Test() {
		//Not implemented yet...
	}
	
	@Test
	public void func22Test() {
		int pLevel = myGame.currentPlayer.pLevel;
		myGame.funcs.func22();
		assertEquals(pLevel-1, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func23() {
		//Player must discard at least 1000 gold pieces
	}
	
	@Test
	public void func24() {
		//Lose the footgear on your character...
	}
	
	@Test
	public void func25() {
		//Another complicated curse that needs an algorithm
	}
	
	@Test
	public void func26InitTest() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.changePlayer();
		myGame.currentPlayer.pPlay.add(100);
		myGame.changePlayer();
		myGame.funcs.func26Init();
		assertEquals(cLevel-6, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func26InitTest2() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.changePlayer();
		myGame.currentPlayer.pPlay.add(132);
		myGame.changePlayer();
		myGame.funcs.func26Init();
		assertEquals(cLevel-4, myGame.currentPlayer.cLevel);
	}
}
	

	
	
	

