package munchkin.game;

import munchkin.api.CardType;
import munchkin.api.ICard;

import java.util.ArrayList;
import java.util.List;

public class DiscardedCards {
	private List<ICard> discardedDoorCards;
	private List<ICard> discardedTreasureCards;
	private List<ICard> discardedCards;
	
	public DiscardedCards(){
		this.discardedDoorCards = new ArrayList<>();
		this.discardedTreasureCards = new ArrayList<>();
		this.discardedCards = new ArrayList<>();
	}

	public List<ICard> getDiscardedDoorCards() {
		return discardedDoorCards;
	}

	private void addToDiscardedDoorCards(ICard card) {
		this.discardedDoorCards.add(card);
	}

	public List<ICard> getDiscardedTreasureCards() {
		return discardedTreasureCards;
	}

	private void addToDiscardedTreasureCards(ICard card) {
		this.discardedTreasureCards.add(card);
	}

	public List<ICard> getAllCards() {
		return this.discardedCards;
	}

	public boolean addToDiscardedCards(ICard card){
		if (card.getCardType().equals(CardType.Door)) {
			this.addToDiscardedDoorCards(card);
			this.discardedCards.add(card);
			return true;
		}else if(card.getCardType().equals(CardType.Treasure)){
			this.addToDiscardedTreasureCards(card);
			this.discardedCards.add(card);
			return true;
		}else{
			System.err.println("This card has no type!");
			return false;
		}
	}
}
