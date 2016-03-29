package munchkin.game;

import munchkin.api.ICard;

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
	public Map<Integer, ICard> cardHash;
	private List<ICard> allCards;
	private List<ICard> doorCards;
	private List<ICard> treasureCards;


	public InitializeCards() {
		this.cardHash = new HashMap<>();
		this.doorCards = new ArrayList<>();
		this.treasureCards = new ArrayList<>();
		initializeDoorCards();
		initializeTreasureCards();
		this.allCards.addAll(doorCards);
		this.allCards.addAll(treasureCards);

	}

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
