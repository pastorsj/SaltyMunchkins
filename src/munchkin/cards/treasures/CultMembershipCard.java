package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class CultMembershipCard extends AbstractTreasure {

	public CultMembershipCard(Game game) {
		super(game);
	}

	@Override
	public void cardInHand() {
		this.setGold(100);
		if(this.getOwner().getFaction().equals(Faction.Cultist)) {
			this.disable();
		}
	}

	@Override
	public void cardInPlay() {
		//Become a cultist
	}
}