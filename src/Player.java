import java.util.ArrayList;


public class Player {
	public String username;
	public ArrayList<Integer> pHand = new ArrayList<Integer>();
	public boolean classAbility;
	public ArrayList<Integer> pPlay = new ArrayList<Integer>();
	public String className;
	public char gender = 'F';
	public int pLevel=1; //actual level of player
	public int cLevel=pLevel; //the level a player is with door cards in combat
	public InitializeCards initCards = new InitializeCards();
	
	public Player(String name){
		this.username = name;
		
	}
	
	public void cLevelCalculation(){
		Card card;
		this.cLevel=this.pLevel;
		for(int i=0; i<this.pPlay.size();i++){
			card = initCards.getCardHash().get(pPlay.get(i));	
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
			return didIwinHelper(game.p1, game.p2,game);
		}
		else{
			return didIwinHelper(game.p2,game.p1, game);
		}
	}
	
	public boolean didIwinHelper(Player me, Player other, Game game){
		int monster = game.mLevel + me.mLevelBonusCalculation()+other.mLevelBonusCalculation();
		System.out.println("Other person's monster bonus level " + other.mLevelBonusCalculation());
		System.out.println("monster level in combat is: " + monster);
		me.cLevelCalculation(); //me.cLevel is now set
		System.out.println("my clevel is: " + me.cLevel);
		return (me.cLevel>=monster);
	}
	
	public void consequence(Game game, int win) {
		System.out.println("Consequence is " + win);
		game.dealNewCard(game.treasures, this);
	}
}
