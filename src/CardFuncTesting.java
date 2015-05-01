import static org.junit.Assert.*;

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
	public void func1Test() {
		myGame.funcs.func1(true);
		assertEquals(1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func2TestInit() {
		myGame.currentPlayer.className = "Monster Whacker";
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func2Init();
		assertEquals(cLevel-3, myGame.currentPlayer.cLevel);
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
	public void func7TestInit() {
		myGame.currentPlayer.gender = 'F';
		int cLevel = myGame.currentPlayer.cLevel;
		myGame.funcs.func7Init();
		assertEquals(cLevel+4, myGame.currentPlayer.cLevel);
	}
	
	@Test
	public void func7Test() {
		myGame.funcs.func7(true);
		assertEquals(1, myGame.currentPlayer.pHand.size());
	}
	
	@Test
	public void func7Test2() {
		myGame.dealNewCard(myGame.treasures, myGame.currentPlayer);
		myGame.funcs.func7(false);
		assertEquals(0, myGame.currentPlayer.pHand.size());
	}
	
}
	

	
	
	

