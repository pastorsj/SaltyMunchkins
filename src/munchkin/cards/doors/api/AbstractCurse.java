package munchkin.cards.doors.api;

import munchkin.api.SpecificCardType;
import munchkin.game.Game;

public abstract class AbstractCurse extends Door {

    public AbstractCurse(Game game) {
        super(game);
    }

    @Override
    public void setCardType() {
        this.setCardType(SpecificCardType.Curse);
    }
}
