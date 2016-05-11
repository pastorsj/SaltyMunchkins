package munchkin.cards.treasures.api;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class GoUpALevel extends Treasure {

    public GoUpALevel() {
        super();
    }

    @Override
    public void cardInPlay() {
        increaseLevel();
        this.getOwner().addToCombatLevel(1);
        this.setDiscard();
        this.action.setValue("Go up a Level!");
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
    }

    public void increaseLevel() {
        this.getOwner().addToPlayerLevel(1);
    }
}
