package munchkin.api;

import munchkin.game.Action;
import munchkin.game.DiscardedCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class Hand implements IHand {
    private List<ICard> hand;
    private IPlayer owner;
    private Action action;
    private boolean largeHand = false;
    private DiscardedCards discard;

    public Hand(IPlayer player) {
        this.owner = player;
        this.hand = new ArrayList<>();
        this.action = Action.getInstance();
        this.discard = DiscardedCards.getInstance();
    }

    @Override
    public boolean insertCard(ICard card) {
        if(this.hand.contains(card)) {
            this.action.setValue("The hand already contains this card");
            return false;
        } else {
            this.hand.add(card);
            //IMPORTANT: Invoke this method when a card is added to a players hand.
            card.setOwner(this.owner);
            card.cardInHand();
            this.action.setValue("inserted " + card.getName() + " into your hand");
        }
        this.setLargeHand();
        return true;
    }

    @Override
    public boolean removeCardFromHand(ICard card) {
    	if(sizeOfHand() == 0){
    		this.action.setValue("You have no cards to discard!");
    		return false;
    	}
    	
    	if(!this.hand.contains(card)) {
    		this.action.setValue("This hand does not contain the card to be discarded");
    		return false;
    	}
        boolean inHand = this.hand.remove(card);
        System.out.println(this.hand.size());
        if(inHand) {
            action.setValue("Discarded " + card.getName() + " from your hand");
            //Add card to either treasure or door discard set
            	discard.addToDiscardedCards(card);
        }
        this.setLargeHand();
        return inHand;
    }

    public void setLargeHand() {
        if(this.hand.size() > 8) {
            this.largeHand = true;
            this.action.setValue("You have " + this.hand.size() + " cards in your hand. Discard until your hand size is 8");
        } else {
            this.largeHand = false;
        }
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
    public boolean checkSizeOfHand() {
        return this.largeHand;
    }

    @Override
	public List<ICard> getCards() {
		return this.hand;
	}
	
}
