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
		ArrayList<Integer> hand = myGame.currentPlayer.pHand;
		myGame.funcs.func1(true);
		assertEquals(2, myGame.currentPlayer.pHand.size());
	}
}
	

	
	
	

