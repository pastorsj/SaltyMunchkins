package munchkin.api;

import munchkin.game.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public class Hand implements IHand {
    private List<ICard> hand;
    private Player owner;

    public Hand(Player player) {
        this.owner = player;
        this.hand = new ArrayList<>();
    }

    public void insertCard(ICard card) {
        this.hand.add(card);
    }

    public boolean removeCardFromHand(ICard card) {
        return this.hand.remove(card);
    }

    public boolean cardInHand(ICard card) {
        return this.hand.contains(card);
    }

    public Iterator<ICard> iterator() {
        return hand.iterator();
    }



}
