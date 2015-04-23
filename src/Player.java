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
		this.cLevel=this.pLevel;
		for(int i=0; i<this.pPlay.size();i++){
			
			if(pPlay.get(i)<68){
				card = initCards.getDoorHash().get(pPlay.get(i));
			
			}
			else{
				card = initCards.getTreasureHash().get(pPlay.get(i));
				
			}
			
			this.cLevel+=card.pLevelBonus;
			
			
		}
		
		
	}
	
	public int mLevelBonusCalculation(){
		return 0;
	}
	
	

}
