package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

public class FezofFazooli extends AbstractTreasure {

    public FezofFazooli(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(700);
        //Not usable by the Monster Whacker
//        if(this.p1.faction.equals(Faction.MonsterWhacker)) {
//            this.disable();
//        }
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.HeadGear);
        this.setBonus(3);
    }
}