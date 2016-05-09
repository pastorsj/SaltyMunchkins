package munchkin.cards.doors;

import munchkin.cards.doors.api.MonsterEnhancer;
import munchkin.game.Game;

public class FourDimensional extends MonsterEnhancer {

	public FourDimensional(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		this.addToMonsterLevel(10);
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.addTreasures(2);
		}
	}
}