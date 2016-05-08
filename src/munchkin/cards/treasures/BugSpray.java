package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

public class BugSpray extends Treasure {

	public BugSpray() {
		super();
	}

	@Override
	public void cardInHand() {
		this.setGold(300);
		this.setArmor(Armor.OneHand);
		this.setBonus(2);
	}
}