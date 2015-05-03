import java.io.IOException;
import java.util.ArrayList;


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
	
	public void func14() {
		if(myGame.currentPlayer.pHand.size() > 8) {
			int card = myGame.currentPlayer.pHand.get(myGame.currentPlayer.pHand.size()-1);
			myGame.discardCard(myGame.currentPlayer, card);
			func14();
		}
	}
	
	public void func15() {
		if(myGame.currentPlayer.gender == 'F') {
			myGame.currentPlayer.gender = 'M';
		} else {
			myGame.currentPlayer.gender = 'F';
		}
		myGame.currentPlayer.cLevel -= 5;
	}
	
	public void func17() {
		myGame.currentPlayer.cLevel -= 3;
		if(myGame.currentPlayer.pHand.contains(111)) {
			myGame.discardCard(myGame.currentPlayer, 111);
		}
		if(myGame.currentPlayer.pHand.contains(146)) {
			myGame.discardCard(myGame.currentPlayer, 146);
		}
	}
	
	public void func18() {
		//Curse: Need to discard all armor in play
	}
	
	public void func19() {
		//Curse: Need to discard all headgear in play
	}
	
	public void func20() {
		//Curse: Discard all class cards except Cultist
		if(myGame.currentPlayer.pHand.contains(49)) {
			//Discard card 49
			myGame.discardCard(myGame.currentPlayer, 49);
		} 
		if(myGame.currentPlayer.pHand.contains(57)) {
			//Discard card 57
			myGame.discardCard(myGame.currentPlayer, 57);
		}
		if(myGame.currentPlayer.pHand.contains(44)) {
			//Discard card 44
			myGame.discardCard(myGame.currentPlayer, 44);
		}
		if(myGame.currentPlayer.pPlay.contains(49)) {
			//Discard card 49
			myGame.discardCard(myGame.currentPlayer, 49);
			myGame.currentPlayer.className = "";
		} 
		if(myGame.currentPlayer.pHand.contains(57)) {
			//Discard card 57
			myGame.discardCard(myGame.currentPlayer, 57);
			myGame.currentPlayer.className = "";
		}
		if(myGame.currentPlayer.pHand.contains(44)) {
			//Discard card 44
			myGame.discardCard(myGame.currentPlayer, 44);
			myGame.currentPlayer.className = "";
		}
	}
	
	public void func21() {
		//Other player choose an item that you must discard that is already in play
	}
	
	public void func22() {
		//Curse: Lose a level
		myGame.currentPlayer.pLevel -= 1;
	}
	
	public void func23() {
		//Curse: Must discard at least 1000 gold pieces
	}
	
	public void func24() {
		//Curse: Must discard your footgear...
	}
	
	public void func25() {
		//Another curse, need algorithm...
	}
	
	public void func26Init() {
		//If Ichor cards are in play that give them combat bonus, double the effect.
		//Perhaps Cards No: 100, 132
		myGame.changePlayer();
		if(myGame.currentPlayer.pPlay.contains(100)) {
			myGame.changePlayer(); 
			myGame.currentPlayer.cLevel -= 6;
		}
		if(myGame.currentPlayer.pPlay.contains(132)) {
			myGame.changePlayer();
			myGame.currentPlayer.cLevel -= 4;
		}
	}
	
	public void func26(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		} else {
			//Right now, we will take the last card from the current player and give it to the other player
			int card = myGame.currentPlayer.pHand.get(myGame.currentPlayer.pHand.size()-1);
			myGame.currentPlayer.pHand.remove(myGame.currentPlayer.pHand.indexOf(card));
			myGame.changePlayer();
			myGame.currentPlayer.pHand.add(card);
			myGame.changePlayer();
		}
	}
	
	public void func27Init() {
		if(myGame.currentPlayer.className.equals("Professor")) {
			myGame.currentPlayer.cLevel -= 2;
		}
	}
	
	public void func27(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		} else {
			//Discard cards depending on the user, must add up to 500 gold.
		}
	}
	
	public void func28Init() {
		myGame.currentPlayer.cLevel = myGame.currentPlayer.pLevel;
		//Will add something like this once the rest of the cards are implemented in
//		if(myGame.currentPlayer.pPlay.contains(85)) {
//			myGame.funcs.func85Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(100)) {
//			myGame.funcs.func100Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(101)) {
//			myGame.funcs.func101Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(105)) {
//			myGame.funcs.func105Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(127)) {
//			myGame.funcs.func127Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(85)) {
//			myGame.funcs.func132Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(85)) {
//			myGame.funcs.func137Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(85)) {
//			myGame.funcs.func137Init();
//		}
//		if(myGame.currentPlayer.pPlay.contains(142)) {
//			myGame.funcs.func142Init();
//		}
	}
	
	public void func28(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		} else {
			//Give a card to another player
			int card = myGame.currentPlayer.pHand.get(myGame.currentPlayer.pHand.size()-1);
			myGame.currentPlayer.pHand.remove(myGame.currentPlayer.pHand.size()-1);
			myGame.changePlayer();
			myGame.currentPlayer.pHand.add(card);
			myGame.changePlayer();
		}
	}
	
	public void func29Init() {
		myGame.currentPlayer.cLevel -= 10;
	}
	
	public void func29(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		}
	}
	
	public void func30Init() {
		if(myGame.currentPlayer.className.equals("Monster Whacker")) {
			myGame.currentPlayer.cLevel += 2;
		}
	}
	
	public void func30(boolean checkWin) {
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			}
		} else {
			//Need to call a win method for the other player, such as playerWin(myGame.currentPlayer);
		}
	}
	
	public void func31() {
		//+3 to monster
		//or play on cultist until they die or they lose the class
		//+3 permanant bonus
		//same as func3()
	}
	
	public void func32Init() {
		//Must discard card in your hand
		//Right now, it will delete the last card in your hand
		//Could make it random
		myGame.currentPlayer.pHand.remove(myGame.currentPlayer.pHand.size()-1);
	}
	
	public void func32(boolean checkWin) {
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			}
		} else {
			//Need to discard all Ichor cards
			if(myGame.currentPlayer.pHand.contains(85)) {
				myGame.discardCard(myGame.currentPlayer, 85);
			}
			if(myGame.currentPlayer.pHand.contains(100)) {
				myGame.discardCard(myGame.currentPlayer, 100);
			}
			if(myGame.currentPlayer.pHand.contains(101)) {
				myGame.discardCard(myGame.currentPlayer, 101);
			}
			if(myGame.currentPlayer.pHand.contains(105)) {
				myGame.discardCard(myGame.currentPlayer, 105);
			}
			if(myGame.currentPlayer.pHand.contains(127)) {
				myGame.discardCard(myGame.currentPlayer, 127);
			}
			if(myGame.currentPlayer.pHand.contains(132)) {
				myGame.discardCard(myGame.currentPlayer, 132);
			}
			if(myGame.currentPlayer.pHand.contains(137)) {
				myGame.discardCard(myGame.currentPlayer, 137);
			}
			if(myGame.currentPlayer.pHand.contains(142)) {
				myGame.discardCard(myGame.currentPlayer, 142);
			}
		}
	}
	
	public void func33Init() {
		if(myGame.currentPlayer.gender == 'F') {
			myGame.currentPlayer.cLevel += 2;
		}
	}
	
	public void func33(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		} else {
			//Can't help others until you go up a level...
		}
	}
	
	public void func34() {
		//Same as func3()
	}
	
	public void func35Init() {
		if(myGame.currentPlayer.className.equals("Professor")) {
			myGame.currentPlayer.cLevel += 2;
		}
		if(myGame.currentPlayer.className.equals("Investigator")) {
			myGame.currentPlayer.cLevel += 2;
		}
	}
	
	public void func35(boolean checkWin) {
		if(checkWin) {
			for(int i = 0; i < 4; i++) {
				myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			}
		} else {
			//You must help the other person in combat
		}
	}
	
	public void func36Init() {
		//Male munchkins cannot help...
		if(myGame.currentPlayer.gender == 'M') {
			myGame.currentPlayer.cLevel -= 3;
		}
	}
	
	public void func36(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		} else {
			myGame.currentPlayer.pLevel -= 1;
		}
	}
	
	public void func37Init() {
		if(myGame.currentPlayer.gender == 'F') {
			myGame.currentPlayer.cLevel += 2;
		}
	}
	
	public void func37(boolean checkWin) {
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			}
		} else {
			myGame.currentPlayer.pHand = new ArrayList<Integer>();
		}
	}
	
	public void func38Init() {
		if(myGame.currentPlayer.className.equals("Cultist")) {
			myGame.currentPlayer.cLevel -= 4;
		}
	}
	
	public void func38(boolean checkWin) {
		if(checkWin) {
			for(int i = 0; i < 5; i++) {
				myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			}
		} else {
			myGame.currentPlayer.className = "Cultist";
			myGame.currentPlayer.pHand = new ArrayList<Integer>();
		}
	}
	
	public void func39Init() {
		if(myGame.currentPlayer.className.equals("Investigator")) {
			myGame.currentPlayer.cLevel -= 3;
		}
		myGame.currentPlayer.className = "Cultist";
	}
	
	public void func39(boolean checkWin) {
		if(checkWin) {
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
			myGame.dealNewCardTest(myGame.treasures, myGame.currentPlayer);
		}
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
