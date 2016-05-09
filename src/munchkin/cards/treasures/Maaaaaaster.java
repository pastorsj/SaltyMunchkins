package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;

public class Maaaaaaster extends Treasure {

    @Override
    public void cardInHand() {
        this.setGold(0);
        if(!this.getOwner().getFaction().equals(Faction.Cultist)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(4);
        this.setArmor(Armor.HeadGear);
    }
}