package munchkin.cards.treasures;

import munchkin.game.Game;

public class SoleSurvivor extends GoUpALevel {

    public SoleSurvivor(Game game) {
        super(game);
    }

    @Override
    public void cardPlayed(boolean win) {
        //Go up another level if you participated in a combat and the other munchkins got bad stuff and you didn't
        if(win) { //And other munchkins get bad stuff
            this.increaseLevel();
        }

    }
}