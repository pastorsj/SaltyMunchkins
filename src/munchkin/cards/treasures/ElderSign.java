package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class ElderSign extends AbstractTreasure {

    public ElderSign(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
        //This card is not usable by Investigators
//        if(this.p1.faction!=Faction.Investigator) {
//            this.disable();
//        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(3);
        this.setArmor(Armor.OneHand);
    }
}