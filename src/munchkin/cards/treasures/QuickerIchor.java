package munchkin.cards.treasures;

import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class QuickerIchor extends Treasure {

    public QuickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
        this.setCardType(SpecificCardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        //Set run away bonus to + - 2, depending on the user
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }
}