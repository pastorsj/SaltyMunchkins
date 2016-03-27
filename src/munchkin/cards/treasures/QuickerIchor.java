package munchkin.cards.treasures;

import munchkin.api.CardType;
import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class QuickerIchor extends AbstractTreasure {

    public QuickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
        this.setCardType(CardType.Ichor);
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