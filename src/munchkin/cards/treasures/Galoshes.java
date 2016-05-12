package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

public class Galoshes extends Treasure {

    @Override
    public void cardInHand() {
        this.setGold(300);
        this.setArmor(Armor.PseudoFootGear);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(1);
    }

    @Override
    public void cardPlayed(boolean win) {
        if(!win) {
            this.setDiscard();
        }
    }
}