package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class SlimeProofPoncho extends AbstractTreasure {

    public SlimeProofPoncho(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(400);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.Armor);
        this.setBonus(2);
        //Immunity to all Ichor effects played by other players
    }
}