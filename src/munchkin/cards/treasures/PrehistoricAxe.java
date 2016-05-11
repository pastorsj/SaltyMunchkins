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
        this.setArmor(Armor.OneHand);
    }

    @Override
    public void cardInPlay() {
        if(this.game.getCombat().getMonsterLevel()>15) {
            //If level of monster is greater than level 15
            this.setBonus(5);
        } else {
            this.setBonus(2);
        }
    }
}