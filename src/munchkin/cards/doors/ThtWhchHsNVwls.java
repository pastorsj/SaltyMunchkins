package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.api.IHand;
import munchkin.cards.doors.api.AbstractMonster;
import munchkin.game.Game;

import java.util.List;

public class ThtWhchHsNVwls extends AbstractMonster {
	
	@Override
	public void cardInPlay() {
		//do nothing if the player level is <= 4
		if (this.getOwner().getPlayerLevel() <= 4) {
			return;
		}else{
			this.setLevel(18);
			this.setTreasures(5);
		}
	}

	@Override
	public void badStuff() {
		// removes all cards in hand
		IHand hand = this.getOwner().getHand();
		List<ICard> cards= hand.getCards();
		while(cards.iterator().hasNext()){
			hand.removeCardFromHand(cards.iterator().next());
		}
	}
}