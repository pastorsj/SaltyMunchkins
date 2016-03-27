package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class OfficialMythos extends AbstractTreasure {

    public OfficialMythos(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        //If a player has played an armor that has hands, play this on top of it
        this.setBonus(2);
    }

    @Override
    public void cardPlayed(boolean win) {
        //If the card that it is played with is lost, this card is discarded as well
    }
}