package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class IndescribablyHorrible extends Door {

	@Override
	public void cardInPlay() {
		this.setLevel(10);
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.addTreasures(2);
		}
	}
}