import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class Player {
	public String username;
	public ArrayList<Integer> pHand = new ArrayList<Integer>();
	public boolean classAbility;
	public ArrayList<Integer> pPlay = new ArrayList<Integer>();
	public ArrayList<Integer> pDiscard = new ArrayList<Integer>();
	public String className = "";
	public char gender = 'F';
	public int pLevel=1; //actual level of player
	public int cLevel=pLevel; //the level a player is with door cards in combat
	public int treasuresWonEachTurn = 0;
	public InitializeCards initCards = new InitializeCards();
	public int hLevel = 0; //number of hands in play (max is 2)
	public int headLevel = 0; //amount of headgear in play (max is 1)
	public int armorLevel = 0; //amount of armor in play (max is 1)
	public int footLevel = 0; //amount of footgear in play (max is 1)
	
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
		
			boolean bool = didIwinHelper(game);
			
			System.out.println("bool for win is: "+bool);
			//return bool;
		
		
		if(bool){
			game.currentPlayer.consequence(game, 1);
		}
		
		else{
			int roll = game.rollDice(2);
			System.out.println("You rolled a " + roll);
			if (roll>4) {
				System.out.println("You ran away!");
				game.currentPlayer.consequence(game, 0);
			} else {
				System.out.println("You lose...");
				game.currentPlayer.consequence(game, -1);
			}
		}
		
		return bool;
	}
	
	public boolean didIwinHelper(Game game){
		//int monster = game.mLevel + game.currentPlayer.mLevelBonusCalculation()+game.otherPlayer.mLevelBonusCalculation();
		int monster = game.mLevel;
		System.out.println("monster level is: "+monster);
		//System.out.println("Other person's monster bonus level " + game.otherPlayer.mLevelBonusCalculation());
		//System.out.println("my monster level bonus calc is: "+game.currentPlayer.mLevelBonusCalculation());
		//System.out.println("monster level in combat is: " + monster);
		//game.currentPlayer.cLevelCalculation(); //me.cLevel is now set using hash
		System.out.println("my clevel is: " + game.currentPlayer.cLevel+game.currentPlayer.pLevel);
		return (game.currentPlayer.cLevel>=monster);
	}
	
	public void consequence(Game game, int win) {
		System.out.println("Consequence is " + win);
		boolean bool;
		if(win==1){
			//game.dealNewCard(game.treasures, this);
			game.currentPlayer.pLevel++;
			bool=true;}
		else{
			game.currentPlayer.treasuresWonEachTurn=0; //need this because card func 29 
			bool=false;}
		
			CardFunc cf = new CardFunc(game);
			for (int i = 0; i<game.currentPlayer.pPlay.size();i++){
				int methodNum=game.currentPlayer.pPlay.get(i);
				
				String funcToCall = "func"+methodNum;
				try {
					Method method =CardFunc.class.getMethod(funcToCall,boolean.class);
					try {
						method.invoke(cf, bool);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		
			
		
			
			//if(game.turnPlayer==1){
				//game.p1.pLevel++;
			//}
			//else{
				//game.p2.pLevel++;
			//}
			
				
			game.currentPlayer.endCombat(game);
			game.otherPlayer.endCombat(game);
			cf.getTreasFromWin();
			game.currentPlayer.treasuresWonEachTurn = 0;
		}
	}
	
public void discard500Gold(Game myGame){
	
}
public void endCombat(Game myGame){
		System.out.println("END COMBAT IS CALLED");
		for(int i =0; i<this.pPlay.size();i++){
		
			if(myGame.ic.getCardHash().get(this.pPlay.get(i)).discard){
				System.out.println("delete pPlay in endCombat");
				this.pPlay.remove(i);
				i--;
			}
			else{
				System.out.println("moving card to pHand in endCombat");
				this.pHand.add(this.pPlay.get(i));
				this.pPlay.remove(i);
			}
		
		}
		this.hLevel = 0;
		
		
		}
}
