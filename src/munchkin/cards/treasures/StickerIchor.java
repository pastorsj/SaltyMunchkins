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
        this.action.setValue("A bonus of 4 was applied during combat");
        this.setBonus(4);
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
    }
}