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
	public int handLevel = 0; //number of hand cards in play
	public int headLevel = 0;
	public int armorLevel = 0;
	public int footLevel = 0;
	public int goldSold=0;
	public int winStatus=0; //1 win, 0 game in play, -1 lose
	public boolean monster=false;
	public int dice=0;
	public boolean drewCard = false;
	public boolean sentCurse = false;
	
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
			int roll = game.rollDice(0);
			if(game.currentPlayer.pPlay.contains(96)){
				roll++;
			}
			System.out.println("You rolled a " + roll);
			if (roll>4) {
				System.out.println("You ran away!");
				game.mframe.mainPanel.bCardPanel.diceLevel.setText("num rolled is: "+roll);
				game.mframe.mainPanel.bCardPanel.diceLevel.setVisible(true);
				game.currentPlayer.consequence(game, 0);
			} else {
				System.out.println("You lose...");
				game.mframe.mainPanel.bCardPanel.diceLevel.setText("num rolled is: "+roll);
				game.mframe.mainPanel.bCardPanel.diceLevel.setVisible(true);
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
		System.out.println("my clevel is: " + game.currentPlayer.cLevel);
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
			//game.currentPlayer.treasuresWonEachTurn=0; //need this because card func 29 
			bool=false;}
		
			CardFunc cf = new CardFunc(game);
			System.out.println("current Player pPlay: "+game.currentPlayer.pPlay);
			for (int i = 0; i<game.currentPlayer.pPlay.size();i++){
				int methodNum=game.currentPlayer.pPlay.get(i);
				
				String funcToCall = "func"+methodNum;
				System.out.println("func we are calling: "+funcToCall);
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
			}
			System.out.println("Getting # treas cards before end combat "+game.currentPlayer.treasuresWonEachTurn);
			game.currentPlayer.endCombat(game);
			game.otherPlayer.endCombat(game);
			System.out.println("Getting # treas cards from win: "+game.currentPlayer.treasuresWonEachTurn);
			cf.getTreasFromWin();
			game.currentPlayer.treasuresWonEachTurn = 0;
		
	}
	

public void endCombat(Game myGame){
		System.out.println("END COMBAT IS CALLED");
		for(int i =0; i<this.pPlay.size();i++){
		
			if(myGame.ic.getCardHash().get(this.pPlay.get(i)).discard){
				System.out.println("delete pPlay in endCombat");
				if(this.pPlay.get(i)<83){
					myGame.doorDiscards.add(this.pPlay.get(i));
				}
				else{
					myGame.treasDiscards.add(this.pPlay.get(i));
				}
				
				this.pPlay.remove(i);
				
				i--;
			}
			else if(myGame.ic.getCardHash().get(this.pPlay.get(i)).armor ||
					myGame.ic.getCardHash().get(this.pPlay.get(i)).footGear ||
					myGame.ic.getCardHash().get(this.pPlay.get(i)).headGear ||
					myGame.ic.getCardHash().get(this.pPlay.get(i)).numHands>0){
			
			}
			else{
				System.out.println("moving card to pHand in endCombat");
				this.pHand.add(this.pPlay.get(i));
				this.pPlay.remove(i);
			}
		
		}
		this.handLevel = 0;
		this.headLevel=0;
		this.armorLevel=0;
		myGame.mLevel = 0;
		myGame.mframe.mainPanel.bCardPanel.dgb.goldToDiscard = 0;
		
		
		
		}
}
