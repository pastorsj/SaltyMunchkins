package munchkin.cards.treasures;

import munchkin.cards.treasures.api.ArmorSet;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Tentacle extends Treasure {

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
        ArmorSet set = this.getOwner().getArmorSet();
        set.setMaxHands(set.getMaxHands()+1);
    }
}