package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class ShallowOnes extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setTreasures(2);
		this.setLevel(8);
		if(this.getOwner().getFaction().equals(Faction.Professor)) {
			this.setLevel(10);
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().kill();
	}
}