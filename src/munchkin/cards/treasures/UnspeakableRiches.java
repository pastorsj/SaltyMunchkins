package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class UnspeakableRiches extends AbstractTreasure {

    public UnspeakableRiches(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        //Draw three treasure cards, if face down, stay face down, otherwise they are face up
    }
}