package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class CannedMeat extends Treasure {

	public CannedMeat(Game game) {
		super(game);
	}

	@Override
	public void cardInHand() {
		this.setGold(100);
	}

	@Override
	public void cardInPlay() {
		//TODO: Add action saying this card sets the bonus to the current player, not the monster
		this.setBonus(3);
	}

	@Override
	public void cardPlayed(boolean win) {
		this.setDiscard();
	}
}