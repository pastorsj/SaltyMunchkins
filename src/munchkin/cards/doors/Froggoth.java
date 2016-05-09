package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class Froggoth extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setTreasures(3);
		if(this.getOwner().getFaction().equals(Faction.MonsterWhacker)) {
			this.setLevel(10);
		} else {
			this.setLevel(12);
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().kill();
	}
}