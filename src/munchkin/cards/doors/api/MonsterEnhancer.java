package munchkin.cards.doors.api;

import munchkin.api.SpecificCardType;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 3/27/16.
 */
public class MonsterEnhancer extends Door {

    public MonsterEnhancer(Game game) {
        super(game);
    }

    public void addToMonsterLevel(int levels) {
        this.setLevel(this.getLevel() + levels);
    }

    @Override
    public void setCardType() {
        this.setCardType(SpecificCardType.MonsterEnhancer);
    }
}
