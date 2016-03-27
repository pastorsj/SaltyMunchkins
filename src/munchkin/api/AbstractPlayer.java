package munchkin.api;

import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 3/25/16.
 */
public class AbstractPlayer implements IPlayer{
    private Faction faction;
    private IHand hand;
    private int level;


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
}
