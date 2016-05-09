package munchkin.cards.doors;

import munchkin.cards.doors.api.MonsterEnhancer;
import munchkin.game.Game;

public class Rugose extends MonsterEnhancer{

    public Rugose(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        this.addToMonsterLevel(5);
    }

    @Override
    public void cardPlayed(boolean win) {
        if(win) {
            this.addTreasures(1);
        }
    }
}