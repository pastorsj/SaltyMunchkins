package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;

public class CurseChangeSex extends AbstractCurse {

	private int timesPlayed = 0;

	@Override
	public void cardInPlay() {
		if(timesPlayed == 0) {
			this.switchGender();
			this.getOwner().addToCombatLevel(-5);
			timesPlayed++;
		}
	}

	private void switchGender() {
		this.getOwner().setGender(this.getOwner().getGender().equals("Male") ? "Female" : "Male");
	}
}