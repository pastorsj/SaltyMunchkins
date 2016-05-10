package munchkin.cards.doors;

import munchkin.cards.doors.api.MonsterEnhancer;
import munchkin.game.Game;

public class AndItsSpawn extends MonsterEnhancer {

    public AndItsSpawn(Game game){
        super(game);
    }

    @Override
    public void cardInHand() {
        this.addToMonsterLevel(5);
    }

    @Override
    public void cardPlayed(boolean win) {
        if (win) {
            this.setTreasures(1);
        }
        this.setDiscard();
    }
}