package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class AndItsSpawn extends AbstractMonster {

    @Override
    public void beforeCombat() {
        this.addLevels(5);
    }

    @Override
    public void afterCombat(boolean win) {
        if (win) {
            this.addTreasures(1);
        }
    }
}