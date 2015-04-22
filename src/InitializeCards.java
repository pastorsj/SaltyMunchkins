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
		
		numDoors = 67;
		numTreas=83;
		
		for(int i=0; i<numDoors; i++){
			Card newCard = new Card(i+1, cardInfo.get(i));
			doorHash.put(i+1, newCard);
			doors.add(i+1);
		}

		for(int i=numDoors;i<(numDoors+numTreas)-1; i++){
			
			if(i!=91){
				Card newCard = new Card(i+1, cardInfo.get(i));
				treasureHash.put(i+1, newCard);
				treasure.add(i+1);
			}
			else{
				
			}
		
		}
		this.addConditions();
	
		
	}
	
	public InitializeCards(){
		numDoors= 67;
		numTreas=83;
		
		for(int i=0; i<numDoors; i++){
			Card newCard = new Card(i+1, "");
			doorHash.put(i+1, newCard);
			doors.add(i+1);
		}

		for(int i=numDoors;i<(numDoors+numTreas)-1; i++){
			if(i!=91){
				Card newCard = new Card(i+1, "");
				treasureHash.put(i+1, newCard);
				treasure.add(i+1);
			}
			else{
				
			}
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
		doorHash.get(5).monsterLevel=6;
		doorHash.get(5).monsterLevelBonus=-2;
		doorHash.get(5).numTreas=2;
		doorHash.get(5).condForBonus="Professors";
		doorHash.get(7).monsterLevel=2;
		doorHash.get(7).monsterLevelBonus=4;
		doorHash.get(7).numTreas=1;
		doorHash.get(7).condForBonus="Females";
		doorHash.get(8).monsterLevel=8;
		doorHash.get(8).monsterLevelBonus=3;
		doorHash.get(8).numTreas=2;
		doorHash.get(26).monsterLevel=10;
		doorHash.get(26).numTreas=3;
		treasureHash.get(84).numGold=500;
		treasureHash.get(84).numHands=2;
		treasureHash.get(84).pLevelBonus=4;
		treasureHash.get(85).numGold=600;
		treasureHash.get(86).numGold=200;
		treasureHash.get(86).numHands=1;
		treasureHash.get(86).pLevelBonus=2;
		treasureHash.get(87).numGold=200;
		treasureHash.get(87).pLevelBonus=1;
		treasureHash.get(88).numGold = 300;
		treasureHash.get(88).numHands = 1;
		treasureHash.get(88).pLevelBonus = 2;
		treasureHash.get(89).goUpALevel = true;
		treasureHash.get(90).numGold = 100;
		treasureHash.get(90).numUse = 1;
		treasureHash.get(90).forMe = false;
		treasureHash.get(90).pLevelBonus = 3;
		treasureHash.get(90).monsterLevelBonus = 3;
	}

}
