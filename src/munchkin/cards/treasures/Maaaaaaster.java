package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class Maaaaaaster extends AbstractTreasure {

    public Maaaaaaster(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(0);
        if(!this.ownedBy.getFaction().equals(Faction.Cultist)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(4);
        this.setArmor(Armor.HeadGear);
    }
}