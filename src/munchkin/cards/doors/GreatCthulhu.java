package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class GreatCthulhu extends AbstractMonster {

	@Override
	public void cardInPlay() {
		if(!this.getOwner().getFaction().equals(Faction.Cultist)) {
			this.setLevel(24);
		} else {
			this.setLevel(20);
		}
		this.addTreasures(5);
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.getOwner().addTreasures(this.getTreasures());
			this.getOwner().addLevel(2);
		} else {
			this.badStuff();
		}
	}

	@Override
	public void badStuff() {
		//Since this is a two player game, it just ends
		this.action.setValue("You were killed by Great Cthulhu! Game over");
		this.getOwner().kill();
	}
}