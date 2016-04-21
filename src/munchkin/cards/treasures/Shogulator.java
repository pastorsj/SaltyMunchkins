package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Shogulator extends Treasure {

    public Shogulator(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(600);
    }

    @Override
    public void cardInPlay() {
        //+10 against Shoggoth, Shog Goth
        //+5 against any other -goth
        //Otherwise, +2 bonus
        this.setBonus(2);
        this.setArmor(Armor.TwoHands);
    }
}