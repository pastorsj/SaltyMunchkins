package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;

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