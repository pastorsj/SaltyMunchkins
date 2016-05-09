package munchkin.cards.doors;

import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;

public class Professor extends Door{

    @Override
    public void cardInPlay() {
        this.getOwner().setFaction(Faction.Professor);
    }
}