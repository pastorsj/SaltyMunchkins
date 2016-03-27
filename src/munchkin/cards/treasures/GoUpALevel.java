package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class GoUpALevel extends AbstractTreasure {

    public GoUpALevel(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
        increaseLevel();
    }

    public void increaseLevel() {
        this.getOwner().addLevel(1);
    }
}
