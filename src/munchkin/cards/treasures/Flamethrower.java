package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;

public class Flamethrower extends Treasure {

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