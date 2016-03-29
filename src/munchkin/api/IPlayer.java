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
    public int getLevel();
    public void addLevel(int level);
    public void addTreasures(int numTreasures);
    public int getNumTreasures();
	public ArmorSet getArmorSet();
}
