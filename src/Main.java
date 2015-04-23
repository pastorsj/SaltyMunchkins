import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;


public class Main {
	
	public static void main(String[] args) throws IOException {

		ReadFile file1 = new ReadFile(
				"src\\CardList.txt");
		//String[] arrayOfLines = file1.OpenFile();
		ArrayList<String> arrayOfLines = file1.OpenFile();
		
		
		
		
		//These next methods will initialize the card list and shuffle the list of cards
		//There are 168 cards, 100 door cards and 68 treasure cards
	//	ArrayList<Integer> doorCards = new ArrayList<Integer>(4);
		//ArrayList<Integer> treasureCards = new ArrayList<Integer>(4);
		

	//	InitializeCards ic = new InitializeCards(arrayOfLines); use when all implemented
		
		InitializeCards ic = new InitializeCards();
		ArrayList<Integer> doorAv = new ArrayList<Integer>();
		ArrayList<Integer> treasAv = new ArrayList<Integer>();
		
		Game newGame = new Game(ic.doors,ic.treasure);
		newGame.shuffle(newGame.doors);
		newGame.shuffle(newGame.treasures);
		
		ArrayList<Integer> hand = newGame.dealCards();
		ArrayList<Card> deal;
		newGame.p1.pHand=hand;
		
		newGame.p2.pHand=newGame.dealCards();
		MFrame newFrame = new MFrame(newGame,arrayOfLines);
		newFrame.setVisible(true);
		newFrame.setTitle("Munchkin");
		
		
		
	}
	

}