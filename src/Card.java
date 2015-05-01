import java.util.HashMap;

public class Card {
	public String NotUsableBy = "";
	public int num;
	public String name;
	public int addNum;
	public int monsterLevel=0; //is 0 if not a monster
	public String badStuff=""; //gold or treas or level or items
	public int badGold;
	public int badTreas;
	public int badLevel;
	public int badItems;
	public int numTreas;
	public int monsterLevelBonus = 0; //always execute
	public int monsterLevelCondBonus; //only execute if certain condition is met
	public String condForBonus;
	public boolean inPlay;
	public int numGold;
	public int numHands;
	public boolean footGear;
	public boolean headGear;
	public int pLevelBonus=0;
	public boolean goUpALevel;
	public boolean forMe;
	public int numUse;
	public int bonusTreasure=0;
	boolean readyToPlay=false; //means card is implemented enough to be in demo.
	public int selfOrOther; //1 for other
	
	
	
	
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
