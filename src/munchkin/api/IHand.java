package munchkin.api;

import java.util.Iterator;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public interface IHand {
    public boolean insertCard(ICard card);
    public boolean removeCardFromHand(ICard card);
    public boolean cardInHand(ICard card);
    public Iterator<ICard> iterator();
    public int sizeOfHand();
}
