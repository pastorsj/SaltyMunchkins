package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class CurseLearnYetAnotherAwfulTruth extends Door {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		//lose a level
		this.getOwner().addLevel(-1);
	}

	@Override
	public void cardPlayed(boolean win) {
		
	}
}