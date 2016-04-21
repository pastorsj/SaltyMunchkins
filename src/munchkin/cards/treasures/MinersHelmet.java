package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

public class MinersHelmet extends Treasure {

    public MinersHelmet() {
        super();
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(2);
        this.setArmor(Armor.HeadGear);
    }
}