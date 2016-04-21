package munchkin.api;

import munchkin.cards.treasures.api.ArmorSet;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 3/25/16.
 */
public class Player implements IPlayer{
    private Faction faction;
    private IHand hand;
    private ArmorSet armorSet;
    private String name;
    private String gender;
    private boolean alive = true;
    //Not sure if this field is necessary
    private int treasures;
    //-----------------------------------
    private int level;
    private int combatLevel;
    private int runAwayLevel;
    
    public Player() {
        this.faction = Faction.UNAFFILIATED;
        this.hand = new Hand(this);
        this.level = 0;
        this.treasures = 0;
        this.armorSet = new ArmorSet();
        this.name = "";
        this.gender = "";
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
    public void addCardToHand(ICard card){
    	this.hand.insertCard(card);
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
    public void addLevel(int level) {
        this.level += level;
    }

    @Override
    public void addTreasures(int numTreasures) {
        this.treasures += numTreasures;
    }

    @Override
    public int getNumTreasures() {
        return this.treasures;
    }

    @Override
	public ArmorSet getArmorSet() {
		return armorSet;
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
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public void setCombatLevel() {
        this.combatLevel = this.getPlayerLevel();
    }

    @Override
    public void addToCombatLevel(int levels) {
        System.err.println("Added " + levels + " to combat level");
        this.combatLevel += levels;
    }

    @Override
    public int getCombatLevel() {
        return this.combatLevel;
    }

    @Override
    public int getRunAwayLevel() {
        return this.runAwayLevel;
    }

    @Override
    public void addToRunAwayLevel(int levels) {
        this.runAwayLevel += levels;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    
    @Override
    public void sellGold(ICard card) {
//        		myGame.currentPlayer.goldSold += myGame.ic.getCardHash().get(cardToSell).numGold;
//        		myGame.currentPlayer.pHand.remove(cardToSellPos);
//        		myGame.currentPlayer.pDiscard.add(cardToSell);
//
//        		int levelBonus = myGame.currentPlayer.goldSold;
//        		int divis = (int) levelBonus / 1000;
//        		myGame.currentPlayer.pLevel += (int) levelBonus / 1000;
//        		System.out.println("level bonus is: " + divis);
    }

}
