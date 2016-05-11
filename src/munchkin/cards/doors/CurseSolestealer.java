package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.game.Game;

import java.util.List;

public class CurseSolestealer extends AbstractCurse {

	public CurseSolestealer(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		//lose the footgear you are wearing
		IPlayer playedOn = this.game.getOtherPlayer();
		List<ICard> footgear = playedOn.getArmorSet().removeFootgear();
		if(footgear == null) {
			this.action.setValue("You played a curse that had no effect!");
			return;
		}
		this.game.discardCards(playedOn, footgear);
		this.setDiscard();
	}

}