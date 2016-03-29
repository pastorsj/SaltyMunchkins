package munchkin.api;

import munchkin.cards.treasures.api.ArmorSet;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;

import java.util.Iterator;

/**
 * Created by SamPastoriza on 3/25/16.
 */
public class AbstractPlayer implements IPlayer{
    private Faction faction;
    private IHand hand;
    private ArmorSet armorSet;
    private String name;
    private int level;
    private int treasures;
    private String gender;
    private int combatLevel;
    private int runAwayLevel;

    public AbstractPlayer() {
        this.faction = null;
        this.hand = new Hand(this);
        this.level = 0;
        this.treasures = 0;
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
    public int getPlayerLevel() {
        return level;
    }

    @Override
    public void addToPlayerLevel(int level) {
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

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCombatLevel() {
        return this.combatLevel;
    }

    @Override
    public void setCombatLevel() {
        Iterator<ICard> iter = this.hand.iterator();
        while(iter.hasNext()) {
            ICard card = iter.next();
            if(card.getClass().equals(Treasure.class)) {
                System.out.println("Treasure");
                Treasure treasureCard = (Treasure) card;
                this.combatLevel += treasureCard.getBonus();
            }
        }
        System.out.println("The players combat level is " + this.combatLevel);
    }

    @Override
    public int getRunAwayLevel() {
        return this.runAwayLevel;
    }

    @Override
    public void addToRunAwayLevel(int levels) {
        this.runAwayLevel += levels;
    }
}
