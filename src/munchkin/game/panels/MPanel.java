package munchkin.game.panels;

import munchkin.game.Game;
import munchkin.game.MFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MPanel extends JPanel {

	MunchkinPanel munchPanel;
	public Game myGame;
	public BottomCardPanel bCardPanel;
	public WelcomePanel welcPanel;

	public MPanel(MFrame frame, Game game) throws IOException {

		super();
		this.setPreferredSize(new Dimension(2000, 990));

		this.setLayout(new BorderLayout(5, 5));
		myGame = game;
		this.bCardPanel = new BottomCardPanel(myGame);
		this.add(bCardPanel, BorderLayout.CENTER);
		this.bCardPanel.setPreferredSize(new Dimension(0, 225));
		this.bCardPanel.setVisible(true);

		this.setVisible(true);
	}

	public void addBCard() {
		this.bCardPanel = new BottomCardPanel(myGame);
		this.add(bCardPanel, BorderLayout.CENTER);
		this.bCardPanel.setPreferredSize(new Dimension(0, 225));

	}

	public void addWPanel() {
		this.welcPanel = new WelcomePanel(myGame);
		this.add(welcPanel, BorderLayout.CENTER);

	}

}
