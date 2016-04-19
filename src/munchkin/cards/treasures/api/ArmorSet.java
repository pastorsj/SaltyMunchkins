package munchkin.cards.treasures.api;

import munchkin.api.ICard;
import munchkin.game.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Action action;

    private Map<Armor, Integer> armourToInteger;

    public ArmorSet() {
        this.footgear = new ArrayList<>();
        this.headgear = new ArrayList<>();
        this.armor = new ArrayList<>();
        this.hands = new ArrayList<>();
        this.maxFootGear = 1;
        this.maxHeadGear = 1;
        this.maxArmor = 1;
        this.maxHands = 2;
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

	public void addFootGear(ITreasure card) {
        if(card.getArmor().equals(Armor.FootGear)) {
            if(this.footgear.size() < maxFootGear) {
                this.footgear.add(card);
            } else {
                this.action.setValue("Already at max armor for footgear");
            }
        } else {
            this.action.setValue("Not Footgear armor");
        }
    }

    public void addHeadGear(ITreasure card) {
        if(card.getArmor().equals(Armor.HeadGear)) {
            if(this.headgear.size() < maxHeadGear) {
                this.headgear.add(card);
            } else {
                this.action.setValue("Already at max armor for headgear");
            }
        } else {
            this.action.setValue("Not HeadGear armor");
        }
    }

    public void addArmor(ITreasure card) {
        if(card.getArmor().equals(Armor.Armor)) {
            if(this.armor.size() < maxArmor) {
                this.armor.add(card);
            } else {
                this.action.setValue("Already at max armor for armor");
            }
        } else {
            this.action.setValue("Not armor type");
        }
    }

    public void addHands(ITreasure card) {
        if(card.getArmor().equals(Armor.OneHand)) {
            if(this.hands.size() < maxHands) {
                this.hands.add(card);
            } else {
                this.action.setValue("Already at max armor for hands");
            }
        } else if(card.getArmor().equals(Armor.TwoHands)) {
            if(this.hands.size() < maxHands - 1) {
                this.hands.add(card);
            } else {
                this.action.setValue("Either you are at max armor for hand gear or you are attempting to add a piece of two handed armor to an already equipped one handed piece");
            }
        } else {
            this.action.setValue("Not Footgear armor");
        }
    }

    public void setMaxFootGear(int max) {
        this.maxFootGear = max;
    }

    public void setMaxHeadGear(int max) {
        this.maxFootGear = max;
    }

    public void setMaxArmor(int max) {
        this.maxFootGear = max;
    }

    public void setMaxHands(int max) {
        this.maxFootGear = max;
    }

    public boolean checkArmor(ICard card) {
        //TODO: This makes sure that I can add this card to the armor set (for hand in play)

        //		int curHandLevel = 0;
        //		int curFootLevel = 0;
        //		int curHeadLevel = 0;
        //		int curArmorLevel = 0;
        //		for (int i = 0; i < myGame.currentPlayer.pPlay.size(); i++) {
        //			curHandLevel += myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numHands;
        //			curFootLevel += myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numFoot;
        //			curHeadLevel += myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numHead;
        //			curArmorLevel += myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numArmor;
        //		}
        //		if (curHandLevel > 2 || curFootLevel > 1 || curHeadLevel > 1 || curArmorLevel > 1) {
        //			CardFunc cf = new CardFunc(myGame);
        //			cf.cantPlay();
        return true;
    }

}
