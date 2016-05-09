package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class ShrubNiggurath extends AbstractMonster {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		this.setTreasures(4);
		if(this.getOwner().getPlayerLevel()<=3) {
			this.getOwner().addToRunAwayLevel(10000);
		}
		this.setLevel(16);
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.getOwner().addTreasures(this.getTreasures());
			this.getOwner().addLevel(2);
		} else {
			this.badStuff();
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().addLevel(-3);
		this.getOwner().getArmorSet().removeFootgear();
	}
}