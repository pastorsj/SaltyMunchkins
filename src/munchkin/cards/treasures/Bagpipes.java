package munchkin.cards.treasures;


import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class Bagpipes extends AbstractTreasure {

    private boolean mating = false;

    public Bagpipes(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(500);
        this.setBonus(4);
        this.setArmor(Armor.TwoHands);
    }

    @Override
    public void cardInPlay() {
//        if(game.throwDice() == 6) {
//            this.mating = true;
//        } else {
//            this.mating = false;
//        }
    }

    @Override
    public void cardPlayed(boolean win) {
        if(win) {
            if(mating) {
                this.discard();
            }
        }
    }

}