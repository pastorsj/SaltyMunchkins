package munchkin.game.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import munchkin.api.CardsInPlay;
import munchkin.api.ICard;
import munchkin.api.IHand;
import munchkin.api.IPlayer;
import munchkin.game.Game;
import munchkin.game.MFrame;
import munchkin.game.buttons.DiscardButton;
import munchkin.game.buttons.DiscardGoldButton;
import munchkin.game.buttons.DrawCardButton;
import munchkin.game.buttons.EndTurnButton;
import munchkin.game.buttons.GenderButton;
import munchkin.game.buttons.NewGameButton;
import munchkin.game.buttons.PassCombatButton;
import munchkin.game.buttons.PlayCardButton;
import munchkin.game.buttons.ResolveConflictButton;
import munchkin.game.buttons.SellGoldButton;

public class MainCardPanel extends JPanel implements MouseListener {
	private final String IMAGE_PATH = "resources/pictures/";
	private final String PNG_EXTENSION = ".png";

	// Current Implementation
	private BufferedImage largeCard;
	private ICard selectedCard;

	private Game game;
	private Map<String, JButton> buttons;
	private Map<String, JLabel> labels;
	private Map<String, String> partialLabel;
	private Map<String, BufferedImage> images;
	private Map<BufferedImage, String> revImageMap;
	private List<BufferedImage> cardsInHand;
	private Map<IPlayer, List<BufferedImage>> cardsInPlay;
	private MFrame frame;

	public MainCardPanel(Game game, MFrame frame) {
		this.frame = frame;
		this.game = game;

		initializeLabels();
		initializeButtons();
		initializeImages();

		this.updateLabels();
		this.addInitialButtonsToPanel();
		this.addInitialLabelsToPanel();
		this.addMouseListener(this);
	}

	private void initializeLabels() {
		this.labels = new HashMap<>();
		this.partialLabel = new HashMap<>();
		this.labels.put("PlayerLabel", new JLabel("Current Player: " + this.game.getCurrentPlayer().getName()));
		this.partialLabel.put("PlayerLabel", "Current Player: ");
		this.labels.put("PlayerLevelLabel",
				new JLabel("Player's Level: " + this.game.getCurrentPlayer().getPlayerLevel()));
		this.partialLabel.put("PlayerLevelLabel", "Player's Level: ");
		this.labels.put("CombatLevelLabel",
				new JLabel("Player's Combat Level: " + this.game.getCurrentPlayer().getCombatLevel()));
		this.partialLabel.put("CombatLevelLabel", "Player's Combat Level: ");
		this.labels.put("MonsterLevelLabel", new JLabel("Monster's Level: " + this.game.getCombat().getMonsterLevel()));
		this.partialLabel.put("MonsterLevelLabel", "Monster's Level: ");
		this.labels.put("DiceRollLabel", new JLabel("Number Rolled: "));
		this.partialLabel.put("DiceRollLabel", "Number Rolled: ");
		this.labels.put("GenderLabel", new JLabel("Enter Gender: " + this.game.getCurrentPlayer().getName()));
		this.partialLabel.put("GenderLabel", "Enter Gender: ");

	}

	private void initializeButtons() {
		this.buttons = new HashMap<>();
		this.buttons.put("New Game", new NewGameButton(this.frame));
		this.buttons.put("Draw Card", new DrawCardButton("Draw Card", this.game, this));
		this.buttons.put("End Turn", new EndTurnButton("End Turn", this.game, this));
		this.buttons.put("Discard", new DiscardButton("Discard", this.game, this));
		this.buttons.put("Play Card", new PlayCardButton("Play Card", this.game, this));
		this.buttons.put("Pass Combat", new PassCombatButton("Pass Combat", this.game, this));
		this.buttons.put("Resolve Conflict", new ResolveConflictButton("Resolve Conflict", this.game, this));
		this.buttons.put("Sell Gold", new SellGoldButton("Sell Gold", this.game, this));
		this.buttons.put("Discard Gold", new DiscardGoldButton("Discard Gold", this.game, this));
		this.buttons.put("Male", new GenderButton("Male", this.game, this));
		((GenderButton) this.buttons.get("Male")).setMaleGender();
		this.buttons.put("Female", new GenderButton("Female", this.game, this));
		((GenderButton) this.buttons.get("Female")).setFemaleGender();
	}

	private void initializeImages() {
		this.images = new HashMap<>();
		try {
			this.images.put("LoserScreen", ImageIO.read(new File(IMAGE_PATH + "youlosescreen.png")));
			this.images.put("WinnerScreen", ImageIO.read(new File(IMAGE_PATH + "youwinscreen.jpg")));
			this.images.put("Munchkin Cthulhu", ImageIO.read(new File(IMAGE_PATH + "munchkin-cthulhu.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addInitialLabelsToPanel() {
		for (String key : this.labels.keySet()) {
			this.add(this.labels.get(key));
			if (key.equals("GenderLabel")) {
				this.labels.get(key).setVisible(true);
			} else {
				this.labels.get(key).setVisible(false);
			}
		}
	}

	private void addInitialButtonsToPanel() {
		for (String key : this.buttons.keySet()) {
			this.buttons.get(key).setPreferredSize(new Dimension(130, 30));
			this.add(this.buttons.get(key));
			// FIXME
			if ((key.equals("Male")) || (key.equals("Female"))) {
				this.buttons.get(key).setVisible(true);
			} else {
				this.buttons.get(key).setVisible(false);
			}
		}
	}

	public void updateLabels() {
		this.labels.get("PlayerLabel").setText("Current Player: " + this.game.getCurrentPlayer().getName());
		this.labels.get("PlayerLevelLabel").setText("Player's Level: " + this.game.getCurrentPlayer().getPlayerLevel());
		this.labels.get("CombatLevelLabel")
				.setText("Player's Combat Level: " + this.game.getCurrentPlayer().getCombatLevel());
		this.labels.get("MonsterLevelLabel").setText("Monster's Level: " + this.game.getCombat().getMonsterLevel());
	}

	public void updateLabel(String label, Integer updatedValue) {
		this.labels.get(label).setText(this.partialLabel.get(label) + updatedValue);
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		// if you lose
		if (!this.game.getCurrentPlayer().isAlive()) {
			g.drawImage(this.images.get("LoserScreen"), 0, 0, 1920, 1080, null);
		} else if (game.checkWin()) {
			g.drawImage(this.images.get("WinnerScreen"), 0, 0, 1920, 1080, null);
		} else {
			try {
				populateCurrentHandImages();
				populateInPlayImages();
			} catch (IOException e) {
				System.err.println("Error reading image files");
				e.printStackTrace();
			}

			// Draw all cards in current hand
			for (int i = 0; i < cardsInHand.size() && i < 8; i++) {
				g.drawImage(cardsInHand.get(i), 50 + 180 * i + 10 * i, 750, 180, 225, null);
			}

			// draw extra drawn cards in top right
			for (int i = 0; i < cardsInHand.size() - 8; i++) {
				if (cardsInHand.size() > i + 8) {
					g.drawImage(cardsInHand.get(i + 8), 50 + 180 * (8 + i) + 10 * (8 + i), 170, 180, 225, null);
				}
			}

			// In play for current player
			if (!this.cardsInPlay.isEmpty()) {
				List<BufferedImage> imageList = this.cardsInPlay.get(this.game.getCurrentPlayer());
				for (int i = 0; i < imageList.size(); i++) {
					g.drawImage(imageList.get(i), 50 + 100 * i, 515, 180, 225, null);
				}

				// In play for other player
				imageList = this.cardsInPlay.get(this.game.getOtherPlayer());
				for (int i = 0; i < imageList.size(); i++) {
					g.drawImage(imageList.get(i), 50 + 100 * i, 50, 180, 225, null);
				}
			}
			g.drawImage(largeCard, 50 + 180 * 8 + 10 * 8, 400, 360, 570, null);
			try {
				this.updateRevImageMap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.setMinimumSize(new Dimension(2000, 500));
			this.setVisible(true);
		}

	}

	private void updateRevImageMap() throws Exception {
		this.revImageMap = new HashMap<>();
		Set<BufferedImage> keySet = new HashSet<>(this.images.values());
		Set<String> valueSet = new HashSet<>(this.images.keySet());
		List<BufferedImage> imageSet = new ArrayList<>(this.images.values());
		List<String> imageNameSet = new ArrayList<>(this.images.keySet());
		if (!(keySet.size() == valueSet.size())) {
			throw new Exception(
					"The Image HashMap does not have unique key-value pairs (updateRevImageMap() in Game.java)");
		}
		for (int i = 0; i < imageSet.size(); i++) {
			this.revImageMap.put(imageSet.get(i), imageNameSet.get(i));
		}
	}

	private void populateInPlayImages() throws IOException {
		CardsInPlay cards = this.game.getCardsInPlay();
		this.cardsInPlay = new HashMap<>();
		for (ICard card : cards.getCardsInPlay()) {
			if (!this.cardsInPlay.containsKey(card.getOwner())) {
				this.cardsInPlay.put(card.getOwner(), new ArrayList<BufferedImage>());
			}
			BufferedImage inPlayImage = ImageIO.read(new File(IMAGE_PATH + card.getName() + PNG_EXTENSION));
			this.cardsInPlay.get(card.getOwner()).add(inPlayImage);
			this.images.put(card.getName(), inPlayImage);
		}
	}

	private void populateCurrentHandImages() throws IOException {
		IHand currentPlayersHand = this.game.getCurrentPlayer().getHand();
		this.cardsInHand = new ArrayList<>();
		for (ICard card : currentPlayersHand.getCards()) {
			BufferedImage inHandImage = ImageIO.read(new File(IMAGE_PATH + card.getName() + PNG_EXTENSION));
			this.cardsInHand.add(inHandImage);
			this.images.put(card.getName(), inHandImage);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println(MouseInfo.getPointerInfo().getLocation());
		// TODO: There may be some magic numbers here...
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		if (y > 780 && y < 1006) {
			//new stuff here
			int j = 10;
			int k = 185;
			
			System.out.println("x is: " + x);
			for(int i = 0; i<8; i++){
				System.out.println("i is: " + i);
				if(x>j && x<k){
					System.out.println("j is: " + j);
					System.out.println("k is: " + k);
					if(cardsInHand.size() > i){
						largeCard = cardsInHand.get(i);
						//break;
					}
				}
				//else{
				//	System.out.println("executing else");
					j+=190;
					k+=190;
				//}
			}
		}

		//used to be just if
		else if (y < 425 && y > 202) {
			if (x > 1530 && x < 1707) {
				if (cardsInHand.size() > 8) {
					largeCard = cardsInHand.get(8);
				}
			}

			else if (x > 1540 && x < 1720) {
				if (cardsInHand.size() > 9) {
					largeCard = cardsInHand.get(9);
				}
			}
		}

		//used to be just if
		else if (y > 545 && y < 770) {
			for (int i = 0; i < this.cardsInPlay.get(this.game.getCurrentPlayer()).size(); i++) {
				if (x > 50 + 100 * i && x < 50 + 100 * i + 100) {
					largeCard = this.cardsInPlay.get(this.game.getCurrentPlayer()).get(i);
				}
			}

		}

		//used to be just if
		else if (y > 50 && y < 300) {
			for (int i = 0; i < this.cardsInPlay.get(this.game.getOtherPlayer()).size(); i++) {
				if (x > 50 + 100 * i && x < 50 + 100 * i + 100) {
					largeCard = this.cardsInPlay.get(this.game.getOtherPlayer()).get(i);
				}
			}

		}
		this.updateSelectedCard();
		this.frame.repaint();
	}

	private void updateSelectedCard() {
		String cardSelected = this.revImageMap.get(largeCard);
		for (ICard card : this.game.getAllCards()) {
			if (card.getName().equals(cardSelected)) {
				this.selectedCard = card;
				return;
			}
		}
	}

	public Map<String, JButton> getButtonSet() {
		return this.buttons;
	}

	public Map<String, JLabel> getLabels() {
		return this.labels;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public ICard getSelectedCard() {
		return this.selectedCard;
	}

	public void updateLargeCard(ICard card) {
		this.largeCard = this.images.get(card.getName());
		this.selectedCard = card;
	}

	public void resetLargeCard() {
		// This seems to not work
		this.largeCard = null;
		this.selectedCard = null;
	}

	public void repaintFrame() {
		// this.frame.revalidate();
		this.frame.repaint();
	}
}
