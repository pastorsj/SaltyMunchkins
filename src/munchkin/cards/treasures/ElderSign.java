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
        //This card is only usable by Investigators
        if(!this.getOwner().getFaction().equals(Faction.Investigator)) {
        	this.disable();
        }
        else{
            this.setArmor(Armor.OneHand);
        }
    }

    @Override
    public void cardInPlay() {
        this.setBonus(3);
     
    }
}