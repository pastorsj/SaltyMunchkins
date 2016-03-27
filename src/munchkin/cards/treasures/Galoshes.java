package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class Galoshes extends AbstractTreasure {

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