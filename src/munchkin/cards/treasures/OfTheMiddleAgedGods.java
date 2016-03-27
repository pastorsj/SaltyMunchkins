package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class OfTheMiddleAgedGods extends AbstractTreasure {

    public OfTheMiddleAgedGods(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        //If a player has played a card with a combat bonus, play this on top of it
        //If a player has played a card with hand armor, there is now one less hand slot used
        this.setBonus(2);
    }

    @Override
    public void cardPlayed(boolean win) {
        //If the card that it is played with is lost, this card is discarded as well
    }
}