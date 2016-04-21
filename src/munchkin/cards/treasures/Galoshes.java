package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Galoshes extends Treasure {

    public Galoshes(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.FootGear);
        this.setBonus(2);
    }

    @Override
    public void cardPlayed(boolean win) {
        if(!win) {
            //Player loses galoshes, not other footgear
        }
    }
}