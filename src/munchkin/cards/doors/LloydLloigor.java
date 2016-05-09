package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class LloydLloigor extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setTreasures(2);
		this.setLevel(8);
		if(this.getOwner().getFaction().equals(Faction.Cultist)) {
			this.setLevel(6);
		}
	}

	@Override
	public void badStuff() {
		this.action.setValue("You lost! As a result, you lose two levels");
		this.getOwner().addLevel(-2);
	}
}