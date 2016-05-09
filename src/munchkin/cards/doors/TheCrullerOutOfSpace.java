package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class TheCrullerOutOfSpace extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setTreasures(2);
		this.setLevel(4);
		if(this.getOwner().getFaction().equals(Faction.MonsterWhacker)) {
			this.setLevel(10);
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().getArmorSet().removeHeadgear();
		this.getOwner().getArmorSet().removeFootgear();
	}
}