package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class CurseGetAllBlobby extends Door {
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		//lose the armor you are wearing
		this.getOwner().getArmorSet().removeArmor();;
	}

	@Override
	public void cardPlayed(boolean win) {
		
	}
}