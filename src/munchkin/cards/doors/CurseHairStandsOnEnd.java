package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.game.Game;

import java.util.List;

public class CurseHairStandsOnEnd extends AbstractCurse {

	public CurseHairStandsOnEnd(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		//lose the headgear you are wearing
		IPlayer playedOn = this.game.getOtherPlayer();
		List<ICard> removedCards = playedOn.getArmorSet().removeHeadgear();
		if(removedCards == null) {
			this.action.setValue("You played a curse that had no effect!");
			return;
		}
		this.game.discardCards(playedOn, removedCards);
		this.setDiscard();
	}

}