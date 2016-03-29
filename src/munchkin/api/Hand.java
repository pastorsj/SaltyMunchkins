package munchkin.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class Hand implements IHand {
    private List<ICard> hand;
    private IPlayer owner;

    public Hand(IPlayer player) {
        this.owner = player;
        this.hand = new ArrayList<>();
    }

    @Override
    public boolean insertCard(ICard card) {
        if(sizeOfHand() < 8) {
            this.hand.add(card);
            //IMPORTANT: Invoke this method when a card is added to a players hand.
            card.cardInHand();
            card.setOwner(owner);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCardFromHand(ICard card) {
        boolean inHand = this.hand.remove(card);
        if(inHand) {
            //FIXME: There needs to be a concept of Combat implemented
            //This method must be invoked when the card is discarded
            card.cardPlayed(true);
            //Nobody owns this card anymore
            card.setOwner(null);
        }
        return inHand;
    }

    @Override
    public boolean cardInHand(ICard card) {
        return this.hand.contains(card);
    }

    @Override
    public Iterator<ICard> iterator() {
        return hand.iterator();
    }

    @Override
    public int sizeOfHand() {
        return this.hand.size();
    }



}
