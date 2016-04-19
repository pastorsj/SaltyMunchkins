package munchkin.game;

import munchkin.api.*;
import munchkin.game.panels.MainCardPanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Game {

	//Observed Value (DO NOT DELETE for now...)
	private Action action = Action.getInstance();
	private static final int WIN_LEVEL = 10;
	public static boolean gameSetUp = false;

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
			this.players.add(new Player());
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

	public void pass() {
		IPlayer temp = this.players.poll();
		this.players.add(temp);
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

	public ICard dealNewCard(String cardPileType, IPlayer p) throws Exception {
		List<ICard> cards;
		ICard card;
		if(cardPileType.equals("Door")) {
			cards = this.doorCards;
		} else if(cardPileType.equals("Treasure")) {
			cards = this.treasureCards;
		} else {
			throw new Exception("No such card pile type. Must be either treasure or door");
		}
		if(cards.size() < 1) {
			action.setValue("No cards left to draw");
			//FIXME: Eventually, we want to just reshuffle the discarded piles and continue the game
			return null;
		} else {
			card = cards.get(0);
			if(p.getHand().insertCard(cards.get(0))) {
				return card;
			} else {
				action.setValue("You can only have eight cards in your hand. Please discard any extras");
				return null;
			}
		}
	}
	
	public boolean discardCard(IPlayer p, ICard card) throws Exception {
		if(p.getHand().removeCardFromHand(card)) {
			card.setOwner(null);
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

	public boolean playACard(ICard card) {

		if(this.getCurrentPlayer().getArmorSet().checkArmor(card) && !card.isDisabled()) {
			this.getCurrentPlayer().getHand().removeCardFromHand(card);
			this.cardsInPlay.addCardsToPlay(card);
			return true;
		} else {
			this.action.setValue("Due to the current conditions, you are unable to play this card");
			return false;
		}
	}

	public boolean endTurn() {
		//TODO: Several things must happen when ending a turn
		// Resolve conflict
		this.combat.resolveFight();
		// Discard all changes that are set to be discarded
		for(ICard c : this.cardsInPlay.getCardsInPlay()) {
			if(c.checkDiscard()) {
				this.cardsInPlay.removeCardFromPlay(c);
			}
		}
		// Reset Combat
		this.combat.finish();
		this.combat.resetCombat();
		return true;
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
