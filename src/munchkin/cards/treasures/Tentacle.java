package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class Tentacle extends AbstractTreasure {

    public Tentacle(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
        if(!this.getOwner().getFaction().equals(Faction.Cultist)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.NegativeOneHand);
    }
}