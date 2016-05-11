package munchkin.cards.treasures;

import munchkin.api.CardsInPlay;
import munchkin.api.ICard;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class WishingRing extends Treasure {

    public WishingRing(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(500);
    }

    @Override
    public void cardInPlay() {
        CardsInPlay inPlay = this.game.getCardsInPlay();
        for(ICard card : inPlay.getCardsInPlay()) {
            if(card instanceof AbstractCurse) {
                try {
                	this.game.getCardsInPlay().removeCardFromPlay(card);
                } catch(Exception e) {
                    System.err.println("Attempted to discard: cardInPlay():WishingRing");
                }
                return;
            }
        }
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
    }
}