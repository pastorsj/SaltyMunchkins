package munchkin.cards.doors;

import munchkin.cards.doors.api.MonsterEnhancer;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class Unnameable extends MonsterEnhancer {

	public Unnameable(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		if (this.getOwner().getFaction().equals(Faction.Professor)) {
			this.addToMonsterLevel(10);
		} else {
			this.addToMonsterLevel(5);
		}
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win){
			this.addTreasures(1);
		}
	}
}