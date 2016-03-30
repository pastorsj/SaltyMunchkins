package munchkin.game;

import munchkin.api.ICard;
import munchkin.cards.doors.AndItsSpawn;
import munchkin.cards.doors.AughostDerwraith;
import munchkin.cards.doors.CurseGetAllBlobby;
import munchkin.cards.doors.CurseHairStandsOnEnd;
import munchkin.cards.treasures.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitializeCards {
	private static final int NUMBER_TREASURES = 67;
	private static final int NUMBER_DOORS = 83;
	private static final String DOORS_PATH = "../cards/doors";
	private static final String TREASURES_PATH = "../cards/treasures";
	private Game game;
	public Map<Integer, ICard> cardHash;
	private List<ICard> allCards;
	private List<ICard> doorCards;
	private List<ICard> treasureCards;


	public InitializeCards(Game game) {
		this.game = game;
		this.doorCards = new ArrayList<>();
		this.treasureCards = new ArrayList<>();
		initializeSelectTreasureCards();
		initializeSelectDoorCards();
		this.allCards.addAll(doorCards);
		this.allCards.addAll(treasureCards);

	}

	//---- Temperary Methods -----
	private void initializeSelectTreasureCards() {
		initializeTreasure(new BowlingPin());
		initializeTreasure(new Necrocomicon(this.game));
		initializeTreasure(new BrassKnucks());
		initializeTreasure(new CallTheArmy());
		initializeTreasure(new Flamethrower());
		initializeTreasure(new TwoHandedFlashlight(this.game));
		initializeTreasure(new WandOfWalloping(this.game));
		initializeTreasure(new ReportCreaturestoFBI());
	}

	private void initializeTreasure(ICard card) {
		this.treasureCards.add(card);
	}

	private void initializeSelectDoorCards() {
		initializeDoor(new AndItsSpawn(this.game));
		initializeDoor(new CurseGetAllBlobby());
		initializeDoor(new CurseHairStandsOnEnd());
		initializeDoor(new AughostDerwraith());
	}

	private void initializeDoor(ICard card) {
		this.treasureCards.add(card);
	}

	//TODO: Implement these after we finish the rest of the cards
	private void initializeTreasureCards() {
		File treasuresFolder = new File(TREASURES_PATH);
		File[] listOfFiles = treasuresFolder.listFiles();
		for(int i = 0;  i < listOfFiles.length; i++) {
			if(listOfFiles[i].isFile()) {
				System.out.println(listOfFiles[i].getName());
			}
		}
	}

	private void initializeDoorCards() {
		File doorsPackage = new File(DOORS_PATH);

	}

	public List<ICard> getDoorCards() {
		return this.doorCards;
	}

	public List<ICard> getTreasureCards() {
		return this.treasureCards;
	}

	public List<ICard> getAllCards() {
		return this.allCards;
	}


}
