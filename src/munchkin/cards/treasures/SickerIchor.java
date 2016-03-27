package munchkin.cards.treasures;

import munchkin.api.CardType;
import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class SickerIchor extends AbstractTreasure {

    public SickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(100);
        this.setCardType(CardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        //+2 to either side, depending on users choice
    }
}