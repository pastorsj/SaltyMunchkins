package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;

public class CurseHairTurnsWhiteWithHorror extends AbstractCurse {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		//Discard all your classes except Cultist
		if(!this.getOwner().getFaction().equals(Faction.Cultist)){
			this.getOwner().setFaction(null);
		}
	}

	@Override
	public void cardPlayed(boolean win) {
		
	}
}