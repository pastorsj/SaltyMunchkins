import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;


public class Main {
	
	public static void main(String[] args) throws IOException {

		//ReadFile file1 = new ReadFile(
				//"FILE WITH DATA HERE");
		//String[] arrayOfLines = file1.OpenFile();

		
		MFrame newFrame = new MFrame();
		newFrame.setVisible(true);
		newFrame.setTitle("Munchkin");
		
		//These next methods will initialize the card list and shuffle the list of cards
		//There are 168 cards, 100 door cards and 68 treasure cards
		ArrayList<Integer> doorCards = new ArrayList<Integer>(100);
		ArrayList<Integer> treasureCards = new ArrayList<Integer>(68);
	}
	
	public ArrayList<Card> shuffle(ArrayList<Card> cards) {
		return null;
	}
}