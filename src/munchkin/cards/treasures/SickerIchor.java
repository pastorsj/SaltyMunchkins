package munchkin.cards.treasures;

import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class SickerIchor extends Treasure {

    public SickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(100);
        this.setCardType(SpecificCardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        //+2 to either side, depending on users choice
    }
}