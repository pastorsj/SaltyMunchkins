import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game {
	ArrayList<Integer> doors;
	ArrayList<Integer> treasures;
	Player p1 = new Player("p1");
	Player p2 = new Player("p2");


	public Game(ArrayList<Integer> doors, ArrayList<Integer> treasures) {
 		this.doors = doors;
		this.treasures = treasures;
		
	}
	

	public ArrayList<Integer> shuffle(ArrayList<Integer> cards) {
		Random rand = new Random();
		for (int i = cards.size() - 1; i > 0; i--) {
			int randNum = rand.nextInt(i);
			int temp = cards.get(randNum);
			cards.set(randNum, cards.get(i));
			cards.set(i, temp);
		}
		return cards;
	}
	
	public void setInitialCards(){
		p1.pHand=this.dealCards();
		p2.pHand=this.dealCards();
	}

	
	public ArrayList<Integer> dealCards() {
		ArrayList<Integer> deal = new ArrayList<Integer>();
		shuffle(doors);
		shuffle(treasures);
		for (int i = 0; i <= 3; i++) {
			deal.add(doors.get(doors.size() - 1));
			deal.add(treasures.get(treasures.size()-1));
			doors.remove(doors.get(doors.size() - 1));
			treasures.remove(treasures.get(treasures.size()-1));
			
		}
		return deal;
	}
	//This function will not deal another card if the player hand size equals 8
	public boolean dealNewCard(ArrayList<Integer> cards, Player p) {
		int size = cards.size()-1;
		if(p.pHand.size() < 8) {
			p.pHand.add(cards.get(size));
			cards.remove(size);
			return true;
		} return false;
	}

}
