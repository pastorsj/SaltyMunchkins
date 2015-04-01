import java.util.ArrayList;
import java.util.Random;

public class Game {
	ArrayList<Integer> doors;
	ArrayList<Integer> treasures;

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


}
