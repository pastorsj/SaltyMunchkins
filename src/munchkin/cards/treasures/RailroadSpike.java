package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class RailroadSpike extends AbstractTreasure {

    public RailroadSpike(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
        if(!this.getOwner().getFaction().equals(Faction.MonsterWhacker)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(3);
        this.setArmor(Armor.OneHand);
    }
}