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
		if(this.game.getCurrentPlayer().equals(this.getOwner())) {
			if(this.game.getOtherPlayer().getFaction().equals(Faction.Cultist)) {
				this.getOwner().addToCombatLevel(2);
			}
		} else {
			if(this.game.getCurrentPlayer().getFaction().equals(Faction.Cultist)) {
				this.getOwner().addToCombatLevel(2);
			}
		}
	}
}