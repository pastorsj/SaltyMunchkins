package munchkin.api;

public interface ICard {
	public void cardInHand();
	public void cardInPlay();
	public void cardPlayed(boolean win);
}
