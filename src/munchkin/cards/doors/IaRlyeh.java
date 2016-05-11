package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.cards.doors.api.Door;
import munchkin.game.Game;

import java.util.List;

public class IaRlyeh extends Door {

	private Game game;

	public IaRlyeh(Game game) {
		super(game);
		this.game = game;
	}

	@Override
	public void cardInPlay() {
		//If you play this card, you exchange it for the most recent discarded card
		List<ICard> discardedCards = this.game.getDiscardedCards().getAllCards();
		ICard lastCard = discardedCards.remove(discardedCards.size()-1);
		try {
			this.game.discardCard(this.getOwner(), this);
		} catch(Exception e) {
			System.err.println("Attempted to discard IaRlyeh");
		}
		this.getOwner().addCardToHand(lastCard);
	}
}