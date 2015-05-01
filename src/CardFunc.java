import java.io.IOException;


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
	
	public void func1(boolean checkWin) throws IOException {
		//+5 to Monster
		//If win, draw extra treasure
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		}
	}
	
	public void func2Init() {
		if(myGame.currentPlayer.className.equals("Monster Whacker")) {
			myGame.currentPlayer.cLevel -= 3;
		}
	}
	
	public void func2(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		}else {
			if(!myGame.currentPlayer.className.equals("Cultist")) {
				myGame.currentPlayer.className = "";				
				//Need to discard any class card in play
			}
		}
	}
	
	public void func7Init() {
		if(myGame.currentPlayer.gender == 'F') {
			myGame.currentPlayer.cLevel += 4;
		}
	}
	
	public void func7(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		} else {
			//Discard a card in your hand
			myGame.discardCard(myGame.currentPlayer, myGame.currentPlayer.pHand.get(0));
		}
	}
	
	public void func8Init() {
		if(myGame.currentPlayer.pHand.size()%2 == 0) {
			myGame.currentPlayer.cLevel -= 3;
		}
	}
	
	public void func8(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		} else {
			myGame.currentPlayer.pLevel -= 2;
			if(myGame.currentPlayer.pLevel<1) {
				myGame.currentPlayer.pLevel = 1;
			}
		}
	}
	
	public void func12Init() {
		myGame.currentPlayer.className = "Cultist";
	}
	
	public void func13() {
		if(!myGame.currentPlayer.className.equals("")) {
			if(myGame.currentPlayer.className.equals("Monster Whacker")) {
				//Discard card 49
				myGame.discardCard(myGame.currentPlayer, 49);
				myGame.currentPlayer.className = "";
			} else if(myGame.currentPlayer.className.equals("Professor")) {
				//Discard card 57
				myGame.discardCard(myGame.currentPlayer, 57);
				myGame.currentPlayer.className = "";
			} else if(myGame.currentPlayer.className.equals("Investigator")) {
				//Discard card 44
				myGame.discardCard(myGame.currentPlayer, 44);
				myGame.currentPlayer.className = "";
			} else if(myGame.currentPlayer.className.equals("Cultist")) {
				//Discard card 12
				myGame.discardCard(myGame.currentPlayer, 12);
				myGame.currentPlayer.className = "";
			}
		} else {
			myGame.currentPlayer.pLevel -= 1;
		}
	}
	
	public void func26Init() {
		//If Ichor cards are in play that give them combat bonus, double the effect.
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
