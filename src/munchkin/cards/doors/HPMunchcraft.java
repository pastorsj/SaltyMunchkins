package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class HPMunchcraft extends AbstractMonster {

	@Override
	public void cardInPlay() {
		if(this.getOwner().getFaction().equals(Faction.Investigator)) {
			this.setLevel(9);
		}
		else{
			this.setLevel(6);
		}
		this.action.setValue("From meeting HP Munchcraft, you are now a Cultist no matter if you win or not");
		this.getOwner().setFaction(Faction.Cultist);
		this.addTreasures(2);
	}

	@Override
	public void badStuff() {
		//Nothing, you are just a cultist
	}
}