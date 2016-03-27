package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class SongofMadness extends AbstractTreasure {

    public SongofMadness(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(100);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(2);
        //Either side of combat
        //If played sings phrase, +5
        //Can't aid munchkins fighting, unless only one is fighting
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }
}