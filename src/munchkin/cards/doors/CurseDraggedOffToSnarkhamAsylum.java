package munchkin.cards.doors;

import java.util.Random;

import munchkin.cards.doors.api.AbstractCurse;
import munchkin.cards.treasures.api.Faction;

public class CurseDraggedOffToSnarkhamAsylum extends AbstractCurse {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		//becomes a Cultist if you are not a Cultist; pick a replacement class from the discard pile 
		//if you are a Cultist
		if(this.getOwner().getFaction().equals(Faction.Cultist)){
			this.getOwner().setFaction(randomFaction());
		}else{
			this.getOwner().setFaction(Faction.Cultist);
		}
		
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
	
	@Override
	public void cardPlayed(boolean win) {
		
	}
}