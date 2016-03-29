package munchkin.cards.treasures;

import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class KickerIchor extends Treasure {

    public KickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
        this.setCardType(SpecificCardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        tripleCombatBonusForFootgear();
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }

    private void tripleCombatBonusForFootgear() {
        //Combat bonus triples for all footgear
    }
}