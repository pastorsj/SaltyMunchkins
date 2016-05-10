package munchkin.game.panels;

import munchkin.game.Game;
import munchkin.game.MFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MPanel extends JPanel {

	private MainCardPanel mainCardPanel;
	private Game game;

	public MPanel(MFrame frame, Game game) throws IOException {

		super();
		this.setPreferredSize(new Dimension(2000, 990));
		this.setLayout(new BorderLayout(5, 5));

		this.game = game;

		this.mainCardPanel = new MainCardPanel(this.game, frame);

		this.add(this.mainCardPanel, BorderLayout.CENTER);
		this.mainCardPanel.setPreferredSize(new Dimension(0, 225));
		this.mainCardPanel.setVisible(true);
		this.setVisible(true);
	}

}
