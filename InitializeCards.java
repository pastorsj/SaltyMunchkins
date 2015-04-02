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
		
		numDoors = 68;
		numTreas=83;
		
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
	
		
	}

}
