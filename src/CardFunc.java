
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
	public void func57(){
		p.className="Professor";
		end();
	}
	
	public void func1(boolean checkWin) {
		//If win, draw extra treasure
	}
	
	public void func2(boolean checkWin) {
		//+3 against Monster Whackers
		//Bad: Lose your class, unless you are a cultist
	}
	
	public void func3() {
		//+3 to monster
		//Play on a cultist for bonus...
	}
	
	public void func4(boolean checkWin) {
		//no class abilties
		//Bad: Discard your armour
	}
	
	public void func5(boolean checkWin) {
		//-2 against professors
		//+2 against cultists
		//Bad: Become a cultist, if already a cultist, donate 1000 gold
	}
	
	public void func7(boolean checkWin) {
		//-4 against females
		//Bad: Cultists must donate highest valued item in hand
		//Bad: Others must discard a card
	}
	
	public void func8(boolean checkWin) {
		//if number of cards in hand is even, +3 for monster
		//Bad: lose two levels
	}
	
	public void func26(boolean checkWin) {
		//Immune to Ichor cards, except Ichor cards player for them are double bonus
		//Bad: Give a card to every Cultist in the game
	}
	
	public void func27(boolean checkWin) {
		//+2 against Investigators
		//Bad: Discard items worth at least 500 gold
	}
	
	public void func28(boolean checkWin) {
		//Only Inchor cards work (fire/flame has double effect)
		//Bad: Give a card to the other player
	}
	
	public void func29(boolean checkWin) {
		//+10 to Monster
		//If win, draw two extra treasures
	}
	
	public void func30(boolean checkWin) {
		//-2 against Monster Whackers
		//Bad: You are dead
	}
	
	public void func31() {
		//+3 to monster
		//or play on cultist until they die or they lose the class
		//+3 permanant bonus
	}
	
	public void func32(boolean checkWin) {
		//Other player discards card from your hand
		//Bad: Discard all Ichor cards
	}
	
	public void func33(boolean checkWin) {
		//-2 against females
		//Can't help anyone out until you go up a level (useless)
	}
	
	public void func34() {
		//Same as func31
	}
	
	public void func35(boolean checkWin) {
		//-2 against professors or investigators
		//Bad: You must help anyone, no reward
	}
	
	public void func36(boolean checkWin) {
		//+3 against males
		//Male munchkins cannot help
		//Bad: Lose a level
	}
	
	public void func37(boolean checkWin) {
		//-2 against females
		//Bad: Discard whole hand
	}
	
	public void func38(boolean checkWin) {
		//+4 any non cultists
		//Bad: You die, new character is a Cultist
	}
	
	public void func39(boolean checkWin) {
		//+3 against investigators
		//You are now a cultist
		//Bad: You are still a cultist
	}
	
	public void func42(boolean checkWin) {
		//-5 to monster
		//If win, draw one fewer treasure (minimum 1)
	}
	
	public void func43(boolean checkWin) {
		//+10 to monster
		//If defeated, draw two extra treasures
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
