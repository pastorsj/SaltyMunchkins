package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;

public class CurseLearnYetAnotherAwfulTruth extends AbstractCurse {

	@Override
	public void cardInPlay() {
		//lose a level
		this.getOwner().addLevel(-1);
	}

}