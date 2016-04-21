package munchkin.api;

import java.util.List;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public interface IHand {
    public boolean insertCard(ICard card);
    public boolean removeCardFromHand(ICard card);
    public boolean cardInHand(ICard card);
    public List<ICard> getCards();
    public int sizeOfHand();
    //True means the hand is too large (ie greater than 8) and the turn cannot end
    public boolean checkSizeOfHand();
}
