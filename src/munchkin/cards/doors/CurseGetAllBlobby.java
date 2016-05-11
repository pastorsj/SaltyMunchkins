package munchkin.cards.doors;

import munchkin.api.ICard;
import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.game.Game;

import java.util.List;

public class CurseGetAllBlobby extends AbstractCurse {

	public CurseGetAllBlobby(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		//lose the armor you are wearing
		IPlayer playedOn = this.game.getOtherPlayer();
		List<ICard> armor = playedOn.getArmorSet().removeArmor();
		System.out.println(armor);
		if(armor == null) {
			this.action.setValue("You played a curse that had no effect!");
			return;
		}
		this.game.discardCards(playedOn, armor);
		this.setDiscard();
	}

}