package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class InAMillionYearSleep extends Door {

	@Override
	public void cardInPlay() {
		this.setLevel(-5);
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.addTreasures(-1);
			if(this.getTreasures()<1) {
				this.setTreasures(1);
			}
		}
	}
}