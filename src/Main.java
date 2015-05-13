import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;


public class Main {
	
	public static void main(String[] args) throws IOException {

		initMain();
		
		
		
		
		//These next methods will initialize the card list and shuffle the list of cards
		//There are 168 cards, 100 door cards and 68 treasure cards
	//	ArrayList<Integer> doorCards = new ArrayList<Integer>(4);
		//ArrayList<Integer> treasureCards = new ArrayList<Integer>(4);
		

	//	InitializeCards ic = new InitializeCards(arrayOfLines); use when all implemented
		
		//InitializeCards ic = new InitializeCards();
		
		
	}
	
	public static void initMain() throws IOException{
		
		ReadFile file1 = new ReadFile(
				"src\\CardList.txt");
		//String[] arrayOfLines = file1.OpenFile();
		ArrayList<String> arrayOfLines = file1.OpenFile();
		ArrayList<Integer> doorAv = new ArrayList<Integer>();
		ArrayList<Integer> treasAv = new ArrayList<Integer>();
		doorAv.add(27); //level1 monster
		doorAv.add(2);
		doorAv.add(7); //give away item of choice
		doorAv.add(42);
		doorAv.add(29);
		doorAv.add(4); //not sure if this is for cards in play or for cards in hand?? assume hand
		
		//add these doors just to have 8 cards
		doorAv.add(27);
		doorAv.add(2);
		doorAv.add(7);
		doorAv.add(42);
		doorAv.add(4);
		
		doorAv.add(1);
		doorAv.add(3);
		doorAv.add(5);
	
		doorAv.add(8);
		doorAv.add(10);
		doorAv.add(13);
		doorAv.add(15);
		doorAv.add(17);
		doorAv.add(20);
		
		treasAv.add(84);
		//treasAv.add(85);
		treasAv.add(86);
		treasAv.add(87);
		treasAv.add(88);
		treasAv.add(89);
		treasAv.add(90);
		treasAv.add(94);
		treasAv.add(97);
		treasAv.add(98);
		treasAv.add(99);
		
		//double the treasures
		treasAv.add(84);
		//treasAv.add(85);
		treasAv.add(86);
		treasAv.add(87);
		treasAv.add(88);
		treasAv.add(89);
		treasAv.add(90);
		treasAv.add(94);
		treasAv.add(97);
		treasAv.add(98);
		treasAv.add(99);
		
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
		newGame.mframe.mainPanel.bCardPanel.etb.disable();
		newGame.mframe.revalidate();
		newGame.mframe.repaint();
		
		
	}
	

}