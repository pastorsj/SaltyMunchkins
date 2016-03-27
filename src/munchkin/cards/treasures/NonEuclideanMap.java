package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class NonEuclideanMap extends Treasure {

    public NonEuclideanMap(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
    }

    @Override
    public void cardInPlay() {
        //run away bonus += -1
    }

    @Override
    public void cardPlayed(boolean win) {
        if(win) {
            //Draw extra treasure
        }
    }
}