package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class AndItsSpawn extends AbstractMonster {

    @Override
    public void cardInHand() {
        this.addLevels(5);
    }

    @Override
    public void cardPlayed(boolean win) {
        if (win) {
            this.addTreasures(1);
        }
    }
}