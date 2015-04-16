import java.util.HashMap;

public class Card {
	public int num;
	public String name;
	public int addNum;
	public int monsterLevel;
	public String badStuff;
	public int numTreas;
	public int monsterLevelBonus;
	public String condForBonus;
	public boolean inPlay;
	public int numGold;
	public int numHands;
	public int pLevelBonus;
	
	
	
	public Card(int num, String name) {
		this.num = num;
		this.name = name;
		
		
			
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getNumber(){
		return this.num;
	}

}
