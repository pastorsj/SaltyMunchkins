import java.util.ArrayList;


public class Player {
	public String username;
	public ArrayList<Integer> pHand = new ArrayList<Integer>();
	public boolean classAbility;
	public ArrayList<Integer> pPlay = new ArrayList<Integer>();
	public String className;
	public int pLevel=1; //actual level of player
	public int cLevel=pLevel; //the level a player is with door cards in combat
	public InitializeCards initCards = new InitializeCards();
	
	
	public Player(String name){
		this.username=name;
		
	}
	
	public void cLevelCalculation(){
		Card card;
		this.cLevel=this.pLevel;
		for(int i=0; i<this.pPlay.size();i++){
			
			if(pPlay.get(i)<68){
				card = initCards.getCardHash().get(pPlay.get(i));
			
			}
			else{
				card = initCards.getCardHash().get(pPlay.get(i));
				
			}
			
			this.cLevel+=card.pLevelBonus;
			
			
		}
		
		
	}
	
	public int mLevelBonusCalculation(){
		int mLevelBonus=0;
		InitializeCards init = new InitializeCards();
		for(int i = 0; i<this.pPlay.size();i++){
			mLevelBonus+=init.cardHash.get(this.pPlay.get(i)).monsterLevelBonus;
		}
		return mLevelBonus;
	}
	
	public boolean didIwin(Game game){
		int playerInt = game.turnPlayer;
		if(playerInt==1){
			return didIwinHelper(game.p1, game.p2);
		}
		else{
			return didIwinHelper(game.p2,game.p1);
		}
		
		
	}
	
	public boolean didIwinHelper(Player me, Player other){
		return true;
	}
	
	
	

}
