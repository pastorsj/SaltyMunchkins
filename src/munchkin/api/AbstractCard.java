package munchkin.api;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public abstract class AbstractCard implements ICard{
    private boolean disabled;
    private IPlayer ownedBy;
    private CardType type;

    public AbstractCard() {
        this.disabled = false;
        this.ownedBy = null;
        this.type = null;
    }

    public void setCardType(CardType type) {
        this.type = type;
    }

    public CardType getCardType() {
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
}
