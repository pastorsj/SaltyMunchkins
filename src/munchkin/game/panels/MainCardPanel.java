package munchkin.game.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import munchkin.game.buttons.ResolveConflictButton;
import munchkin.game.buttons.DiscardButton;
import munchkin.game.buttons.DiscardGoldButton;
import munchkin.game.buttons.DrawCardButton;
import munchkin.game.buttons.EndTurnButton;
import munchkin.game.buttons.GenderButton;
import munchkin.game.buttons.NewGameButton;
import munchkin.game.buttons.PassCombatButton;
import munchkin.game.buttons.PlayCardButton;
import munchkin.game.buttons.SellGoldButton;

public class MainCardPanel extends JPanel implements MouseListener {
	private final String IMAGE_PATH = "resources/pictures/";
	private final String PNG_EXTENSION = ".png";
	
	// Current Implementation
	public int largeCardPos;
	public BufferedImage largeCard;

	private List<IPlayer> players;
	private Game game;
	private Map<String, JButton> buttons;
	private Map<String, JLabel> labels;
	private Map<String, String> partialLabel;
	private Map<String, BufferedImage> images;
	private List<BufferedImage> cardsInHand;
	private Map<IPlayer, List<BufferedImage>> cardsInPlay;
	private MFrame frame;

	public MainCardPanel(Game game, MFrame frame) {
		this.frame = frame;
		this.game = game;
		this.players = new ArrayList<>(this.game.getPlayers());
		
		initializeLabels();
		initializeButtons();
		initializeImages();
		
		this.updateLabels();
		this.addInitialLabelsToPanel();
		this.addInitialButtonsToPanel();
		this.addMouseListener(this);
	}

	private void initializeLabels() {
		this.labels = new HashMap<>();
		this.partialLabel = new HashMap<>();
		System.out.println("Game" + this.game);
		System.out.println("Player: " + this.game.getCurrentPlayer());
		System.out.println(this.game.getCurrentPlayer().getName());
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
		this.buttons.put("Resolve Conflict", new ResolveConflictButton("Did I Win?", this.game, this));
		this.buttons.put("Sell Gold", new SellGoldButton("Sell Gold", this.game, this));
		this.buttons.put("Discard Gold", new DiscardGoldButton("Discard Gold", this.game, this));
		this.buttons.put("Male", new GenderButton("Male", this.game, this));
		this.buttons.put("Female", new GenderButton("Female", this.game, this));
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
			this.buttons.get(key).setPreferredSize(new Dimension(100, 30));
			this.add(this.buttons.get(key));
			if (!(key.equals("Draw Card") || key.equals("Play Card") || key.equals("Sell gld")
					|| key.equals("Discard"))) {
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
				populateInPlayImages();
				populateCurrentHandImages();
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
			List<BufferedImage> imageList = this.cardsInPlay.get(this.game.getCurrentPlayer());
			for (int i = 0; i < imageList.size(); i++) {
				g.drawImage(imageList.get(i), 50 + 100 * i, 515, 180, 225,
						null);
			}

			// In play for other player
			imageList = this.cardsInPlay.get(this.game.getOtherPlayer());
			for (int i = 0; i < imageList.size(); i++) {
				g.drawImage(imageList.get(i), 50 + 100 * i, 50, 180, 225, null);
			}

			g.drawImage(largeCard, 50 + 180 * 8 + 10 * 8, 400, 360, 570, null);
			this.setMinimumSize(new Dimension(2000, 500));
			this.setVisible(true);

		}

	}

	private void populateInPlayImages() throws IOException {
		CardsInPlay cards = this.game.getCardsInPlay();
		this.cardsInPlay = new HashMap<>();
		for (ICard card : cards.getCardsInPlay()) {
			if (!this.cardsInPlay.containsKey(card.getOwner())) {
				this.cardsInPlay.put(card.getOwner(), new ArrayList<BufferedImage>());
			}
			this.cardsInPlay.get(card.getOwner()).add(ImageIO.read(new File(IMAGE_PATH + card.getName() + PNG_EXTENSION)));
		}
	}

	private void populateCurrentHandImages() throws IOException {
		IHand currentPlayersHand = this.game.getCurrentPlayer().getHand();
		this.cardsInHand = new ArrayList<>();
		for (ICard card : currentPlayersHand.getCards()) {
			System.out.println(card.getName());
			this.cardsInHand.add(ImageIO.read(new File(IMAGE_PATH + card.getName() + PNG_EXTENSION)));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println(MouseInfo.getPointerInfo().getLocation());
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		if (y > 780 && y < 1006) {
			if (x > 10 && x < 185) {
				largeCard = cardsInHand.get(0);
				largeCardPos = 0;
			} else if (x > 200 && x < 374) {
				if (cardsInHand.size() > 1) {
					largeCard = cardsInHand.get(1);
					largeCardPos = 1;

				}

			}

			else if (x > 393 && x < 564) {
				if (cardsInHand.size() > 2) {
					largeCard = cardsInHand.get(2);
					largeCardPos = 2;
				}

			} else if (x > 582 && x < 753) {
				if (cardsInHand.size() > 3) {
					largeCard = cardsInHand.get(3);
					largeCardPos = 3;
				}

			} else if (x > 773 && x < 946) {
				if (cardsInHand.size() > 4) {
					largeCard = cardsInHand.get(4);
					largeCardPos = 4;
				}

			} else if (x > 960 && x < 1137) {
				if (cardsInHand.size() > 5) {
					largeCard = cardsInHand.get(5);
					largeCardPos = 5;
				}

			} else if (x > 1151 && x < 1324) {
				if (cardsInHand.size() > 6) {
					largeCard = cardsInHand.get(6);
					largeCardPos = 6;
				}

			} else if (x > 1340 && x < 1517) {
				if (cardsInHand.size() > 7) {
					largeCard = cardsInHand.get(7);
					largeCardPos = 7;
				}

			}
		}

		if (y < 425 && y > 202) {
			if (x > 1530 && x < 1707) {
				if (cardsInHand.size() > 8) {
					largeCard = cardsInHand.get(8);
					largeCardPos = 8;
				}
			}

			else if (x > 1540 && x < 1720) {
				if (cardsInHand.size() > 9) {
					largeCard = cardsInHand.get(9);
					largeCardPos = 9;
				}
			}
		}

		if (y > 545 && y < 770) {
			for (int i = 0; i < this.cardsInPlay.get(this.game.getCurrentPlayer()).size(); i++) {
				if (x > 50 + 100 * i && x < 50 + 100 * i + 100) {
					largeCard = this.cardsInPlay.get(this.game.getCurrentPlayer()).get(i);
					largeCardPos = i;

				}
			}

		}
		// added this to click other cards
		if (y > 50 && y < 300) {
			for (int i = 0; i < this.cardsInPlay.get(this.game.getOtherPlayer()).size(); i++) {
				if (x > 50 + 100 * i && x < 50 + 100 * i + 100) {
					largeCard = this.cardsInPlay.get(this.game.getOtherPlayer()).get(i);
					largeCardPos = i;

				}
			}

		}

		// FIXME: not sure
		// game.mframe.repaint();//This blows everything up...

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

	public void updateLargeCard(ICard card) {

	}
}
