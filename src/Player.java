import java.util.ArrayList;


public class Player {
	public String username;
	public ArrayList<Integer> pHand = new ArrayList<Integer>();
	public boolean classAbility;
	public ArrayList<Integer> pPlay = new ArrayList<Integer>();
	public String className;
	public int pLevel=1;
	public int cLevel=pLevel;
	public InitializeCards initCards = new InitializeCards();
	
	
	public Player(String name){
		this.username=name;
		
	}
	
	public void cLevelCalculation(){
		Card card;
		for(int i=0; i<this.pHand.size();i++){
			
			if(pHand.get(i)<68){
				card = initCards.getDoorHash().get(pHand.get(i));
			
			}
			else{
				card = initCards.getTreasureHash().get(pHand.get(i));
				
			}
			
			this.cLevel+=card.pLevelBonus;
			
			
		}
	}
	
	

}
