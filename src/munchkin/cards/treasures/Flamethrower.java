package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;

public class Flamethrower extends AbstractTreasure {

    public Flamethrower() {
        super();
    }

    @Override
    public void cardInHand() {
        this.setGold(800);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.TwoHands);
        this.setBonus(4);
//        this.setAttackType(AttackType.Flame);
    }
}