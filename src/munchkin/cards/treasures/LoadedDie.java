package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class LoadedDie extends AbstractTreasure {

    public LoadedDie(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
    }

    @Override
    public void cardInPlay() {
        //Essentially, you reroll the die, and input a number 1-6 and replay the turn
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }
}