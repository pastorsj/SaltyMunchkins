package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class ElderSign extends Treasure {

    public ElderSign(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
        this.setBonus(3);
        this.setArmor(Armor.OneHand);
        //This card is not usable by Investigators
        if(this.getOwner().getFaction().equals(Faction.Investigator)) {
            this.disable();
        }
    }
}