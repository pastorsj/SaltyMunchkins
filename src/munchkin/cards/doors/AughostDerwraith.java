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
		//If owner is the only munchkin fighting the monster
		if(this.getOwner().getFaction().equals(Faction.MonsterWhacker)) {
			this.setLevel(5);
		}
	}

	@Override
	public void badStuff() {
		//If the owner was the only one fighting the monster and lost, he loses all of his classes
	}
}