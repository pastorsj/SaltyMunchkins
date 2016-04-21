package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class SolarEclipse extends Treasure {

    public SolarEclipse(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        //After a combat, all treasure cards that are face down are distributed evenly between the participants
        //The odd card goes to the owner
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
    }
}