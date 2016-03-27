package munchkin.cards.treasures;

import munchkin.api.ICard;
import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.game.Game;

public class IchorPicker extends AbstractTreasure {

    public IchorPicker(Game game) {
        super(game);
    }

    @Override
    public void cardInPlay() {
//        if(game.cardPlayed().getType().equals(CardType.Ichor)) {
//            switchCards(game.cardPlayed());
//        }
    }

    private void switchCards(ICard card) {
        //Add most recently played Ichor card into players hand, change ownership, discard this card
    }

}