package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class CthulhuBumperSticker extends Treasure {

	public CthulhuBumperSticker(Game game) {
		super(game);
	}

	@Override
	public void cardInHand() {
		this.setGold(0);
	}

	@Override
	public void cardInPlay() {
		this.setBonus(2);
	}
}