package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Necronomicon extends Treasure {

    public Necronomicon(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(800);
        if(!this.getOwner().getFaction().equals(Faction.Professor)) {
            this.disable();
        }
        this.setArmor(Armor.TwoHands);
    }

    @Override
    public void cardInPlay() {
        this.setBonus(5);
    }
}