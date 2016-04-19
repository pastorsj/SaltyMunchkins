package munchkin.api;

import munchkin.cards.treasures.api.ArmorSet;
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
    public void addLevel(int level);
    public void addTreasures(int numTreasures);
    public int getNumTreasures();
	public ArmorSet getArmorSet();
    public void setName(String name);
    public String getName();
    public void setGender(String gender);
    public String getGender();
    public void setCombatLevel();
    public void addToCombatLevel(int levels);
    public int getCombatLevel();
    public int getRunAwayLevel();
    public void addToRunAwayLevel(int levels);
    public boolean isAlive();
    public void sellGold(ICard card);
}
