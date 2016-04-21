package munchkin.cards.treasures;

import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class StickerIchor extends Treasure {

    public StickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
        this.setCardType(SpecificCardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(4);
        //Either side of combat
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
    }
}