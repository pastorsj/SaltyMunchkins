package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class PrehistoricAxe extends Treasure {

    public PrehistoricAxe(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(500);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.OneHand);
        //If level of monster is greater than level 15
        this.setBonus(5);
        //Else
        this.setBonus(2);
    }
}