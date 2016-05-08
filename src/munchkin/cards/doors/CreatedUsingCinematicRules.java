package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class CreatedUsingCinematicRules extends Door {

	@Override
	public void cardInPlay() {
		this.getOwner().getArmorSet().setMaxHands(3);
	}
}