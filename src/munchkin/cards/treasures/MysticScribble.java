package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class MysticScribble extends AbstractTreasure {

    public MysticScribble(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
        if(this.getOwner().getFaction().equals(Faction.Cultist)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.OneHand);
        this.setBonus(2);
    }
}