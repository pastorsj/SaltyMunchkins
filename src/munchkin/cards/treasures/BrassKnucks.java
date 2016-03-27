package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;

public class BrassKnucks extends AbstractTreasure {

    public BrassKnucks() {
        super();
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(1);
    }
}