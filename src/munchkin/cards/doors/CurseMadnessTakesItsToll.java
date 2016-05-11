package munchkin.cards.doors;

import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.game.Game;

public class CurseMadnessTakesItsToll extends AbstractCurse {

	public CurseMadnessTakesItsToll(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		IPlayer playedOn = this.game.getOtherPlayer();
		playedOn.addGoldToDiscard(1000);
		this.setDiscard();
	}

}