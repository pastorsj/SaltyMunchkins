package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class ProfessorTeslasElectricalProtectiveDevice extends AbstractTreasure {

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