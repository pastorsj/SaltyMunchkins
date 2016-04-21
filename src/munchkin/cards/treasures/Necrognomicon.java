package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Necrognomicon extends Treasure {

    public Necrognomicon(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.OneHand);
        this.setBonus(2);
    }
}