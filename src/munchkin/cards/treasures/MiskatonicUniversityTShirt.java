package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class MiskatonicUniversityTShirt extends AbstractTreasure {

    public MiskatonicUniversityTShirt(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(100);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.Armor);
        this.setBonus(1);
    }

    @Override
    public void cardPlayed(boolean win) {
        if(!win) {
            this.setDiscard(true);
        }
    }
}