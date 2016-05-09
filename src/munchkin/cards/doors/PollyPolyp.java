package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class PollyPolyp extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setTreasures(1);
		if(this.getOwner().getFaction().equals(Faction.Professor)) {
			this.setLevel(5);
		} else {
			this.setLevel(2);
		}
	}

	@Override
	public void badStuff() {
		this.action.setValue("You lose! Lose a Level");
		this.getOwner().addLevel(-1);
	}
}