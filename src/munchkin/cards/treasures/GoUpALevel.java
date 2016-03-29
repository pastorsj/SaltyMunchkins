package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class GoUpALevel extends Treasure {

    public GoUpALevel(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        increaseLevel();
        this.action.setValue("Go up a Level!");
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard(true);
    }

    public void increaseLevel() {
        this.getOwner().addToPlayerLevel(1);
    }
}
