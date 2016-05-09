package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;

public class CurseMadnessTakesItsToll extends AbstractCurse {

	@Override
	public void cardInPlay() {
		this.getOwner().addGoldToDiscard(1000);
	}

}