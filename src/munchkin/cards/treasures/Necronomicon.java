package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class Necronomicon extends AbstractTreasure {

    public Necronomicon(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(800);
        if(!this.getOwner().getFaction().equals(Faction.Professor)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.TwoHands);
        this.setBonus(5);
    }
}