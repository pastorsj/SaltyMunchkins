package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class CultMembershipCard extends AbstractTreasure {

	public CultMembershipCard(Game game) {
		super(game);
	}

	@Override
	public void cardInHand() {
		this.setGold(100);
		//if p1 a cultist, this card is not usable
		//this.disable();
	}

	@Override
	public void cardInPlay() {
		//Become a cultist
	}
}