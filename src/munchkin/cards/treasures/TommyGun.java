package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class TommyGun extends AbstractTreasure {

    public TommyGun(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(600);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.TwoHands);
        this.setBonus(4);
        //If you go by the name of Tom... read card
        //this.setBonus(5);
    }
}