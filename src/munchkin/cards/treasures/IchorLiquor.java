package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class IchorLiquor extends Treasure {

    public IchorLiquor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(3);
        //Bonus is applied to either the player or monster
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }
}