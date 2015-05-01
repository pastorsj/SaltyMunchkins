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
		myGame.turnPlayer=1;
		int cLevel = myGame.p1.cLevel;
		myGame.funcs.func1Init();
		assertEquals(cLevel-5, myGame.p1.cLevel);
	}
}
	

	
	
	

