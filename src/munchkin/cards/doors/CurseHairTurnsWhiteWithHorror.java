package munchkin.cards.doors;

import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class CurseHairTurnsWhiteWithHorror extends AbstractCurse {

	public CurseHairTurnsWhiteWithHorror(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		//Discard all your classes except Cultist
		IPlayer playedOn = this.game.getOtherPlayer();
		if(!playedOn.getFaction().equals(Faction.Cultist)){
			playedOn.setFaction(Faction.UNAFFILIATED);
		}
		this.setDiscard();
	}

}