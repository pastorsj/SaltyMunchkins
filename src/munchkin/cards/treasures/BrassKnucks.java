package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

public class BrassKnucks extends Treasure {

    public BrassKnucks() {
        super();
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
        this.setBonus(1);
        this.setArmor(Armor.TwoHands);
    }
}