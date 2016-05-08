package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Faction;

public class CurseAmnesia extends AbstractCurse {

	@Override
	public void cardInPlay() {
		if(this.getOwner().getFaction()==Faction.UNAFFILIATED || this.getOwner().getFaction().equals(Faction.UNAFFILIATED)){
			this.getOwner().addLevel(-1);
		}else{
			this.getOwner().setFaction(Faction.UNAFFILIATED);
		}
	}
}