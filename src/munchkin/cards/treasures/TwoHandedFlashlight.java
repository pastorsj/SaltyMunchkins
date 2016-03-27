package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class TwoHandedFlashlight extends Treasure {

    public TwoHandedFlashlight(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
        if(this.getOwner().getFaction().equals(Faction.Professor)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(3);
        this.setArmor(Armor.TwoHands);
    }
}