package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class AughostDerwraith extends AbstractMonster {

	@Override
	public void cardInHand() {
	}

	@Override
	public void cardInPlay() {
		this.setTreasures(1);
		this.setLevel(2);
		// If owner is the only munchkin fighting the monster
		if (this.getOwner().getFaction().equals(Faction.MonsterWhacker)) {
			this.setLevel(5);
		}
	}

	@Override
	public void badStuff() {
		if (this.getOwner().getFaction() != Faction.Cultist) {
			this.getOwner().setFaction(Faction.UNAFFILIATED);
		}
	}
}