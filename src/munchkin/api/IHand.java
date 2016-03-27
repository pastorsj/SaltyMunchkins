package munchkin.api;

/**
 * Created by SamPastoriza on 3/26/16.
 */
public interface IHand {
    public void insertCard(ICard card);
    public boolean removeCardFromHand(ICard card);
    public boolean cardInHand(ICard card);
}
