package munchkin.cards.treasures.api;

import munchkin.api.ICard;
import munchkin.game.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class ArmorSet {

    private List<ICard> footgear;
    private List<ICard> headgear;
    private List<ICard> armor;
    private List<ICard> hands;
    private int maxFootGear;
    private int maxHeadGear;
    private int maxArmor;
    private int maxHands;
    private int currentHands;
    private Action action;

    public ArmorSet() {
        this.footgear = new ArrayList<>();
        this.headgear = new ArrayList<>();
        this.armor = new ArrayList<>();
        this.hands = new ArrayList<>();
        this.maxFootGear = 1;
        this.maxHeadGear = 1;
        this.maxArmor = 1;
        this.maxHands = 2;
        this.currentHands = 0;
        this.action = Action.getInstance();
    }

    public List<ICard> getFootgear() {
        return footgear;
    }

    public void removeFootgear(){
        if(this.footgear.size()>0) {
            this.footgear.clear();
        }
    }

    public List<ICard> getHeadgear() {
        return headgear;
    }

    public void removeHeadgear(){
        if(this.headgear.size()>0) {
            this.headgear.clear();
        }
    }


    public List<ICard> getArmor() {
        return armor;
    }


    public void removeArmor(){
        if(this.armor.size()>0) {
            this.armor.clear();
        }
    }
    public List<ICard> getHands() {
        return hands;
    }

    public void removeHands(){
        this.hands.clear();
        this.currentHands = 0;
    }

    public void addFootGear(ITreasure card) {
        if(card.getArmor().equals(Armor.FootGear)) {
            if(canAddFoot()) {
                this.footgear.add(card);
            } else {
                this.action.setValue("Already at max armor for footgear");
            }
        } else if (card.getArmor().equals(Armor.PseudoFootGear)){
        	this.footgear.add(card);
        }
        else {
            this.action.setValue("Not Footgear armor");
        }
    }

    public void addHeadGear(ITreasure card) {
        if(card.getArmor().equals(Armor.HeadGear)) {
            if(canAddHead()) {
                this.headgear.add(card);
            } else {
                this.action.setValue("Already at max armor for headgear");
            }
        }else if(card.getArmor().equals(Armor.PseudoHeadGear)){
        	this.headgear.add(card);
        }
        else {
            this.action.setValue("Not HeadGear armor");
        }
    }

    public void addArmor(ITreasure card) {
        if(card.getArmor().equals(Armor.Armor)) {
            if(canAddArmor()) {
                this.armor.add(card);
            } else {
                this.action.setValue("Already at max armor for armor");
            }
        } else if(card.getArmor().equals(Armor.PseudoArmor)){
        	this.armor.add(card);
        }
        else {
            this.action.setValue("Not armor type");
        }
    }

    public void addHands(ITreasure card) {
        if(card.getArmor().equals(Armor.OneHand)) {
            if(canAddHands(0)) {
                this.hands.add(card);
                this.currentHands++;
            } else {
                this.action.setValue("Already at max armor for hands");
            }
        } else if(card.getArmor().equals(Armor.TwoHands)) {
            if(canAddHands(1)) {
                this.hands.add(card);
                this.currentHands+=2;
            } else {
                this.action.setValue("Either you are at max armor for hand gear or you are attempting to add a piece of two handed armor to an already equipped one handed piece");
            }
        } else if(card.getArmor().equals(Armor.PseudoHandGear)){
        	this.hands.add(card);
        }else {
            this.action.setValue("Not hands armor");
        }
    }

    public int getMaxFootGear() {
        return maxFootGear;
    }

    public int getMaxHeadGear() {
        return maxHeadGear;
    }

    public int getMaxArmor() {
        return maxArmor;
    }

    public int getMaxHands() {
        return maxHands;
    }

    public void setMaxFootGear(int max) {
        this.maxFootGear = max;
    }

    public void setMaxHeadGear(int max) {
        this.maxHeadGear = max;
    }

    public void setMaxArmor(int max) {
        this.maxArmor = max;
    }

    public void setMaxHands(int max) {
        this.maxHands = max;
    }

    private boolean canAddArmor(){
        return this.armor.size() < maxArmor;
    }

    private boolean canAddHands(int numHands){
        return this.currentHands < (maxHands-numHands);
    }

    private boolean canAddFoot(){
        return this.footgear.size() < maxFootGear;
    }

    private boolean canAddHead(){
        return this.headgear.size() < maxHeadGear;
    }


    public boolean checkArmor(ICard card) {
        //TODO: This makes sure that I can add this card to the armor set (for hand in play)
        if(card instanceof ITreasure) {
        	
            ITreasure armorCard = (ITreasure) card;
            int numHands = 0;

            Armor type = armorCard.getArmor();
            
            if (type == null){
        		return true;
        	}

            if(armorCard.getArmor().equals(Armor.TwoHands))
                numHands = 1;

            return ((type.equals(Armor.Armor) && canAddArmor()) || (type.equals(Armor.FootGear) &&canAddFoot()) ||
                    (type.equals(Armor.HeadGear) && canAddHead()) || ((type.equals(Armor.OneHand) || type.equals(Armor.TwoHands)) && canAddHands(numHands))
                    || (type.equals(Armor.PseudoArmor)) || (type.equals(Armor.PseudoFootGear)) || (type.equals(Armor.PseudoHandGear)) || (type.equals(Armor.PseudoHeadGear)));
        }

        return true;
    }
}