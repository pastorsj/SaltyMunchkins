package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class TripleBarreledShotgun extends Treasure {

    public TripleBarreledShotgun(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(700);
        if(!this.getOwner().getFaction().equals(Faction.Investigator)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(4);
        this.setArmor(Armor.TwoHands);
    }
}