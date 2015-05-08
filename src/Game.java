import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

public class Game {
	ArrayList<Integer> doors = new ArrayList<Integer>();
	ArrayList<Integer> treasures = new ArrayList<Integer>();
	ArrayList<Integer> discards = new ArrayList<Integer>();
	Player p1 = new Player("p1");
	Player p2 = new Player("p2");
	Player currentPlayer = p1;
	Player otherPlayer = p2;
	int turnPlayer;
	CardFunc funcs = new CardFunc(this);
	int mInPlay = 0; //0 indicates no monster, otherwise card number goes here.
	int mLevel = 0; //0 indicates no monster, otherwise monster level goes here.
	MFrame mframe;
	InitializeCards ic = new InitializeCards();
	
	

	public Game(ArrayList<Integer> doors, ArrayList<Integer> treasures) {
 		this.doors = doors;
		this.treasures = treasures;
		this.turnPlayer=1;
		p1.pHand = new ArrayList<Integer>();
		p2.pHand = new ArrayList<Integer>();
	}
	
	public void changePlayer() {
		if(turnPlayer == 1) {
			p1 = currentPlayer;
			currentPlayer = p2;
			otherPlayer = p1;
			turnPlayer = 2;
		} else {
			p2 = currentPlayer;
			currentPlayer = p1;
			otherPlayer = p2;
			turnPlayer = 1; 
		}
	}
	

	public ArrayList<Integer> shuffle(ArrayList<Integer> cards) {
		Random rand = new Random();
		for (int i = cards.size() - 1; i > 0; i--) {
			int randNum = rand.nextInt(i);
			int temp = cards.get(randNum);
			cards.set(randNum, cards.get(i));
			cards.set(i, temp);
		}
		return cards;
	}
	
	public void setInitialCards(){
		p1.pHand=this.dealCards();
		p2.pHand=this.dealCards();
	}

	
	public ArrayList<Integer> dealCards() {
		ArrayList<Integer> deal = new ArrayList<Integer>();
		doors = shuffle(doors);
		treasures = shuffle(treasures);
		for (int i = 0; i <= 3; i++) {
			deal.add(doors.get(doors.size() - 1));
			deal.add(treasures.get(treasures.size()-1));
			doors.remove(doors.get(doors.size() - 1));
			treasures.remove(treasures.get(treasures.size()-1));
			
		}
		return deal;
	}
	//This function will not deal another card if the player hand size equals 8
	public boolean dealNewCard(ArrayList<Integer> cards, Player p){
		int size = cards.size()-1;
		if(p.pHand.size() < 8) {
			p.pHand.add(cards.get(size));
			try {
				this.mframe.mainPanel.bCardPanel.largeCard = ImageIO.read(new File ("src\\m"+(cards.get(size))+".PNG"));
				this.mframe.mainPanel.bCardPanel.repaint();
			} catch (IOException e) {
				System.out.println("error reading card in GAME");
				e.printStackTrace();
			}
			cards.remove(size);
			return true;
		} return false;
	}
	
	public boolean dealNewCardTest(ArrayList<Integer> cards, Player p){
		int size = cards.size()-1;
		if(p.pHand.size() < 8) {
			p.pHand.add(cards.get(size));
			cards.remove(size);
			return true;
		} return false;
	}
	
	public boolean mustDiscard(Player p) {
		return p.pHand.size()>=8;
	}
	
	public boolean discardCard(Player p, int card) {
		if(p.pHand.contains(card)) {
			p.pHand.remove(p.pHand.indexOf(card));
			discards.add(card);
			return true;
		}return false;
	}
	
	public ArrayList<Integer> returnDiscardPile() {
		return discards;
	}
	
	//num==0 indicates a random value. otherwise, use given value.
	public int rollDice(int num) {
		if(num==0){
			Random rand = new Random();
			return rand.nextInt(6) + 1;
		}
		else{
			return num;
		}
		
	}
	
	public void updateMLevel(int cardToMove){
		InitializeCards ic = new InitializeCards();
		if (cardToMove < 83) { //if the card is a door card being put in play: 
		Card cardInPlay = ic.getCardHash().get(cardToMove);
		if(this.mLevel==0){ //if a monster is in play, don't want to override
								//with another door card.
			//myGame.mInPlay=cardInPlay.num;
			System.out.println(cardToMove);
			this.mLevel = ic.getCardHash().get(cardToMove).monsterLevel;
					
		}
		if (this.mInPlay != 0) {
			//myGame.mLevel = ic.getCardHash().get(cardToMove).monsterLevel+myGame.mLevel;
				
		}
	
	}
	}
	
	public void playACard(int card){
		CardFunc cf = new CardFunc(this);
		
		int methodNum = card;
		String funcToCall = "func"+methodNum+"Init";
		try {
			Method method =CardFunc.class.getMethod(funcToCall,null);
			try {
				method.invoke(cf, null);
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
			//System.out.println("no such method...");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
