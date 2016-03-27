package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Necrotelecom extends Treasure {

    public Necrotelecom(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.HeadGear);
        this.setBonus(2);
    }
}