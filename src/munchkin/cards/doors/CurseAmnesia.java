package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Faction;

public class CurseAmnesia extends AbstractCurse {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		if(this.getOwner().getFaction()==Faction.UNAFFILIATED || this.getOwner().getFaction()==null){
			this.getOwner().addLevel(-1);
		}else{
			this.getOwner().setFaction(Faction.UNAFFILIATED);
		}
	}

	@Override
	public void cardPlayed(boolean win) {
		
	}
}