package munchkin.api;

import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 3/25/16.
 */
public interface IPlayer {

    public Faction getFaction();
    public void setFaction(Faction faction);
    public IHand getHand();
    public void setHand(IHand hand);
    public int getPlayerLevel();
    public void addToPlayerLevel(int level);
    public void addTreasures(int numTreasures);
    public int getNumTreasures();
    public String getGender();
    public void setGender(String gender);
    public void setName(String name);
    public String getName();
    public void setCombatLevel();
    public int getCombatLevel();
    public int getRunAwayLevel();
    public void addToRunAwayLevel(int levels);
}
