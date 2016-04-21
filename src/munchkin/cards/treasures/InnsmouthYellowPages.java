package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class InnsmouthYellowPages extends Treasure {

    public InnsmouthYellowPages(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
    }

    @Override
    public void cardInPlay() {
        //Implement functionality
    }
}