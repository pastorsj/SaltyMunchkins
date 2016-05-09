package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class EldridgeHawrer extends AbstractMonster {

	@Override
	public void cardInPlay() {
		if(this.getOwner().getFaction().equals(Faction.Investigator)) {
			this.setLevel(3);
		} else {
			this.setLevel(1);
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().addGoldToDiscard(500);
	}
}