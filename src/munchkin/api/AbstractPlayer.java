package munchkin.api;

import munchkin.cards.treasures.api.ArmorSet;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 3/25/16.
 */
public class AbstractPlayer implements IPlayer{
    private Faction faction;
    private IHand hand;
    private ArmorSet armorSet;
    private int level;
    private int treasures;
    
    public AbstractPlayer() {
        this.faction = null;
        this.hand = new Hand(this);
        this.level = 0;
        this.treasures = 0;
        this.armorSet = new ArmorSet();
    }


    @Override
    public Faction getFaction() {
        return this.faction;
    }

    @Override
    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    @Override
    public IHand getHand() {
        return this.hand;
    }

    @Override
    public void setHand(IHand hand) {
        this.hand = hand;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void addLevel(int level) {
        this.level += level;
    }

    @Override
    public void addTreasures(int numTreasures) {
        this.treasures += treasures;
    }

    @Override
    public int getNumTreasures() {
        return this.treasures;
    }


	public ArmorSet getArmorSet() {
		return armorSet;
	}

}
