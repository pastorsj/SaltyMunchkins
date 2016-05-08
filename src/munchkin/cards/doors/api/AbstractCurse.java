package munchkin.cards.doors.api;

import munchkin.api.SpecificCardType;

public abstract class AbstractCurse extends Door {
    @Override
    public void setCardType() {
        this.setCardType(SpecificCardType.Curse);
    }
}
