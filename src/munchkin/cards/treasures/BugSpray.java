package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;

public class BugSpray extends AbstractTreasure {

	public BugSpray() {
		super();
	}

	@Override
	public void cardInHand() {
		this.setGold(200);
	}

	@Override
	public void cardInPlay() {
		this.setArmor(Armor.OneHand);
		this.setBonus(2);
	}
}