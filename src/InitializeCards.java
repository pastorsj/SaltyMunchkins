import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;


public class InitializeCards {
	public HashMap<Integer,Card> doorHash = new HashMap<Integer,Card>();
	public HashMap<Integer, Card> treasureHash=new HashMap<Integer,Card>();
	public ArrayList<Integer> doors= new ArrayList<Integer>();
	public ArrayList<Integer> treasure=new ArrayList<Integer>();
	public int numDoors;
	public int numTreas;
	
	public InitializeCards(ArrayList<String> cardInfo){
		
		//numDoors = 68;
		//numTreas = 0;
		
		numDoors = 82;
		numTreas=67;
		
		for(int i=0; i<numDoors; i++){
			Card newCard = new Card(i+1, cardInfo.get(i));
			doorHash.put(i+1, newCard);
			doors.add(i+1);
		}

		for(int i=numDoors;i<(numDoors+numTreas)-1; i++){
			Card newCard = new Card(i+1, cardInfo.get(i));
			treasureHash.put(i+1, newCard);
			treasure.add(i+1);
		}
		this.addConditions();
	
		
	}
	
	public InitializeCards(){
		numDoors=82;
		numTreas=67;
		
		for(int i=0; i<numDoors; i++){
			Card newCard = new Card(i+1, "");
			doorHash.put(i+1, newCard);
			doors.add(i+1);
		}

		for(int i=numDoors;i<(numDoors+numTreas)-1; i++){
			Card newCard = new Card(i+1, "");
			treasureHash.put(i+1, newCard);
			treasure.add(i+1);
		}
		this.addConditions();
		
		
	}
	
	public void addConditions(){
		doorHash.get(1).addNum=5;
		doorHash.get(2).monsterLevel=2;
		doorHash.get(2).monsterLevelBonus=3;
		doorHash.get(2).numTreas=1;
		doorHash.get(2).condForBonus="Monster Whacker";
		doorHash.get(3).addNum=3;
		doorHash.get(4).numTreas=1;
		doorHash.get(4).monsterLevel = 1;
	}

}
