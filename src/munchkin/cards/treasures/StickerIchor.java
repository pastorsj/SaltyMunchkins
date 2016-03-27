package munchkin.cards.treasures;

import munchkin.api.CardType;
import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class StickerIchor extends AbstractTreasure {

    public StickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
        this.setCardType(CardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(4);
        //Either side of combat
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }
}