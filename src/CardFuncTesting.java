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
	public void func57init() {
		myGame.turnPlayer=1;
		myGame.funcs.func57();
		assertEquals("Professor",myGame.p1.className);
		myGame.turnPlayer=2;
		myGame.funcs.func57();
		assertEquals("Professor", myGame.p2.className);
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
	public void func7TestInit() {
		myGame.turnPlayer=1;
		myGame.funcs.func66Init();
	}
}
	

	
	
	

