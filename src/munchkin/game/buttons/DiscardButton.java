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

	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;
	public int numDiscarded = 0;
	private Game game;
	private String buttonText;
	private MainCardPanel mainCardPanel;

	public DiscardButton(String buttonText, Game game, MainCardPanel panel) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		this.buttonText = buttonText;
		this.setText(this.buttonText);
		this.setPreferredSize(new Dimension(100, 30));
		super.setVisible(true);

		this.mainCardPanel = panel;
		this.game = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cardToMovePos = this.mainCardPanel.largeCardPos;
		ICard cardToMove;
		numDiscarded += 1;
		System.out.println("Discard " + cardToMovePos);
		
//		this.game.currentPlayer.pDiscard.add(cardToMove);
//		if (cardToMove < 83) {
//			this.game.doorDiscards.add(cardToMove);
//		} else {
//			this.game.treasDiscards.add(cardToMove);
//		}
//
//		this.game.mframe.revalidate();
//		this.game.mframe.repaint();

	}

}
