package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class FakeTentacle extends Treasure {

    public FakeTentacle(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
    }

    @Override
    public void cardInPlay() {
        //TODO: Add pseudo armor
        this.setArmor(Armor.PseudoHeadGear);
        this.getOwner().addToRunAwayLevel(1);
    }

    @Override
    public void cardPlayed(boolean win) {
        if(!win) {
            this.setDiscard();
        }
    }
}