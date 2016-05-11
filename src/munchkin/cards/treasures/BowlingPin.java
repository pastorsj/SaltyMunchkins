package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

public class BowlingPin extends Treasure {

    public BowlingPin() {
        super();
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
        this.setArmor(Armor.OneHand);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(2);
    }
}