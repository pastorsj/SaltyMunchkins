package munchkin.cards.doors;

import munchkin.api.IPlayer;
import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

import java.util.Random;

public class CurseDraggedOffToSnarkhamAsylum extends AbstractCurse {

	public CurseDraggedOffToSnarkhamAsylum(Game game) {
		super(game);
	}

	@Override
	public void cardInPlay() {
		//becomes a Cultist if you are not a Cultist; pick a replacement class from the discard pile 
		//if you are a Cultist
		IPlayer playedOn = this.game.getOtherPlayer();
		if(playedOn.getFaction().equals(Faction.Cultist)){
			playedOn.setFaction(randomFaction());
		}else{
			playedOn.setFaction(Faction.Cultist);
		}
		this.setDiscard();
	}

	private Faction randomFaction(){
		Faction[] list = Faction.values();
		
		Random r = new Random();
		int num=r.nextInt(list.length);
		if(list[num].equals(Faction.Cultist)){
			return randomFaction();
		}
		return list[num];
	}
}