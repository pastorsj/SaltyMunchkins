package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class SuddenHeadBlow extends Door {


	public SuddenHeadBlow(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		//Applied to the other played
		if(this.game.getOtherPlayer().getFaction().equals(Faction.Cultist)) {
			this.game.getOtherPlayer().setFaction(Faction.UNAFFILIATED);
		} else {
			this.game.getOtherPlayer().setFaction(Faction.Cultist);
		}
	}
}