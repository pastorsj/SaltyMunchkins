package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class Ruggoth extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setTreasures(1);
		this.setLevel(2);
	}

	@Override
	public void badStuff() {
		this.getOwner().setFaction(Faction.Cultist);
	}
}