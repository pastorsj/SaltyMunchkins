package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;

public class CurseSolestealer extends AbstractCurse {

	@Override
	public void cardInPlay() {
		//lose the footgear you are wearing
		this.getOwner().getArmorSet().removeFootgear();
	}

}