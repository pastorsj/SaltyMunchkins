package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class FakeTentacle extends AbstractTreasure {

    public FakeTentacle(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.HeadGear);
        //Set Run Away Bonus to 1
    }
}