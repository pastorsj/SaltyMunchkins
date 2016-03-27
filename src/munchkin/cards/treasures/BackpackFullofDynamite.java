package munchkin.cards.treasures;


import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class BackpackFullofDynamite extends Treasure {

    public BackpackFullofDynamite(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(500);
    }

    @Override
    public void cardInPlay() {
//        this.setBonus(game.getDeclaredBonus());
    }

    @Override
    public void cardPlayed(boolean win) {
//        if(game.throwDice()<this.getBonus()) {
//              this.setDiscard(true);
//        }
    }

}