package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class WishingRing extends AbstractTreasure {

    public WishingRing(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(500);
    }

    @Override
    public void cardInPlay() {
        //Cancels any curse
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }
}