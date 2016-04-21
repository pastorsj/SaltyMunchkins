package munchkin.cards.doors.api;

import munchkin.api.ICard;

/**
 * Created by SamPastoriza on 3/27/16.
 */
public interface IDoor extends ICard {
    public void setLevel(int level);
    public void setTreasures(int treasures);
    public int getTreasures();
    public int getLevel();
    public void addTreasures(int numTreasures);
}
