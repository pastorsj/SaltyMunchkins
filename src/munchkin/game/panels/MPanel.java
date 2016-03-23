package munchkin.game.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;

import munchkin.game.Game;
import munchkin.game.MFrame;

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
