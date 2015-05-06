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
	public void func1Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func1(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func1Test2() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func1(false);
		assertEquals(size, myGame.currentPlayer.treasuresWonEachTurn);
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
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.currentPlayer.className = "Monster Whacker";
		myGame.funcs.func2(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func2Test2() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.currentPlayer.className = "Monster Whacker";
		myGame.funcs.func2(false);
		assertEquals(size, myGame.currentPlayer.treasuresWonEachTurn);
		assertEquals("", myGame.currentPlayer.className);
	}
	
	@Test
	public void func2Test3() {
		myGame.currentPlayer.className = "Cultist";
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func2(false);
		assertEquals(size, myGame.currentPlayer.treasuresWonEachTurn);
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
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func7(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func7Test2() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.funcs.func7(false);
		assertEquals(size-1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func8InitTest() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func8Init();
		assertEquals(cLevel-3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func8InitTest2() {
		myGame.currentPlayer.pHand.remove(0);
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func8Init();
		assertEquals(cLevel, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func8Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func8(true);
		assertEquals(size+2, myGame.currentPlayer.treasuresWonEachTurn);
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
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.className = "Monster Whacker"; //Card No: 49
		myGame.currentPlayer.pHand.add(49);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(size, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test2() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.className = "Professor"; //Card No: 57
		myGame.currentPlayer.pHand.add(57);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(size, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test3() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.className = "Investigator"; //Card No: 44
		myGame.currentPlayer.pHand.add(44);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(size, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test4() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.className = "Cultist"; //Card No: 12
		myGame.currentPlayer.pHand.add(12);
		myGame.funcs.func13();
		assertEquals("", myGame.currentPlayer.className);
		assertEquals(size, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func13Test5() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.className = ""; 
		myGame.funcs.func13();
		assertEquals(0, myGame.currentPlayer.pLevel);
		assertEquals(size, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func14Test() {
		myGame.currentPlayer.pHand.remove(7);
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
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.pHand.add(111);
		myGame.currentPlayer.pHand.add(146);
		myGame.funcs.func17();
		assertEquals(size, myGame.currentPlayer.pHand.size());
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
		int size = myGame.currentPlayer.pHand.size();
		//Card No: 49
		myGame.currentPlayer.pHand.add(49);
		myGame.funcs.func20();
		assertEquals("", myGame.currentPlayer.className);
		assertTrue(myGame.currentPlayer.pHand.size() <= size);
	}
	
	@Test
	public void func20Test2() {
		//Card No: 57
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.pHand.add(57);
		myGame.funcs.func20();
		assertEquals("", myGame.currentPlayer.className);
		assertTrue(myGame.currentPlayer.pHand.size() <= size);
	}
	
	@Test
	public void func20Test3() {
		int size = myGame.currentPlayer.pHand.size();
		//Card No: 44
		myGame.currentPlayer.pHand.add(44);
		myGame.funcs.func20();
		assertEquals("", myGame.currentPlayer.className);
		assertTrue(myGame.currentPlayer.pHand.size() <= size);
	}
	
	@Test
	public void func20Test4() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.pHand.remove(size-1);
		myGame.currentPlayer.className = "Cultist"; //Card No: 12
		myGame.currentPlayer.pHand.add(12);
		myGame.funcs.func20();
		assertEquals("Cultist", myGame.currentPlayer.className);
		assertTrue(myGame.currentPlayer.pHand.size() <= size);
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
	
	@Test
	public void func26Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func26(true);
		assertEquals(size + 3, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func26Test2() {
		int sizeOfHand = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.className = "Investigator";
		myGame.changePlayer();
		int sizeOfOtherHand = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.className = "Cultist";
		myGame.changePlayer();
		myGame.funcs.func26(false);
		assertEquals(sizeOfHand - 1, myGame.currentPlayer.pHand.size());
		myGame.changePlayer();
		assertEquals(sizeOfOtherHand + 1, myGame.currentPlayer.pHand.size());
		myGame.changePlayer();
	}
	
	@Test
	public void func27InitTest() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.currentPlayer.className = "Professor";
		myGame.funcs.func27Init();
		assertEquals(cLevel-2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func27Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func27(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func27Test2() {
		//Last test needs to discard cards worth at least 500 gold
		//Dependent on the user...
	}
	
	@Test
	public void func28InitTest() {
		myGame.currentPlayer.cLevel += 5;
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func28Init();
		assertEquals(myGame.currentPlayer.pLevel, myGame.currentPlayer.cLevel);
	}
//Once we implement the Ichor cards, this test will work :)	
//	@Test
//	public void func28InitTest2() {
//		int cLevel = myGame.currentPlayer.cLevel;
//		myGame.currentPlayer.pPlay.add(137);
//		myGame.changePlayer();
//		myGame.currentPlayer.pPlay.add(100);
//		myGame.changePlayer();
//		myGame.funcs.func28Init();
//		assertEquals(cLevel+1, myGame.currentPlayer.cLevel);
//	}
	
	@Test
	public void func28Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func28(true);
		assertEquals(size + 2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func28Test2() {
		//We need to check that the player gives another card to the other player
		//Will change once implemented with gui
		//Right now, it will take the last card in the current players hand and give it to the other player
		int size1 = myGame.currentPlayer.pHand.size();
		myGame.changePlayer();
		myGame.currentPlayer.pHand.remove(size1-1);
		int size2 = myGame.currentPlayer.pHand.size();
		myGame.changePlayer();
		myGame.funcs.func28(false);
		assertEquals(size1-1, myGame.currentPlayer.pHand.size());
		assertEquals(size2, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func29InitTest() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func29Init();
		assertEquals(cLevel-10, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func29Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func29(true);
		assertEquals(size + 2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func30InitTest() {
		myGame.currentPlayer.className = "Monster Whacker";
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func30Init();
		assertEquals(cLevel+2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func30Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func30(true);
		assertEquals(size + 3, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func32InitTest() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.funcs.func32Init();
		assertEquals(size-1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func32Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func32(true);
		assertEquals(size + 3, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func32Test2() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.currentPlayer.pHand.remove(size-1);
		myGame.currentPlayer.pHand.remove(size-2);
		myGame.currentPlayer.pHand.add(85);
		myGame.currentPlayer.pHand.add(100);
		myGame.funcs.func32(false);
		assertTrue(myGame.currentPlayer.pHand.size() <= size-2);
	}
	
	@Test
	public void func33InitTest() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.currentPlayer.gender = 'F';
		myGame.funcs.func33Init();
		assertEquals(cLevel + 2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func33Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func33(true);
		assertEquals(size+2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func35InitTest() {
		myGame.currentPlayer.className = "Professor";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func35Init();
		assertEquals(level+2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func35InitTest2() {
		myGame.currentPlayer.className = "Investigator";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func35Init();
		assertEquals(level+2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func35Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func35(true);
		assertEquals(size+4, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func35Test1() {
		//Somehow, we must test that the other person helps them in their next combat
	}
	
	@Test
	public void func36InitTest() {
		myGame.currentPlayer.gender = 'M';
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func36Init();
		assertEquals(level-3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func36InitTest2() {
		//Need to somehow test to make sure that male munchkins cannot help
	}
	
	@Test
	public void func36Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func36(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func36Test2() {
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func36(false);
		assertEquals(level-1, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func37InitTest() {
		int level = myGame.currentPlayer.cLevel;
		myGame.currentPlayer.gender = 'F';
		myGame.funcs.func37Init();
		assertEquals(level + 2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func37Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func37(true);
		assertEquals(size+3, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func37Test2() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.funcs.func37(false);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func38InitTest() {
		myGame.currentPlayer.className = "";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func38Init();
		assertEquals(level + 4, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func38Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func38(true);
		assertEquals(size + 5, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func38Test2() {
		myGame.funcs.func38(false);
		assertEquals(0, myGame.currentPlayer.pHand.size());
		assertEquals("Cultist", myGame.currentPlayer.className);
	}
	
	@Test
	public void func39InitTest() {
		myGame.currentPlayer.className = "Investigator";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func39Init();
		assertEquals(level-3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func39InitTest2() {
		myGame.currentPlayer.className = "Investigator";
		myGame.funcs.func39Init();
		assertEquals("Cultist", myGame.currentPlayer.className);
	}
	
	@Test
	public void func39Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func39(true);
		assertEquals(size+2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func42TestInit() {
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func42Init();
		assertEquals(level + 5, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func42Test() {
		//Need to deal one less treasure card to the current player
		myGame.funcs.func26(true);
		myGame.funcs.func42(true);
		assertEquals(2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func42Test2() {
		//Need to deal one less treasure card to the current player
		myGame.funcs.func36(true);
		myGame.funcs.func42(true);
		assertEquals(1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func43InitTest() {
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func43Init();
		assertEquals(level-10, myGame.currentPlayer.cLevel);
	}

	@Test
	public void func43Test() {
		int num = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func43(true);
		assertEquals(num + 2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func44InitTest() {
		myGame.currentPlayer.className = "";
		myGame.funcs.func44Init();
		assertEquals("Investigator", myGame.currentPlayer.className);
	}
	
	@Test
	public void func45Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func45(true);
		assertEquals(size+1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func46InitTest() {
		myGame.currentPlayer.className = "Cultist";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func46Init();
		assertEquals(level+2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func46Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func46(true);
		assertEquals(size+2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func46Test2() {
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func46(false);
		assertEquals(level - 2, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func47Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func47(true);
		assertEquals(size+1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func48TestInit() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func48Init();
		assertEquals(cLevel-5, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func48Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func48(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func49InitTest() {
		myGame.funcs.func49Init();
		assertEquals("Monster Whacker", myGame.currentPlayer.className);
	}
	
	@Test
	public void func49Test() {
		//Need to test for class abilities
	}
	
	@Test
	public void func51InitTest() {
		myGame.currentPlayer.gender = 'M';
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func51Init();
		assertEquals(level - 3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func51Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func51(true);
		assertEquals(size + 4, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func51Test2() {
		//Need a discard method...
	}
	
	@Test
	public void func52InitTest() {
		myGame.currentPlayer.pLevel = 1;
		myGame.changePlayer();
		myGame.currentPlayer.pLevel = 2;
		myGame.changePlayer();
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func52Init();
		assertEquals(level - 4, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func52InitTest2() {
		myGame.changePlayer();
		myGame.currentPlayer.pLevel = 2; //P2
		myGame.changePlayer();
		myGame.currentPlayer.pLevel = 3; //P1
		myGame.changePlayer();
		int level = myGame.currentPlayer.cLevel; //P2
		myGame.funcs.func52Init();
		assertEquals(level - 4, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func52Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func52(true);
		assertEquals(size + 2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func54InitTest() {
		//Not sure what to do here...
	}
	
	@Test
	public void func54Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func54(true);
		assertEquals(size + 6, myGame.currentPlayer.treasuresWonEachTurn);
		assertEquals(level + 2, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func54Test2() {
		//If you lose, you die
		//Need to test for this
	}
	
	@Test
	public void func55InitTest() {
		myGame.currentPlayer.className = "Professor";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func55Init();
		assertEquals(level - 3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func55Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func55(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func55Test2() {
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func55(false);
		assertEquals(level - 1, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func57InitTest() {
		myGame.funcs.func57Init();
		assertEquals("Professor", myGame.currentPlayer.className);
	}
	
	@Test
	public void func59Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func59(true);
		assertEquals(size+1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func59Test2() {
		myGame.funcs.func59(false);
		assertEquals("Cultist", myGame.currentPlayer.className);
	}
	
	public void func60TestInit() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func60Init();
		assertEquals(cLevel-5, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func60Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func60(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func61InitTest() {
		myGame.currentPlayer.className = "Professor";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func61Init();
		assertEquals(level - 2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func61Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func61(true);
		assertEquals(size + 2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func61Test2() {
		//Need to test that the player died...
	}
	
	@Test
	public void func62InitTest() {
		myGame.currentPlayer.className = "Cultist";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func62Init();
		assertEquals(level - 3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func62Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func62(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func62Test2() {
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func62(false);
		assertEquals(level - 1, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func63InitTest() {
		myGame.currentPlayer.className = "Investigator";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func63Init();
		assertEquals(level + 2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func63Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func63(true);
		assertEquals(size + 4, myGame.currentPlayer.treasuresWonEachTurn);
		assertEquals(level + 2, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func63Test2() {
		myGame.funcs.func63(false);
		assertEquals("Cultist", myGame.currentPlayer.className);
	}
	
	@Test
	public void func64Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func64(true);
		assertEquals(level + 2, myGame.currentPlayer.pLevel);
		assertEquals(size + 4, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func64Test2() {
		//Need to discard footgear in play
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func64(false);
		assertEquals(level - 3, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func65InitTest() {
		myGame.currentPlayer.className = "Monster Whacker";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func65Init();
		assertEquals(level + 3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func65Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func65(true);
		assertEquals(size + 4, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func65Test2() {
		myGame.currentPlayer.pLevel = 3;
		int p1level = 3;
		myGame.changePlayer();
		myGame.currentPlayer.pLevel = 4;
		int p2level = 4;
		myGame.changePlayer();
		myGame.funcs.func65(false);
		assertEquals(p1level - 1, myGame.currentPlayer.pLevel);
		myGame.changePlayer();
		assertEquals(p2level, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func65Test3() {
		myGame.currentPlayer.pLevel = 4;
		int p1level = 4;
		myGame.changePlayer();
		myGame.currentPlayer.pLevel = 3;
		int p2level = 3;
		myGame.changePlayer();
		myGame.funcs.func65(false);
		assertEquals(p1level, myGame.currentPlayer.pLevel);
		myGame.changePlayer();
		assertEquals(p2level + 1, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func66TestInit() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func66Init();
		assertEquals(cLevel-5, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func66Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func66(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func67Test() {
		myGame.currentPlayer.className = "Cultist";
		myGame.funcs.func67();
		assertEquals("", myGame.currentPlayer.className);
	}
	
	@Test
	public void func67Test2() {
		myGame.currentPlayer.className = "Investigator";
		myGame.funcs.func67();
		assertEquals("Cultist", myGame.currentPlayer.className);
	}
	
	@Test
	public void func70Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func70(true);
		assertEquals(size + 2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func70Test2() {
		int size = myGame.currentPlayer.pHand.size();
		myGame.funcs.func70(false);
		assertEquals(size - 4, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func71InitTest() {
		myGame.currentPlayer.gender = 'F';
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func71Init();
		assertEquals(level - 2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func71Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func71(true);
		assertEquals(size + 3, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func72InitTest() {
		myGame.currentPlayer.className = "Monster Whacker";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func72Init();
		assertEquals(level - 6, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func72Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func72(true);
		assertEquals(size + 2, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func74Init() {
		myGame.currentPlayer.gender = 'M';
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func74Init();
		assertEquals(level + 2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func74Test() {
		int level = myGame.currentPlayer.pLevel;
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func74(true);
		assertEquals(level + 2, myGame.currentPlayer.pLevel);
		assertEquals(size + 4, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func74Test2() {
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func74(false);
		assertEquals(level - myGame.currentPlayer.pHand.size(), myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func76InitTest() {
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func76Init();
		assertEquals(level - 3, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func78InitTest() {
		myGame.currentPlayer.className = "Cultist";
		int level = myGame.currentPlayer.cLevel;
		myGame.funcs.func78Init();
		assertEquals(level + 2, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func78Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func78(true);
		assertEquals(size + 3, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func79InitTest() {
		//Test for pursuit level 4 or below
	}
	
	@Test
	public void func79Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		int level = myGame.currentPlayer.pLevel;
		myGame.funcs.func79(true);
		assertEquals(size + 5, myGame.currentPlayer.treasuresWonEachTurn);
		assertEquals(level + 2, myGame.currentPlayer.pLevel);
	}
	
	@Test
	public void func80TestInit() {
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func80Init();
		assertEquals(cLevel-5, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func80TestInit2() {
		myGame.currentPlayer.className = "Professor";
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func80Init();
		assertEquals(cLevel-10, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func80Test() {
		int size = myGame.currentPlayer.treasuresWonEachTurn;
		myGame.funcs.func80(true);
		assertEquals(size + 1, myGame.currentPlayer.treasuresWonEachTurn);
	}
	
	@Test
	public void func89Test() {
		int pLevel = myGame.currentPlayer.pLevel;
		myGame.funcs.func89();
		assertEquals(pLevel + 1, myGame.currentPlayer.pLevel);
	}
	
}