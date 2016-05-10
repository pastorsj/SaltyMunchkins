package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class Cultist extends Door {

	private Game game;

	public Cultist(Game game) {
		super(game);
		this.game = game;
	}

	@Override
	public void cardInPlay() {
		this.getOwner().setFaction(Faction.Cultist);
		//not sure if this is treated as a monster level or a combat bonus
		if(this.game.getCurrentPlayer().getFaction().equals(Faction.Cultist) 
				&& this.game.getOtherPlayer().getFaction().equals(Faction.Cultist)){
			this.setLevel(2);
		}
	}
}