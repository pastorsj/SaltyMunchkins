package munchkin.cards.treasures;

import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class BickerIchor extends Treasure {

    public BickerIchor(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(600);
        this.setCardType(SpecificCardType.Ichor);
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
        int numMonsters = 1;
        this.action.setValue("The number of monsters on the table is " + numMonsters);
        return numMonsters;
    }

    private void discardLowerLevelMonster() {
        //Get rid of the lower level monster from hand
        this.action.setValue("Number of Monsters on the table exceeded 1, the monsters have fought and the lower level monster is discarded");
        this.setDiscard(true);
    }



}