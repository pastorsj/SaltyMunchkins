package munchkin.api;

import munchkin.cards.doors.api.AbstractMonster;

/**
 * Created by SamPastoriza on 3/28/16.
 */
public interface ICombat {

    public void addMonsterToFight(AbstractMonster monster);
    public void addPlayerToFight(IPlayer player);
    public boolean resolveFight();
    public void runAway();
    public void resetCombat();
    public void finish();
    public boolean containsMonster();
    void cardPlayed(boolean win, IPlayer player);
}
