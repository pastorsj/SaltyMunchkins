package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class CowlofCthulhu extends AbstractTreasure {

	public CowlofCthulhu(Game game) {
		super(game);
	}

	@Override
	public void cardInHand() {
		this.setGold(0);
	}

	@Override
	public void cardInPlay() {
//		If player has a steed or vehicle in play, bonus is +3, else +2
//		if(p1.hand.contains('steed')) {
//			this.setBonus(2);
//		} else {
//			this.setBonus(3);
//		}
	}
}