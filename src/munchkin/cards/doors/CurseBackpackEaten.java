package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.api.IHand;
import munchkin.cards.doors.api.AbstractCurse;

public class CurseBackpackEaten extends AbstractCurse {

	@Override
	public void cardInPlay() {
		IHand hand = this.getOwner().getHand();
		for(ICard card : hand.getCards()) {
			if(card.isDisabled()) {
				//Add actions for each card
				card.setDiscard();
			}
		}
		this.setDiscard();
	}
	
}