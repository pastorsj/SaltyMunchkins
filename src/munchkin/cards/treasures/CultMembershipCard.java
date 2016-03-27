package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class CultMembershipCard extends Treasure {

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