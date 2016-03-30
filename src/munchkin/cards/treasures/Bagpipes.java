package munchkin.cards.treasures;


import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;
import munchkin.game.Utility;

public class Bagpipes extends Treasure {

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
        if(Utility.rollDice() == 6) {
            this.mating = true;
            this.action.setValue("Dice roll was 6, The monster is attempting to mate with you");
        } else {
            this.mating = false;
            this.action.setValue("Dice roll was not 6, The monster is not attempting to mate with you");
        }
    }

    @Override
    public void cardPlayed(boolean win) {
        if(win) {
            if(mating) {
                this.setDiscard(true);
            }
        }
    }

}