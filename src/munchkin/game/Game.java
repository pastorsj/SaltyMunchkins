package munchkin.game;

import munchkin.api.*;
import munchkin.cards.doors.api.AbstractMonster;

import java.util.*;

public class Game {

	// Observed Value (DO NOT DELETE for now...)
	private Action action = Action.getInstance();
	private static final int WIN_LEVEL = 10;
	public static boolean gameSetUp = false;

	// -----Potential New Implementation-----
	// Assume only two players
	private Queue<IPlayer> players;
	// IMPORTANT: The concept of the hand in play
	private CardsInPlay cardsInPlay;
	private InitializeCards initializeCards;
	private DiscardedCards discardedCards;
	private Combat combat;
	private boolean drewCard;

	public Game(int numberOfPlayers) {
		this.initializeCards = new InitializeCards(this);
		this.discardedCards = new DiscardedCards();
		this.cardsInPlay = new CardsInPlay(this);

		this.players = new LinkedList<>();
		for (int i = 0; i < numberOfPlayers; i++) {
			this.players.add(new Player());
		}
		this.dealInitialCards();
		// Constructs the idea of Combat, which will always have an referenced
		// instance of the game
		this.combat = new Combat(this);

	}

	public IPlayer getCurrentPlayer() {
		return this.players.peek();
	}

	public IPlayer getOtherPlayer() {
		IPlayer first = this.players.poll();
		IPlayer second = this.players.poll();
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

	public List<ICard> shuffle(List<ICard> cards) {
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
		shuffle(this.initializeCards.getTreasureCards());
		shuffle(this.initializeCards.getDoorCards());
		
		for (IPlayer player : this.players) {
			for (int i = 0; i < 4; i++) {
				player.addCardToHand(this.initializeCards.removeDoorCard(0));
				player.addCardToHand(this.initializeCards.removeTreasureCard(0));
			}
		}
	}

	public ICard dealNewDoorCard(IPlayer p) {
		return this.drawACard(this.initializeCards.getDoorCards(), p);
	}

	public ICard dealNewTreasureCard(IPlayer p) {
		return this.drawACard(this.initializeCards.getTreasureCards(), p);
	}

	public ICard drawACard(List<ICard> cards, IPlayer p) {
		if(drewCard){
			return null;
		}
		
		if (cards.size() < 1) {
			action.setValue("No cards left to draw. Reshuffling...");
			this.initializeCards = new InitializeCards(this);
		}
		
		ICard card = cards.get(0);
		if (p.getHand().insertCard(card)) {
			cards.remove(0);
			drewCard = true;
			return card;
		} else {
			action.setValue("You can only have eight cards in your hand. Please discard any extras");
			return null;
		}
	}

	public boolean discardCard(IPlayer p, ICard card) {
		if (p.getHand().removeCardFromHand(card)) {
			card.setOwner(null);
			return this.discardedCards.addToDiscardedCards(card);
		}
		return false;
	}

	public boolean playACard(ICard card) {
		for(ICard c: this.cardsInPlay.getCardsInPlay()){
			if (c instanceof AbstractMonster){
				if(card instanceof AbstractMonster){
					return false;
				}
			}
		}
		
		if (this.getCurrentPlayer().getArmorSet().checkArmor(card) && !card.isDisabled()) {
			this.cardsInPlay.addCardsToPlay(card);
			this.getCurrentPlayer().getHand().removeCardFromHand(card);
			if (card instanceof AbstractMonster) {
				this.action.setValue("Added " + card.getName() + " monster to combat");
				this.combat.addMonsterToFight((AbstractMonster) card);
			}
			return true;
		} else {
			this.action.setValue("Due to the current conditions, you are unable to play this card");
			return false;
		}
	}

	public boolean endTurn() {
		// TODO: Several things must happen when ending a turn
		// Resolve conflict
		this.combat.resolveFight();
		// Discard all changes that are set to be discarded
		for (ICard c : this.cardsInPlay.getCardsInPlay()) {
			if (c.checkDiscard()) {
				this.cardsInPlay.removeCardFromPlay(c);
			}
		}
		// Reset Combat
		this.combat.finish();
		this.combat.resetCombat();
		drewCard = false;
		return true;
	}

	public DiscardedCards getDiscardedCards() {
		return this.discardedCards;
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
		return this.initializeCards.getAllCards();
	}
}
