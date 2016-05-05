package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class Coggoth extends AbstractMonster {

	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		int numSize = this.getOwner().getHand().getCards().size();
		if (numSize % 2 == 0) {
			this.setLevel(11);
		} else {
			this.setLevel(8);
		}
		this.setTreasures(2);
	}

	@Override
	public void badStuff() {
		// lose two levels
		this.getOwner().addLevel(-2);
	}

}