package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Faction;

public class CurseHairTurnsWhiteWithHorror extends AbstractCurse {

	@Override
	public void cardInPlay() {
		//Discard all your classes except Cultist
		if(!this.getOwner().getFaction().equals(Faction.Cultist)){
			this.getOwner().setFaction(Faction.UNAFFILIATED);
		}
	}

}