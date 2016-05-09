package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.api.IHand;
import munchkin.cards.doors.api.AbstractMonster;

public class GrapeOldOnes extends AbstractMonster {

	@Override
	public void cardInPlay() {
		if(this.getOwner().getGender().equals("Female")) {
			this.setLevel(10);
		} else {
			this.setLevel(12);
		}
		this.setTreasures(3);
	}

	@Override
	public void badStuff() {
		this.action.setValue("You have lost, your entire hand has been discarded");
		IHand hand = this.getOwner().getHand();
		for(ICard card : hand.getCards()) {
			card.setDiscard();
		}
	}
}