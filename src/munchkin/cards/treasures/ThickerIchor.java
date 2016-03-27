package munchkin.cards.treasures;

import munchkin.api.CardType;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class ThickerIchor extends Treasure {

    public ThickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
        this.setCardType(CardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        //If played with any other ichor card, the other ichor effect is doubled
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }
}