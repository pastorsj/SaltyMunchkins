
public class CardFunc {
	public Game myGame;
	public Player p;
	public CardFunc(Game game){
		this.myGame=game;
		if (myGame.turnPlayer==1){
			p=myGame.p1;
		}
		else{
			p=myGame.p2;
		}
		
	}
	
	public void func1Init() {
		myGame.currentPlayer.cLevel -= 5;
	}
	
	public void func1(boolean checkWin) {
		//+5 to Monster
		//If win, draw extra treasure
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, myGame.currentPlayer);
		}
	}
	
	public void func2Init() {
		
	}
	
	public void end(){
		if(myGame.turnPlayer==1){
			myGame.p1=p;
		}
		else{
			myGame.p2=p;
		}
	}
	
	
}
