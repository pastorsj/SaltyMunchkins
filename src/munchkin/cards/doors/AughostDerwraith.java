package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class AughostDerwraith extends AbstractMonster {
	
	@Override
	public void beforeCombat() {
		//If player is monster whacker, +3 to level
	}

	@Override
	public void duringCombat() {
		
	}

	@Override
	public void afterCombat(boolean win) {
		if(win) {
			this.addTreasures(1);			
		} else {
			//Lose your classes
			//This means we need some sort of access to the Game state or to the players hand
		}
	}
}