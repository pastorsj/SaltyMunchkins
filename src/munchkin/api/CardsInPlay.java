package munchkin.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamPastoriza on 3/28/16.
 */
public class CardsInPlay {

    private List<ICard> cardsInPlay;

    public CardsInPlay() {
        this.cardsInPlay = new ArrayList<>();
    }

    public void addCardsToPlay(ICard card) {
        if(!this.cardsInPlay.contains(card)) {
            this.cardsInPlay.add(card);
            //IMPORTANT: This method must be called when a card added to the play set
            card.cardInPlay();
        } else {
            System.err.println("Card already in play!");
        }
    }

    public void removeCardFromPlay(ICard card) {
        if(this.cardsInPlay.contains(card)) {
            this.cardsInPlay.remove(this.cardsInPlay.indexOf(card));
        } else {
            System.err.println("Attempting to remove card that does not exist!");
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
