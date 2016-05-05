package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class CampusCrusadeforCthulhu extends AbstractMonster {

	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		// Level 6;
		// -2 against Professor; +2 against Cultists
		if (this.getOwner().getFaction().equals(Faction.Professor)) {
			this.setLevel(4);
		} else if (this.getOwner().getFaction().equals(Faction.Cultist)) {
			this.setLevel(8);
		} else {
			this.setLevel(6);
		}
		this.setTreasures(2);
	}

	@Override
	public void badStuff() {
		this.getOwner().setFaction(Faction.Cultist);
	}
}