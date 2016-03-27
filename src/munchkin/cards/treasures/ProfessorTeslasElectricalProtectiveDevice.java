package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class ProfessorTeslasElectricalProtectiveDevice extends Treasure {

    public ProfessorTeslasElectricalProtectiveDevice(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(900);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.Armor);
        this.setBonus(4);
    }
}