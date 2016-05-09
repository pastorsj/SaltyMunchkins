package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;

public class CurseHairStandsOnEnd extends AbstractCurse {

	@Override
	public void cardInPlay() {
		//lose the headgear you are wearing
		this.getOwner().getArmorSet().removeHeadgear();
	}

}