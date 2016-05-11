package munchkin.cards.doors;

import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class CurseAmnesia extends AbstractCurse {

	public CurseAmnesia(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		IPlayer playedOn = this.game.getOtherPlayer();
		if(playedOn.getFaction().equals(Faction.UNAFFILIATED)){
			playedOn.addLevel(-1);
		}else{
			playedOn.setFaction(Faction.UNAFFILIATED);
		}
	}
}