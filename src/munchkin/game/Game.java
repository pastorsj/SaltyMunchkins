package munchkin.game;

import munchkin.api.*;
import munchkin.game.panels.MainCardPanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Game {

	//Observed Value (DO NOT DELETE for now...)
	public static String action;
	private static final int WIN_LEVEL = 10;

	//-----Potential New Implementation-----
	//Assume only two players
	private Queue<IPlayer> players;
	//IMPORTANT: The concept of the hand in play
	private CardsInPlay cardsInPlay;
	private List<ICard> doorCards;
	private List<ICard> treasureCards;
	private List<ICard> allCards;
	private List<ICard> discardedDoorCards;
	private List<ICard> discardedTreasureCards;
	private Combat combat;


	public Game(int numberOfPlayers) {

		InitializeCards initializeCards = new InitializeCards(this);
		this.doorCards = initializeCards.getDoorCards();
		this.treasureCards = initializeCards.getTreasureCards();
		this.allCards = initializeCards.getAllCards();
		this.discardedDoorCards = new ArrayList<>();
		this.discardedTreasureCards = new ArrayList<>();
		this.cardsInPlay = new CardsInPlay();

		this.players = new LinkedList<>();
		for(int i = 0; i < numberOfPlayers; i++) {
			this.players.add(new AbstractPlayer());
		}
		this.dealInitialCards();

		//Constructs the idea of Combat, which will always have an referenced instance of the game
		this.combat = new Combat(this);

	}

	public IPlayer getCurrentPlayer() {
		return this.players.peek();
	}
	
	public IPlayer getOtherPlayer() {
		IPlayer first = this.players.poll();
		IPlayer second  = this.players.poll();
		this.players.offer(first);
		this.players.offer(second);
		return second;
	}

	public void endTurn() {
		IPlayer temp = this.players.poll();
		this.players.add(temp);

		//FIXME
//		this.bottomCardPanel.playerLabel.setText(this.getCurrentPlayer().getName());
//		this.bottomCardPanel.playerLevel.setText("player level: " + getCurrentPlayer().getPlayerLevel());
//		this.bottomCardPanel.playerCLevel.setText("combat level: " + getCurrentPlayer().getCombatLevel());
//		this.mainFrame.revalidate();
//		this.mainFrame.repaint();
		//Add Action here

	}

	public Queue<IPlayer> getPlayers() {
		return this.players;
	}

	public List<ICard> shuffle(ArrayList<ICard> cards) {
		Random rand = new Random();
		for (int i = cards.size() - 1; i > 0; i--) {
			int randNum = rand.nextInt(i);
			ICard temp = cards.get(randNum);
			cards.set(randNum, cards.get(i));
			cards.set(i, temp);
		}
		return cards;
	}

	public void dealInitialCards() {
		for(IPlayer player : this.players) {
			for(int i = 0; i < 4; i++) {
				player.getHand().insertCard(this.doorCards.remove(0));
				player.getHand().insertCard(this.treasureCards.remove(0));
			}
		}
	}

	public boolean dealNewCard(List<ICard> cards, IPlayer p) {
		if(p.getHand().insertCard(cards.get(0))) {
//			try {
//				this.bottomCardPanel.largeCard = ImageIO.read(new File ("resources\\m"+(cards.get(0)).getClass().getName()+".PNG"));
//				this.bottomCardPanel.repaint();
//			} catch(IOException e) {
//				e.printStackTrace();
//			}
//			FIXME: Replace above with
//			this.bottomCardPanel.updateLargeCard(cards.get(0));
			return true;
		}
		return false;
	}
	
	public boolean discardCard(IPlayer p, ICard card) throws Exception {
		if(p.getHand().removeCardFromHand(card)) {
			if (card.getCardType().equals(CardType.Door)) {
				this.discardedDoorCards.add(card);
				return true;
			} else if (card.getCardType().equals(CardType.Treasure)) {
				this.discardedTreasureCards.add(card);
				return true;
			} else {
				System.err.println("This card has no type!");
				return false;
			}
		}
		return false;
	}



	public void playACard(ICard card) {

		this.cardsInPlay.addCardsToPlay(card);

//		this.bottomCardPanel.playerLevel.setText("player level: " +this.getCurrentPlayer().getPlayerLevel());
//		this.bottomCardPanel.playerCLevel.setText("combat level: " +this.getCurrentPlayer().getCombatLevel());
//		this.bottomCardPanel.monsterLevel.setText("monster level: " +this.getMonsterLevel());
		
	}

	public boolean checkWin() {
		return this.getCurrentPlayer().getPlayerLevel() == WIN_LEVEL;
	}

	public Combat getCombat() {
		return this.combat;
	}
	
	public CardsInPlay getCardsInPlay() {
		return this.cardsInPlay;
	}
	
	public List<ICard> getAllCards() {
		return this.allCards;
	}
}
