package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class ShogGoth extends AbstractMonster {

	@Override
	public void cardInPlay() {
		this.setLevel(16);
		if(this.getOwner().getFaction().equals(Faction.Investigator)) {
			this.setLevel(14);
		}
		if(this.getOwner().getPlayerLevel()<=3) {
			this.getOwner().addToRunAwayLevel(10000);
		}
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.getOwner().addTreasures(4);
			this.getOwner().addLevel(2);
		} else {
			this.badStuff();
		}
	}

	@Override
	public void badStuff() {
		this.getOwner().setFaction(Faction.Cultist);
	}
}