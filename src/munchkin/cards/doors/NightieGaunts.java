package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class NightieGaunts extends AbstractMonster {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		this.setTreasures(4);
		if(this.getOwner().getGender().equals("Male")) {
			this.setLevel(17);
		} else {
			this.setLevel(14);
		}
	}

	@Override
	public void badStuff() {
		//TODO: Discard Three Items
	}
}