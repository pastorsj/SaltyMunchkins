package munchkin.api;

import munchkin.game.Action;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public abstract class AbstractCard implements ICard{
    private boolean disabled;
    private IPlayer ownedBy;
    private SpecificCardType type;
    private CardType cardType;
    public Action action;


    public AbstractCard() {
        this.disabled = false;
        this.ownedBy = null;
        this.type = null;
        this.action = Action.getInstance();
    }

    public void setCardType(SpecificCardType type) {
        this.type = type;
    }

    public SpecificCardType getSpecificCardType() {
        return this.type;
    }

    public void disable() {
        this.disabled = true;
    }

    public void enable() {
        this.disabled = false;
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setOwner(IPlayer player) {
        this.ownedBy = player;
    }

    public IPlayer getOwner() {
        return this.ownedBy;
    }

    public void setCardType(CardType type) {
        this.cardType = type;
    }

    public CardType getCardType() {
        return this.cardType;
    }
}
