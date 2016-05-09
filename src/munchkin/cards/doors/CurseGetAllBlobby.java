package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;

public class CurseGetAllBlobby extends AbstractCurse {

	@Override
	public void cardInPlay() {
		//lose the armor you are wearing
		this.getOwner().getArmorSet().removeArmor();
	}

}