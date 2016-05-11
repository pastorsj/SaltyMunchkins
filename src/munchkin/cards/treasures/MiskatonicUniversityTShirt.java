package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class MiskatonicUniversityTShirt extends Treasure {

    public MiskatonicUniversityTShirt(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(100);
        this.setArmor(Armor.PseudoArmor);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(1);
    }
}