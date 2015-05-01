
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
		p.cLevel -= 5;
	}
	
	public void func1(boolean checkWin) {
		//+5 to Monster
		//If win, draw extra treasure
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		}
	}
	
	public void func2Init() {
		if(p.className.equals("Monster Whacker")) {
			p.cLevel -= 3;
		}
	}
	
	public void func2(boolean checkWin) {
		//+3 against Monster Whackers
		//Bad: Lose your class, unless you are a cultist
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			if(!p.className.equals("Cultist")) {
				p.className = "";				
				//Need to discard any class card in play
			}
		}
	}
	
	public void func3() {
		//+3 to monster
		//Play on a cultist for bonus...
	}
	
	public void func4Init() {
		//No class abilties are used
		p.classAbility = false; //maybe...
	}
	
	public void func4Result(boolean checkWin) {
		//no class abilties
		//Bad: Discard your armour
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Discard armour
		}
	}
	
	public void func5Init() {
		if(p.className.equals("Professor")) {
			p.cLevel += 2;
		} else if(p.className.equals("Cultist")) {
			p.cLevel -= 2;
		}
	}
	
	public void func5(boolean checkWin) {
		//-2 against professors
		//+2 against cultists
		//Bad: Become a cultist, if already a cultist, donate 1000 gold
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			if (p.className.equals("Cultist")) {
				//Discard treasures that add up to 1000 gold
			} else {
				p.className = "Cultist";
			}
		}
	}
	
	public void func7Init() {
		if(p.gender == 'F') {
			p.cLevel += 4;
		}
	}
	
	public void func7(boolean checkWin) {
		//-4 against females
		//Bad: Cultists must donate highest valued item in hand
		//Bad: Others must discard a card
		if(p.className.equals("Cultist")) {
			//Discard highest value in hand
			System.out.println("Discard highest valued item in hand");
		} else {
			//Discard a card in your hand
			System.out.println("Discard a card in your hand");
		}
	}
	
	public void func8Init() {
		if(p.pHand.size()%2 == 0) {
			p.cLevel -= 3;
		}
	}
	
	public void func8(boolean checkWin) {
		//if number of cards in hand is even, +3 for monster
		//Bad: lose two levels and discard a card from your hand
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			p.pLevel -= 2;
			if(p.pLevel<1) {
				p.pLevel = 1;
			}
			//Discard a card from your hand
		}
	}
	
	public void func26Init() {
		//if ichor cards are in play to give them combat bonus, double effect
	}
	
	public void func26(boolean checkWin) {
		//Immune to Ichor cards, except Ichor cards player for them are double bonus
		//Bad: Give a card to every Cultist in the game
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//Give a card to other player if they are a Cultist
		}
	}
	
	public void func27Init() {
		if(p.className.equals("Professor")) {
			p.cLevel -= 2;
		}
	}
	
	public void func27(boolean checkWin) {
		//+2 against Investigators
		//Bad: Discard items worth at least 500 gold
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Discard items worth at least 500 gold
		}
	}
	
	public void func28Init() {
		p.cLevel = p.pLevel; //Reset to initial level
		//Check for Ichor cards in play, all other items are useless
	}
	
	public void func28(boolean checkWin) {
		//Only Inchor cards work (fire/flame has double effect)
		//Bad: Give a card to the other player
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Give a card to the other player
		}
	}
	
	public void func29Init() {
		p.cLevel -= 10;
		myGame.mLevel += 10;
	}
	
	public void func29(boolean checkWin) {
		//+10 to Monster
		//If win, draw two extra treasures
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		}
	}
	
	public void func30Init() {
		if(p.className.equals("Monster Whacker")) {
			p.cLevel += 2;
		}
	}
	
	public void func30(boolean checkWin) {
		//-2 against Monster Whackers
		//Bad: You are dead
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//You are dead...
		}
	}
	
	public void func31() {
		//+3 to monster
		//or play on cultist until they die or they lose the class
		//+3 permanant bonus
		//same as func3()
	}
	
	public void func32Init() {
		//Discard one card from your hand
	}
	
	public void func32(boolean checkWin) {
		//Other player discards card from your hand
		//Bad: Discard all Ichor cards
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//Discard all ichor cards from hand
		}
	}
	
	public void func33Init() {
		if(p.gender == 'F') {
			p.cLevel += 2;
		}
	}
	
	public void func33(boolean checkWin) {
		//-2 against females
		//Can't help anyone out until you go up a level (useless)
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//somewhat useless...
		}
	}
	
	public void func34() {
		//Same as func3()
	}
	
	public void func35Init() {
		if(p.className.equals("Professor")) {
			p.cLevel += 2;
		} else if(p.className.equals("Investigator")){
			p.cLevel += 2;
		}
	}
	
	public void func35(boolean checkWin) {
		//-2 against professors or investigators
		//Bad: You must help anyone, no reward
		if(checkWin) {
			for(int i = 0; i < 4; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//Must help everyone...
		}
	}
	
	public void func36Init() {
		if(p.gender == 'M') {
			p.cLevel -= 3;
		}
	}
	
	public void func36(boolean checkWin) {
		//+3 against males
		//Male munchkins cannot help
		//Bad: Lose a level
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			p.pLevel -= 1;
		}
	}
	
	public void func37Init() {
		if(p.gender == 'F') {
			p.cLevel += 2;
		}
	}
	
	public void func37(boolean checkWin) {
		//-2 against females
		//Bad: Discard whole hand
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//Discard entire hand
		}
	}
	
	public void func38Init() {
		if(!p.className.equals("Cultist")) {
			p.cLevel -= 4;
		}
	}
	
	public void func38(boolean checkWin) {
		//+4 any non cultists
		//Bad: You die, new character is a Cultist
		if(checkWin) {
			for(int i = 0; i < 5; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//You die
			p.className = "Cultist";
		}
	}
	
	public void func39Init() {
		if(p.className.equals("Investigators")) {
			p.cLevel -= 3;
		}
		p.className = "Cultist";
	}
	
	public void func39(boolean checkWin) {
		//+3 against investigators
		//You are now a cultist
		//Bad: You are still a cultist
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Nothing happens, you are still a cultist
		}
	}
	
	public void func42Init() {
		p.cLevel += 5;
	}
	
	public void func42(boolean checkWin) {
		//-5 to monster
		//If win, draw one fewer treasure (minimum 1)
		if(checkWin) {
			//Draw one fewer treasure method
			//Perhaps discards last treasure card drawn
		}
	}
	
	public void func43Init() {
		p.cLevel -= 10;
	}
	
	public void func43(boolean checkWin) {
		//+10 to monster
		//If defeated, draw two extra treasures
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		}
	}
	
	public void func44Init() {
		p.className = "Investigator";
	}
	
	public void func44() {
		//Peek: Look at door, can discard three cards and keep door card and turn over next door
		//Look for trouble: If win, draw extra treasure
	}
	
	public void func45(boolean checkWin) {
		//Footgear does not count until end of fight
		//-2 run away
		//Bad: Discard card that other player chooses
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Discard one card chosen by other player
		}
	}
	
	public void func46Init() {
		if(p.className.equals("Cultist")) {
			p.cLevel += 2;
		}
	}
	public void func46(boolean checkWin) {
		//-2 against Cultists
		//Bad: Lose two levels
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			p.pLevel -= 2; //Can levels go negative?
		}
	}
	
	public void func47(boolean checkWin) {
		//Bad: Anyone who helps loses a level
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Check to see if other player helped...
		}
	}
	
	public void func48Init() {
		p.cLevel -= 5;
	}
	
	public void func48(boolean checkWin) {
		//+5 to monster
		//If win, draw extra treasure
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		}
	}
	
	public void func49() {
		//Monster Whacker
		p.className = "Monster Whacker";
	}
	
	public void func51Init() {
		if(p.gender == 'M') {
			p.cLevel -= 3;
		}
	}
	
	public void func51(boolean checkWin) {
		//+3 against males
		//Bad: Discard 3 cards
		if(checkWin) {
			for(int i = 0; i < 4; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//Discard 3 cards
		}
	}
	
	public void func52Init() {
		int pNum = myGame.turnPlayer;
		if(pNum == 1) {
			if(myGame.p1.pLevel < myGame.p2.pLevel) {
				p.cLevel -= 4;
			}
		} else {
			if(myGame.p2.pLevel < myGame.p1.pLevel) {
				p.cLevel -= 4;
			}
		}
	}
	
	public void func52(boolean checkWin) {
		//If you are the lowest level, +4 against you
		//Bad: Other player takes one of your cards in play
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Other player takes one of your cards in play
		}
	}
	
	public void func54(boolean checkWin) {
		//Does not pursue of Level 4 or below (No roll dice)
		//Defeated by Song of Madness, but you become a Cultist
		//Bad: You die
		if(checkWin) {
			for(int i = 0; i < 5; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
			p.pLevel += 2;
		} else {
			//You die
		}
	}
	
	public void func55Init() {
		if(p.className.equals("Professor")) {
			p.cLevel -= 3;
		}
	}
 	
	public void func55(boolean checkWin) {
		//+3 against Professors
		//Bad: Lose a level
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			p.pLevel -= 1;
		}
	}
	
	public void func57() {
		//Professor
		p.className = "Professor";
	}
	
	public void func58(boolean checkWin) {
		//same as func3()
	}
	
	public void func59(boolean checkWin) {
		//Bad: Become a cultist
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			p.className = "Cultist";
		}
	}
	
	public void func60Init() {
		p.cLevel -= 5;
	}
	
	public void func60(boolean checkWin) {
		//+5 to monster
		//if win, draw extra treasure
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		}
	}
	
	public void func61Init() {
		if(p.className.equals("Professor")) {
			p.cLevel -= 2;
		}
	}
	
	public void func61(boolean checkWin) {
		//+2 against professors
		//Bad: You are dead
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//You die
		}
	}
	
	public void func62Init() {
		if(p.className.equals("Cultist")) {
			p.cLevel -= 3;
		}
	}
	
	public void func62(boolean checkWin) {
		//+3 against Cultists
		//Bad: Lose a level
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			p.pLevel -= 1;
		}
	}
	
	public void func63Init() {
		if(p.className.equals("Investigator")) {
			p.cLevel += 2;
		}
	}
	
	public void func63(boolean checkWin) {
		//-2 against investigators
		//Will not pursue anyone of Level 2 or below
		//Bad: Become a cultist
		if(checkWin) {
			for(int i = 0; i < 4; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
			p.pLevel += 2;
		} else {
			p.className = "Cultist";
		}
	}
	
	public void func64(boolean checkWin) {
		//Will not pursue anyone of Level 3 or below
		//Bad: Lose three levels and your footgear
		if(checkWin) {
			for(int i = 0; i < 4; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
			p.pLevel += 2;
		} else {
			//Lose footgear
			p.pLevel -= 3;
		}
	}
	
	public void func65Init() {
		if(p.className.equals("Monster Whacker")) {
			p.cLevel += 3;
		}
	}
	
	public void func65(boolean checkWin) {
		//-3 against Monster Whackers
		//Bad: If you are the lowest level, lose a level, otherwise, p2 goes up a level
		if(checkWin) {
			for(int i = 0; i < 4; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//If you are the lowest level, lose a level, otherwise, p2 goes up a level
		}
	}
	
	public void func66Init() {
		p.cLevel -= 5;
	}
	
	public void func66(boolean checkWin) {
		//+5 to monster
		//If win, draw extra treasure
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
		}
	}
	
	public void func70(boolean checkWin) {
		//Bad: Discard all door cards in your hand
		//If win, draw extra door card face down
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
			//Deal out a new door card
		} else {
			//Discard all door cards in your hand
		}
	}
	
	public void func71Init() {
		if(p.gender == 'F') {
			p.cLevel -= 2;
		}
	}
	
	public void func71(boolean checkWin) {
		//+2 against females
		//Bad: Discard all helpful class card
		if(checkWin) {
			for(int i = 0; i < 3; i++) {
				myGame.dealNewCard(myGame.treasures, p);
			}
		} else {
			//Discard all helpful class cards
		}
	}
	
	public void func72Init() {
		if(p.className.equals("Monster Whacker")) {
			p.cLevel -= 6;
		}
	}
	
	public void func72(boolean checkWin) {
		//+6 against Monster Whackers
		//Bad: Lose your headgear and footgear
		if(checkWin) {
			myGame.dealNewCard(myGame.treasures, p);
			myGame.dealNewCard(myGame.treasures, p);
		} else {
			//Discard your headgear and footgear
		}
	}
	
		
	public void playClass(){
		
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
