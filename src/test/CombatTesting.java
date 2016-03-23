package test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.InitializeCards;
import game.MFrame;
import gamebuttons.DidIWinButton;


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
		myGame.mframe = new MFrame(myGame);
		myGame.mframe.setVisible(false);
		
				

		
		
	
		
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
		myGame.mLevel= 15;
		//p1 has player level bonus of 9
		myGame.p1.pPlay.add(42); //subtract 5 from monster.
		System.out.println("should be -5: " + init.cardHash.get(42).monsterLevelBonus);
		assertEquals(true, myGame.p1.didIwin(myGame));
		myGame.p2.pPlay.add(29); 
		myGame.p2.pPlay.add(29);
		assertEquals(false, myGame.p2.didIwin(myGame));
	}
	
	@Test
	public void TestGetTreasureForWinCard2() throws IOException{
		ArrayList<Integer> hand = new ArrayList<Integer>();
		ArrayList<Integer> handInPlay = new ArrayList<Integer>();
		ArrayList<Integer> hand2 = new ArrayList<Integer>();
		DidIWinButton diwb1 = new DidIWinButton(myGame);
		handInPlay.add(2);
		handInPlay.add(88);
		myGame.p1.pHand=hand;
		myGame.p1.pPlay=handInPlay;
		myGame.p2.pPlay=hand2;
		
		diwb1.didIWin();
		
		assertEquals(1,myGame.p1.pHand.size());
		assertEquals(0,myGame.p1.pPlay.size());
		
		//test that player level is set to 2
		assertEquals(2,myGame.p1.pLevel);

	}
	
	@Test
	public void TestCanBeat2AfterBeat1NoArmor(){
		ArrayList<Integer> hand = new ArrayList<Integer>();
		ArrayList<Integer> handInPlay = new ArrayList<Integer>();
		ArrayList<Integer> hand2 = new ArrayList<Integer>();
		DidIWinButton diwb1 = new DidIWinButton(myGame);
		handInPlay.add(27); //level 1 monster
		myGame.p1.pHand=hand;
		myGame.p1.pPlay=handInPlay;
		myGame.p2.pPlay=hand2;
	
		diwb1.didIWin();
			assertEquals(2,myGame.p1.pLevel);
		
		
		myGame.p1.pPlay.add(2); //level 2 monster
		myGame.updateMLevel(2);
		assertEquals(2,myGame.mLevel);
		diwb1.didIWin();
		assertEquals(3,myGame.p1.pLevel);	
		
	}
	
	@Test
	public void TestCanBeat2AfterBeat1NoArmorNewWay(){
		ArrayList<Integer> hand = new ArrayList<Integer>();
		ArrayList<Integer> handInPlay = new ArrayList<Integer>();
		ArrayList<Integer> hand2 = new ArrayList<Integer>();
		DidIWinButton diwb1 = new DidIWinButton(myGame);
		handInPlay.add(27); //level 1 monster
		myGame.playACard(27);
		myGame.p1.pHand=hand;
		myGame.p1.pPlay=handInPlay;
		myGame.p2.pPlay=hand2;
	
		diwb1.didIWin();
			assertEquals(2,myGame.p1.pLevel);
		
		
		myGame.p1.pPlay.add(2); //level 2 monster
		myGame.playACard(2);
		diwb1.didIWin();
		assertEquals(3,myGame.p1.pLevel);	
		
	}
	

	
}
