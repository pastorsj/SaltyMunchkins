package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class CthulhuBumperSticker extends AbstractTreasure {

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