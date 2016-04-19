package munchkin.api;

import java.util.ArrayList;
import java.util.List;

import munchkin.game.Action;

/**
 * Created by SamPastoriza on 3/28/16.
 */
public class CardsInPlay {

    private List<ICard> cardsInPlay;
    private Action action;

    public CardsInPlay() {
        this.cardsInPlay = new ArrayList<>();
        this.action = Action.getInstance();
    }

    public void addCardsToPlay(ICard card) {
        if(!this.cardsInPlay.contains(card)) {
            this.cardsInPlay.add(card);
            System.out.println(card.getOwner());
            //IMPORTANT: This method must be called when a card added to the play set
            action.setValue("added " + card.getName() + " to play");
            card.cardInPlay();
        } else {
            this.action.setValue("Cant add the card to play: card already in play!");
        }
    }

    public void removeCardFromPlay(ICard card) {
        if(this.cardsInPlay.contains(card)) {
            this.cardsInPlay.remove(this.cardsInPlay.indexOf(card));
            this.action.setValue("removed card from play successfully");
        } else {
            this.action.setValue("Attempting to remove card that does not exist!");
        }
    }

    public void removeAllCards() {
        this.cardsInPlay = new ArrayList<>();
    }

    public List<ICard> getCardsInPlay() {
        return this.cardsInPlay;
    }

    public boolean contains(ICard card) {
        return this.cardsInPlay.contains(card);
    }
}
