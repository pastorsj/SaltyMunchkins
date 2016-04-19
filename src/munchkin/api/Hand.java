package munchkin.api;

import java.util.ArrayList;
import java.util.List;

import munchkin.game.Action;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class Hand implements IHand {
    private List<ICard> hand;
    private IPlayer owner;
    private Action action;

    public Hand(IPlayer player) {
        this.owner = player;
        this.hand = new ArrayList<>();
        this.action = Action.getInstance();
    }

    @Override
    public boolean insertCard(ICard card) {
        if(sizeOfHand() < 8) {
            this.hand.add(card);
            //IMPORTANT: Invoke this method when a card is added to a players hand.
            card.setOwner(owner);
            card.cardInHand();
            this.action.setValue("inserted " + card.getName() + " into your hand");
            return true;
        }
        this.action.setValue("Couldnt insert " + card.getName() + " into the hand: you have too many cards");
        return false;
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
        if(inHand) {
            //Nobody owns this card anymore
            card.setOwner(null);
            action.setValue("Discarded " + card.getName() + " from your hand");
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
