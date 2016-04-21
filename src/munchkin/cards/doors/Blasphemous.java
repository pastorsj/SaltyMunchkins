package munchkin.cards.doors;

import munchkin.cards.doors.api.MonsterEnhancer;
import munchkin.game.Game;

public class Blasphemous extends MonsterEnhancer {

	public Blasphemous(Game game){
		super(game);
	}

	@Override
	public void cardInPlay() {
		//If player chooses to play card on cultist for permanent +3 bonus
		playOnCultistPlayer();
		//Else
		this.addToMonsterLevel(3);
	}

	private void playOnCultistPlayer() {

	}
}