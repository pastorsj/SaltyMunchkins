package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class CurseHairStandsOnEnd extends Door {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		//lose the headgear you are wearing
		this.getOwner().getArmorSet().removeHeadgear();;
	}

	@Override
	public void cardPlayed(boolean win) {
		
	}
}