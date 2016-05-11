package munchkin.cards.doors;

import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.game.Game;

public class CurseLearnYetAnotherAwfulTruth extends AbstractCurse {

	public CurseLearnYetAnotherAwfulTruth(Game game) {
			super(game);
	}

	@Override
	public void cardInPlay() {
		//lose a level
		IPlayer playedOn = this.game.getOtherPlayer();
		playedOn.addLevel(-1);
		this.setDiscard();
	}

}