package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class FezofFazooli extends Treasure {

    public FezofFazooli(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(700);
        //Not usable by the Monster Whacker
        if(this.getOwner().getFaction().equals(Faction.MonsterWhacker)) {
            this.disable();
        }
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.HeadGear);
        this.setBonus(3);
    }
}