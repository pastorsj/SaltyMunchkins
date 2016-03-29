package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class CurseSolestealer extends Door {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		//lose the foodgear you are wearing
		this.getOwner().getArmorSet().removeFootgear();
	}

	@Override
	public void cardPlayed(boolean win) {
		
	}
}