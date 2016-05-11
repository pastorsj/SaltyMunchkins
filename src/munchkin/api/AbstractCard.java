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
    private boolean discard = false;

    public AbstractCard() {
        this.disabled = false;
        this.ownedBy = null;
        this.type = null;
        this.action = Action.getInstance();
    }

    @Override
    public void setCardType(SpecificCardType type) {
        this.type = type;
    }

    @Override
    public SpecificCardType getSpecificCardType() {
        return this.type;
    }

    @Override
    public void disable() {
        this.disabled = true;
    }

    @Override
    public void enable() {
        this.disabled = false;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }

    @Override
    public void setOwner(IPlayer player) {
        this.ownedBy = player;
    }

    @Override
    public IPlayer getOwner() {
        return this.ownedBy;
    }

    @Override
    public void setCardType(CardType type) {
        this.cardType = type;
    }

    @Override
    public CardType getCardType() {
        return this.cardType;
    }

    @Override
    public String getName() {
    	String canonicalName = this.getClass().getCanonicalName();
        return canonicalName.substring(canonicalName.lastIndexOf(".")+1);
    }

    @Override
    public void setDiscard() {
        this.discard = true;
    }

    @Override
    public boolean checkDiscard() {
        return this.discard;
    }
    
    public Action getAction(){
    	return this.action;
    }
}
