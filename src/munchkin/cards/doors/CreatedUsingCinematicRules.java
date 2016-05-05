package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;

public class CreatedUsingCinematicRules extends Door {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		this.getOwner().getArmorSet().setMaxHands(3);
	}

	@Override
	public void cardPlayed(boolean win) {
		
	}
}