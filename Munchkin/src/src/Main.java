package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;


public class Main {
	
	public static void main(String[] args) throws IOException {

		initMain();
		
		
	}
	
	public static void initMain() throws IOException{
		
		ReadFile file1 = new ReadFile(
				"resources/CardList.txt");
		ArrayList<String> arrayOfLines = file1.OpenFile();
		ArrayList<Integer> doorAv = new ArrayList<Integer>();
		ArrayList<Integer> treasAv = new ArrayList<Integer>();
	
		doorAv.add(1);
		doorAv.add(2);
		doorAv.add(3);
		doorAv.add(4); //not sure if this is for cards in play or for cards in hand?? assume hand
		doorAv.add(5);
		//6
		doorAv.add(7); //give away item of choice
		doorAv.add(8);
		//9
		doorAv.add(10);
		//11
		//12
	//	doorAv.add(13);
		//14
	//	doorAv.add(15);
		//16
	//	doorAv.add(17);
		//18
		//19
	//	doorAv.add(20);
		//21
		//22
		doorAv.add(23);
		doorAv.add(27); //level1 monster
		doorAv.add(29);
		
		doorAv.add(30);
		doorAv.add(42);
		
		treasAv.add(84);
		//treasAv.add(85);
		treasAv.add(86);
		treasAv.add(87);
		treasAv.add(88);
		treasAv.add(89);
		treasAv.add(90);
		treasAv.add(94);
		treasAv.add(96);
		treasAv.add(97);
		treasAv.add(98);
		treasAv.add(99);
		treasAv.add(100);
		treasAv.add(102);
		treasAv.add(104);
		treasAv.add(106);
		treasAv.add(107);
		treasAv.add(111);
		treasAv.add(112);
		treasAv.add(114);
		treasAv.add(115);
		treasAv.add(116);
		treasAv.add(117);
		treasAv.add(120);
		treasAv.add(126);
		treasAv.add(129);
		treasAv.add(132);
		treasAv.add(137);
		treasAv.add(138);
		treasAv.add(139);
		treasAv.add(140);
		treasAv.add(146);
		treasAv.add(148);
		
		
//		//double the treasures
	
		

//		
		InitializeCards ic = new InitializeCards(doorAv,treasAv);
		
		Game newGame = new Game(ic.doors,ic.treasure);
		
		newGame.shuffle(newGame.doors);
		newGame.shuffle(newGame.treasures);
		
		ArrayList<Integer> hand = newGame.dealCards();
		ArrayList<Card> deal;
		newGame.p1.pHand=hand;
		
		newGame.p2.pHand=newGame.dealCards();
		newGame.mframe = new MFrame(newGame);
		newGame.mframe.setVisible(true);
		newGame.mframe.setTitle("Munchkin");
//	newGame.mframe.mainPanel.addBCard();
	//	newGame.mframe.mainPanel.bCardPanel.etb.disable();
		newGame.mframe.revalidate();
		newGame.mframe.repaint();
		
		
	}
	

}