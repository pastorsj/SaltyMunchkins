package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.api.IHand;
import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.game.Game;

import java.util.ArrayList;
import java.util.List;

public class CurseBackpackEaten extends AbstractCurse {

	public CurseBackpackEaten(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		IPlayer playedOn = this.game.getOtherPlayer();
		IHand hand = playedOn.getHand();
		List<ICard> toDelete = new ArrayList<>();
		for(ICard card : hand.getCards()) {
			if(card.isDisabled()) {
				//Add actions for each card
				toDelete.add(card);
			}
		}
		this.game.discardCards(playedOn, toDelete);
		this.setDiscard();
	}
	
}