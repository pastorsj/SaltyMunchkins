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
    private Action action;
    private Game game;

    public CardsInPlay(Game game) {
        this.cardsInPlay = new ArrayList<>();
        this.action = Action.getInstance();
        this.game = game;
    }

    public void addCardsToPlay(ICard card) {
        if(!this.cardsInPlay.contains(card)) {
            this.cardsInPlay.add(card);
            //IMPORTANT: This method must be called when a card added to the play set
            action.setValue("Added " + card.getName() + " to play");
            card.cardInPlay();
        } else {
            this.action.setValue("Can't add the card to play: Card already in play!");
        }
    }

    public void removeCardFromPlay(ICard card) {
        if(this.cardsInPlay.contains(card)) {
            this.cardsInPlay.remove(this.cardsInPlay.indexOf(card));
            this.action.setValue("Removed card from play successfully");
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
