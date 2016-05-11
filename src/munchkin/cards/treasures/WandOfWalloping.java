package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class WandOfWalloping extends Treasure {

    public WandOfWalloping(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
        if(this.getOwner().getFaction().equals(Faction.Investigator)) {
            this.disable();
        }
        this.setArmor(Armor.OneHand);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(3);
    }
}