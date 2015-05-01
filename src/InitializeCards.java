import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class InitializeCards {
	public HashMap<Integer, Card> cardHash = new HashMap<Integer, Card>();
	//public HashMap<Integer, Card> cardHash = new HashMap<Integer, Card>();
	public ArrayList<Integer> doors = new ArrayList<Integer>();
	public ArrayList<Integer> treasure = new ArrayList<Integer>();
	public int numDoors;
	public int numTreas;

	public InitializeCards(ArrayList<String> cardInfo) {

		// numDoors = 68;
		// numTreas = 0;

		//numDoors = 67;
		//numTreas = 83;

//		for (int i = 0; i < numDoors; i++) {
//			Card newCard = new Card(i + 1, cardInfo.get(i));
//			cardHash.put(i + 1, newCard);
//			doors.add(i + 1);
//		}
//
//		for (int i = numDoors; i < (numDoors + numTreas) - 1; i++) {
//
//			if (i != 91) {
//				Card newCard = new Card(i + 1, cardInfo.get(i));
//				cardHash.put(i + 1, newCard);
//				treasure.add(i + 1);
//			} else {
//
//			}
//
//		}
//		this.addConditions();

	}

	public InitializeCards() {
		numDoors = 67;
		numTreas = 83;

		for (int i = 0; i < numDoors; i++) {
			Card newCard = new Card(i + 1, "");
			cardHash.put(i + 1, newCard);
			doors.add(i + 1);
		}

		for (int i = numDoors; i < (numDoors + numTreas) - 1; i++) {
			if (i != 91) {
				Card newCard = new Card(i + 1, "");
				cardHash.put(i + 1, newCard);
				treasure.add(i + 1);
			} else {

			}
		}
		this.addConditionsForSelect();

	}
	
	public InitializeCards(boolean test) {
		numDoors = 67;
		numTreas = 83;

		for (int i = 0; i < numDoors; i++) {
			Card newCard = new Card(i + 1, "");
			cardHash.put(i + 1, newCard);
			doors.add(i + 1);
		}

		for (int i = numDoors; i < (numDoors + numTreas) - 1; i++) {
			if (i != 91) {
				Card newCard = new Card(i + 1, "");
				cardHash.put(i + 1, newCard);
				treasure.add(i + 1);
			} else {

			}
		}
		this.addConditions();
	}
	
	public InitializeCards(ArrayList<Integer> doorAvailable, ArrayList<Integer> treasAvailable){
		for (int i = 0; i < doorAvailable.size(); i++) {
			Card newCard = new Card(doorAvailable.get(i), "");
			cardHash.put(doorAvailable.get(i), newCard);
			doors.add(doorAvailable.get(i));
		}

		for (int i = 0; i < treasAvailable.size(); i++) {
			Card newCard = new Card(treasAvailable.get(i),"");
			cardHash.put(treasAvailable.get(i), newCard);
			treasure.add(treasAvailable.get(i));
		}
		this.addConditionsForSelect();
	}

	public void addConditions() {
		cardHash.get(1).monsterLevelBonus = 5;
		cardHash.get(2).monsterLevel = 2;
		cardHash.get(2).monsterLevelBonus = 3;
		cardHash.get(2).numTreas = 1;
		cardHash.get(2).condForBonus = "Monster Whacker";
		cardHash.get(3).monsterLevelBonus = 3;
		cardHash.get(4).numTreas = 1;
		cardHash.get(4).monsterLevel = 1;
		cardHash.get(5).monsterLevel = 6;
		cardHash.get(5).monsterLevelBonus = -2;
		cardHash.get(5).numTreas = 2;
		cardHash.get(5).condForBonus = "Professors";
		cardHash.get(7).monsterLevel = 2;
		cardHash.get(7).monsterLevelBonus = 4;
		cardHash.get(7).numTreas = 1;
		cardHash.get(7).condForBonus = "Females";
		cardHash.get(8).monsterLevel = 8;
		cardHash.get(8).monsterLevelBonus = 3;
		cardHash.get(8).numTreas = 2;
		cardHash.get(26).monsterLevel = 10;
		cardHash.get(26).numTreas = 3;
		cardHash.get(27).monsterLevel = 1;
		cardHash.get(27).monsterLevelBonus = 2;
		cardHash.get(27).numTreas = 1;
		cardHash.get(27).condForBonus = "Investigators";
		cardHash.get(27).badStuff = "gold";
		cardHash.get(27).badGold = -500;
		cardHash.get(28).monsterLevel = 6;
		cardHash.get(28).numTreas = 2;
		cardHash.get(29).monsterLevelBonus = 10;
		cardHash.get(29).bonusTreasure = 2;
		cardHash.get(30).monsterLevel = 12;
		cardHash.get(30).monsterLevelBonus = -2;
		cardHash.get(30).numTreas = 3;
		cardHash.get(30).condForBonus = "Monster Whacker";
		cardHash.get(31).monsterLevelBonus = 3;
		cardHash.get(32).monsterLevel = 12;
		cardHash.get(32).numTreas = 3;
		cardHash.get(33).monsterLevel = 4;
		cardHash.get(33).monsterLevelBonus = -2;
		cardHash.get(33).numTreas = 2;
		cardHash.get(33).condForBonus = "Females";
		cardHash.get(34).monsterLevelBonus = 3;
		cardHash.get(35).monsterLevel = 14;
		cardHash.get(35).monsterLevelBonus = -2;
		cardHash.get(35).numTreas = 4;
		cardHash.get(35).condForBonus = "Professors";
		cardHash.get(36).monsterLevel=2;
		cardHash.get(36).monsterLevelBonus=3;
		cardHash.get(36).numTreas=1;
		cardHash.get(36).condForBonus="Males";
		cardHash.get(36).badStuff="level";
		cardHash.get(36).badLevel=-1;
		cardHash.get(37).monsterLevel=12;
		cardHash.get(37).monsterLevelBonus=-2;
		cardHash.get(37).numTreas=3;
		cardHash.get(37).condForBonus="Females";
		cardHash.get(38).monsterLevel=24;
		cardHash.get(38).numTreas=5;
		cardHash.get(42).monsterLevelBonus = -5;
		cardHash.get(42).badStuff = "treas";
		cardHash.get(42).badTreas = -1;
		cardHash.get(43).monsterLevelBonus=10;
		cardHash.get(43).bonusTreasure=2;
		cardHash.get(45).monsterLevel=1;
		cardHash.get(45).numTreas=1;
		cardHash.get(46).monsterLevel=8;
		cardHash.get(46).numTreas=2;
		cardHash.get(46).badStuff="level";
		cardHash.get(46).badLevel=-2;
		cardHash.get(47).monsterLevel=4;
		cardHash.get(47).numTreas=2;
		cardHash.get(47).badStuff="level";
		cardHash.get(47).badLevel=-1;
		cardHash.get(47).selfOrOther=1;
		cardHash.get(48).monsterLevelBonus=5;
		cardHash.get(48).bonusTreasure=1;
		cardHash.get(51).monsterLevel=14;
		cardHash.get(51).numTreas=4;
		cardHash.get(51).monsterLevelBonus=3;
		cardHash.get(51).condForBonus="Males";
		cardHash.get(51).badStuff="items";
		cardHash.get(51).badItems=-3;
		cardHash.get(52).monsterLevel=8;
		cardHash.get(52).numTreas=2;
		cardHash.get(54).monsterLevel=18;
		cardHash.get(54).numTreas=5;
		cardHash.get(55).monsterLevel=2;
		cardHash.get(55).numTreas=1;
		cardHash.get(55).monsterLevelBonus=3;
		cardHash.get(55).condForBonus="Professors";
		cardHash.get(55).badStuff="level";
		cardHash.get(55).badItems=-1;
		cardHash.get(59).monsterLevel=2;
		cardHash.get(59).numTreas=1;
		cardHash.get(84).numGold = 500;
		cardHash.get(84).numHands = 2;
		cardHash.get(84).pLevelBonus = 4;
		cardHash.get(85).numGold = 600;
		cardHash.get(86).numGold = 200;
		cardHash.get(86).numHands = 1;
		cardHash.get(86).pLevelBonus = 2;
		cardHash.get(87).numGold = 200;
		cardHash.get(87).pLevelBonus = 1;
		cardHash.get(88).numGold = 300;
		cardHash.get(88).numHands = 1;
		cardHash.get(88).pLevelBonus = 2;
		cardHash.get(89).goUpALevel = true;
		cardHash.get(90).numGold = 100;
		cardHash.get(90).numUse = 1;
		cardHash.get(90).forMe = false;
		cardHash.get(90).pLevelBonus = 3;
		cardHash.get(90).monsterLevelBonus = 3;
		cardHash.get(94).goUpALevel = true;
		cardHash.get(97).numGold = 700;
		cardHash.get(97).pLevelBonus = 3;
		cardHash.get(97).NotUsableBy = "Monster Whacker";
		cardHash.get(98).numGold=800;
		cardHash.get(98).pLevelBonus=4;
		cardHash.get(98).numHands=2;
		cardHash.get(99).numGold=300;
		cardHash.get(99).pLevelBonus=1;
		cardHash.get(99).footGear=true;
	}
	
	public void addConditionsForSelect() {
		
		cardHash.get(2).monsterLevel = 2;
		cardHash.get(2).monsterLevelCondBonus = 3;
		cardHash.get(2).numTreas = 1;
		cardHash.get(2).condForBonus = "Monster Whacker";
		
		cardHash.get(4).numTreas = 1;
		cardHash.get(4).monsterLevel = 1;
	
		cardHash.get(7).monsterLevel = 2;
		cardHash.get(7).monsterLevelCondBonus = 4;
		cardHash.get(7).numTreas = 1;
		cardHash.get(7).condForBonus = "Females";
		
		
		cardHash.get(29).monsterLevelBonus = 10;
		cardHash.get(29).bonusTreasure = 2;

		
		cardHash.get(42).monsterLevelBonus = -5;
		cardHash.get(42).badStuff = "treas";
		cardHash.get(42).badTreas = -1;
		cardHash.get(84).numGold = 500;
		cardHash.get(84).numHands = 2;
		cardHash.get(84).pLevelBonus = 4;
		cardHash.get(85).numGold = 600;
		cardHash.get(86).numGold = 200;
		cardHash.get(86).numHands = 1;
		cardHash.get(86).pLevelBonus = 2;
		cardHash.get(87).numGold = 200;
		cardHash.get(87).pLevelBonus = 1;
		cardHash.get(88).numGold = 300;
		cardHash.get(88).numHands = 1;
		cardHash.get(88).pLevelBonus = 2;
		cardHash.get(89).goUpALevel = true;
		cardHash.get(90).numGold = 100;
		cardHash.get(90).numUse = 1;
		cardHash.get(90).forMe = false;
		cardHash.get(90).pLevelBonus = 3;
		cardHash.get(90).monsterLevelBonus = 3;
		cardHash.get(94).goUpALevel = true;
		cardHash.get(97).numGold = 700;
		cardHash.get(97).pLevelBonus = 3;
		cardHash.get(97).NotUsableBy = "Monster Whacker";
		cardHash.get(98).numGold=800;
		cardHash.get(98).pLevelBonus=4;
		cardHash.get(98).numHands=2;
		cardHash.get(99).numGold=300;
		cardHash.get(99).pLevelBonus=1;
		cardHash.get(99).footGear=true;
	}

	public HashMap<Integer, Card> getCardHash() {
		return cardHash;
	}


}
