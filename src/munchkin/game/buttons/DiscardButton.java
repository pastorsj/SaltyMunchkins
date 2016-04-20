package munchkin.game.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import munchkin.api.ICard;
import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

public class DiscardButton extends JButton implements ActionListener {

	private Game game;
	private MainCardPanel mainCardPanel;

	public DiscardButton(String buttonText, Game game, MainCardPanel panel) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		this.setText(buttonText);
		this.setPreferredSize(new Dimension(100, 30));
		super.setVisible(true);

		this.mainCardPanel = panel;
		this.game = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ICard cardToMove = this.mainCardPanel.getSelectedCard();
		try {
			this.game.discardCard(this.game.getCurrentPlayer(), cardToMove);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.mainCardPanel.resetLargeCard();
		this.mainCardPanel.repaintFrame();
	}

}
