package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class GramSmoker extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setTreasures(1);
		if(this.getOwner().getGender().equals("Male")) {
			this.setLevel(5);
		} else {
			this.setLevel(2);
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().addLevel(-1);
	}
}