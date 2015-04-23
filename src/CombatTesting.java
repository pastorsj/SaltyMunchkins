import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class CombatTesting {
	public Game myGame;
	public InitializeCards init = new InitializeCards();
	
	@Before
	public void setUp() {
	
		myGame=new Game(init.doors,init.treasure);
		myGame.p1.pLevel=1;
		ArrayList<Integer> hand = new ArrayList<Integer>();
		hand.add(84); //plb = 4
		hand.add(88); //plb =2 
		hand.add(87); //plb=1
		hand.add(86); // plb=2 
		myGame.p1.pPlay=hand; //note this is NOT pHand, this is the cards in PLAY
		myGame.p1.cLevelCalculation();
				

		
		
	
		
	}
	@Test
	public void TestCLevelCalc() {
		assertEquals(10,myGame.p1.cLevel);
		
	}
	
	@Test
	public void TestMLevelBonusCalc(){
		myGame.p1.pPlay.add(29); //+10 to monster
		myGame.p1.pPlay.add(42); //-5 to monster
		assertEquals(5,myGame.p1.mLevelBonusCalculation());
	}
	
	@Test
	public void TestDidIWin(){
		//p1 has player level bonus of 9
		myGame.p1.pPlay.add(42);
		assertEquals(true,myGame.p1.didIwin(myGame));
		
	}
	

	
}
