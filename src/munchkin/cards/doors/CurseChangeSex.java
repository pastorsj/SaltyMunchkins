package munchkin.cards.doors;

import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.game.Game;

public class CurseChangeSex extends AbstractCurse {

	public CurseChangeSex(Game game) {
		super(game);
	}

	private int timesPlayed = 0;

	@Override
	public void cardInPlay() {
		IPlayer playedOn = this.game.getOtherPlayer();
		if(timesPlayed == 0) {
			this.switchGender();
			playedOn.addToCombatLevel(-5);
			timesPlayed++;
		}
		this.setDiscard();
	}

	private void switchGender() {
		IPlayer playedOn = this.game.getOtherPlayer();
		playedOn.setGender(playedOn.getGender().equals("Male") ? "Female" : "Male");
	}
}