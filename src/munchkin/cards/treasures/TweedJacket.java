package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class TweedJacket extends Treasure {

    public TweedJacket(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
        if(!this.getOwner().getFaction().equals(Faction.Professor)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(2);
        //Can be used with more than one piece of armor
        this.setArmor(Armor.PseudoArmor);
    }
}