package munchkin.api;

import java.util.ArrayList;
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
            card.setOwner(this.owner);
            card.cardInHand();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCardFromHand(ICard card) {
    	if(!this.hand.contains(card)) {
    		//Add Action
    		System.err.println("This card has already been discarded");
    		return false;
    	}
        boolean inHand = this.hand.remove(card);
        if(inHand) {
            //Add card to either treasure or door discard set
            if(card.getCardType().equals(CardType.Door)) {
            	
            } else {
            	
            }
        }
        return inHand;
    }

    @Override
    public boolean cardInHand(ICard card) {
        return this.hand.contains(card);
    }

    @Override
    public int sizeOfHand() {
        return this.hand.size();
    }

	@Override
	public List<ICard> getCards() {
		return this.hand;
	}



}
