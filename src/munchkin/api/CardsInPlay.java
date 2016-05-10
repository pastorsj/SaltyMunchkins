package munchkin.api;

import munchkin.game.Action;
import munchkin.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamPastoriza on 3/28/16.
 */
public class CardsInPlay {

    private List<ICard> cardsInPlay;
    public Action action;
    private Game game;

    public CardsInPlay(Game game) {
        this.cardsInPlay = new ArrayList<>();
        this.action = Action.getInstance();
        this.game = game;
    }

    public boolean addCardsToPlay(ICard card) {
        if(!this.cardsInPlay.contains(card)) {
            this.cardsInPlay.add(card);
            //IMPORTANT: This method must be called when a card added to the play set
            action.setValue("Added " + card.getName() + " to play");
            card.cardInPlay();
            return true;
        } else {
            this.action.setValue("Can't add the card to play: Card already in play!");
            return false;
        }
    }

    public boolean removeCardFromPlay(ICard card) {
        if(this.cardsInPlay.contains(card)) {
            ICard removedCard = this.cardsInPlay.remove(this.cardsInPlay.indexOf(card));
            this.action.setValue("Removed card from play successfully");
            this.game.getDiscardedCards().addToDiscardedCards(removedCard);
            return true;
        } else {
            this.action.setValue("Attempting to remove card that does not exist!");
            return false;
        }
    }

    public void removeAllCards() {
    	this.game.getDiscardedCards().addManyCards(this.cardsInPlay);
        this.cardsInPlay = new ArrayList<>();
    }

    public List<ICard> getCardsInPlay() {
        return this.cardsInPlay;
    }

    public boolean contains(ICard card) {
        return this.cardsInPlay.contains(card);
    }
}
