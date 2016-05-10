package munchkin.game;

import munchkin.api.ICard;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Treasure;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InitializeCards {
	private static final int NUMBER_TREASURES = 67;
	private static final int NUMBER_DOORS = 83;
	private static final String DOORS_PATH = "./src/munchkin/cards/doors";
	private static final String TREASURES_PATH = "./src/munchkin/cards/treasures";
	private Game game;
	public Map<Integer, ICard> cardHash;
	private List<ICard> allCards;
	private List<ICard> doorCards;
	private List<ICard> treasureCards;


	public InitializeCards(Game game) {
		this.game = game;
		this.doorCards = new ArrayList<>();
		this.treasureCards = new ArrayList<>();
		this.allCards = new ArrayList<>();
		initializeTreasureCards();
		initializeDoorCards();
		this.allCards.addAll(doorCards);
		this.allCards.addAll(treasureCards);

	}

	private void initializeTreasureCards() {
		File treasuresFolder = new File(TREASURES_PATH);
		File[] listOfFiles = treasuresFolder.listFiles();
		for(int i = 0;  i < listOfFiles.length; i++) {
			if(listOfFiles[i].isFile()) {
				String className = listOfFiles[i].getName();
				if(className.contains(".java")) {
					className = className.substring(0, className.indexOf(".java"));					
				} else {
					continue;
				}
				try {
					Class<?> clazz = Class.forName("munchkin.cards.treasures." + className);
					Constructor[] allConstructors = clazz.getDeclaredConstructors();
					ICard c = null;
					for(Constructor ctor : allConstructors) {
						System.out.println(ctor);
						if(ctor.toString().contains("munchkin.game.Game")) {
							System.out.println("Game Constructor");
							c = (Treasure) ctor.newInstance(this.game);
						} else {
							System.out.println("Not Game Constructor");
							c = (Treasure) ctor.newInstance();
						}
					}
					this.treasureCards.add(c);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void initializeDoorCards() {
		File doorsFolder = new File(DOORS_PATH);
		File[] listOfFiles = doorsFolder.listFiles();
		for(int i = 0;  i < listOfFiles.length; i++) {
			if(listOfFiles[i].isFile()) {
				String className = listOfFiles[i].getName();
				if(className.contains(".java")) {
					className = className.substring(0, className.indexOf(".java"));					
				} else {
					continue;
				}
				System.out.println(className);
				try {
					Class<?> clazz = Class.forName("munchkin.cards.doors." + className);
					Constructor[] allConstructors = clazz.getDeclaredConstructors();
					ICard c = null;
					for(Constructor ctor : allConstructors) {
						System.out.println(ctor);
						if(ctor.toString().contains("munchkin.game.Game")) {
							System.out.println("Game Constructor");
							c = (Door) ctor.newInstance(this.game);
						} else {
							System.out.println("Not Game Constructor");
							c = (Door) ctor.newInstance();
						}
					}
					this.doorCards.add(c);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

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

	public ICard removeDoorCard(int i){
		return this.doorCards.remove(i);
	}
	
	public ICard removeTreasureCard(int i){
		return this.treasureCards.remove(i);
	}

}
