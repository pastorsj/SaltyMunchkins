package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Necrocomicon extends Treasure {

    public Necrocomicon(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(100);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(1);
        this.setArmor(Armor.OneHand);
    }
}