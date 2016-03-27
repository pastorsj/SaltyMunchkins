package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class CthulhuBumperSticker extends Treasure {

	public CthulhuBumperSticker(Game game) {
		super(game);
	}

	@Override
	public void cardInHand() {
		this.setGold(100);
	}

	@Override
	public void cardInPlay() {
		// Bonus can be applied to player or monster
		this.setBonus(3);
	}
}