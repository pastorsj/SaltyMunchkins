package munchkin.api;

public interface ICard {
	public void cardInHand();
	public void cardInPlay();
	public void cardPlayed(boolean win);
	public IPlayer getOwner();
	public void setOwner(IPlayer player);
	public void setCardType(CardType type);
	public void setCardType(SpecificCardType type);
	public CardType getCardType();
	public String getName();
	public boolean isDisabled();
	public void enable();
	public void disable();
	public SpecificCardType getSpecificCardType();
}
