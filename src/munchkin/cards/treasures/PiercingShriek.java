package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class PiercingShriek extends Treasure {

    public PiercingShriek(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(2);
        //Usable by both sides
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
        //If player to the right has a lower level, he can take the card from the discard pile
    }
}