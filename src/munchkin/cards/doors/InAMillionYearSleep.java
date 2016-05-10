package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;
import munchkin.cards.doors.api.MonsterEnhancer;
import munchkin.game.Game;

public class InAMillionYearSleep extends MonsterEnhancer {

	public InAMillionYearSleep(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		this.addToMonsterLevel(-5);
	}

	@Override
	public void cardPlayed(boolean win) {
		if(win) {
			this.addTreasures(-1);
			if(this.getTreasures()<1) {
				this.setTreasures(1);
			}
		}
	}
}