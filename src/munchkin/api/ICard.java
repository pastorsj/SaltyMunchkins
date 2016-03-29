package munchkin.api;

public interface ICard {
	public void cardInHand();
	public void cardInPlay();
	public void cardPlayed(boolean win);
	public IPlayer getOwner();
	public void setOwner(IPlayer player);
	public void setCardType();
	public CardType getCardType();
}
