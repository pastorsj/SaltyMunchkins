package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class BickerIchor extends AbstractTreasure {

    public BickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(600);
    }

    @Override
    public void cardInPlay() {
        //Get cards in play and check for number of monsters
        if(checkNumMonsters() > 1) {
            discardLowerLevelMonster();
        }
    }

    @Override
    public void cardPlayed(boolean win) {
        this.discard();
    }

    private int checkNumMonsters() {
        //Go through hand and get number of monsters
        return 1;
    }

    private void discardLowerLevelMonster() {
        //Get rid of the lower level monster from hand
    }



}