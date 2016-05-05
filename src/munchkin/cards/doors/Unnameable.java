package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;

public class Unnameable extends Door {

	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		if (this.getOwner().getFaction().equals(Faction.Professor)) {
			this.setLevel(10);
		} else {
			this.setLevel(5);
		}
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win){
			this.addTreasures(1);
		}
	}
}