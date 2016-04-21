package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class SlimeProofPoncho extends Treasure {

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