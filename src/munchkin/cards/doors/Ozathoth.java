package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class Ozathoth extends AbstractMonster {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		this.setTreasures(5);
		if(this.getOwner().getPlayerLevel() <= 4) {
			//If the player has a player level less than 4, the monster will not pursue
			this.getOwner().addToRunAwayLevel(10000);
		}
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.getOwner().addTreasures(5);
			this.getOwner().addLevel(2);
		} else {
			this.badStuff();
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().kill();
	}
}