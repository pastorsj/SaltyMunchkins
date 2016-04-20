package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class KitchenSink extends Treasure {

    public KitchenSink(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
        //if p1 a cultist, this card is not usable
        //this.disable();
    }

    @Override
    public void cardInPlay() {
        this.setBonus(3);
        //Bonus for either side
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
    }

}