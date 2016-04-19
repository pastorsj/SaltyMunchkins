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

public class DiscardGoldButton extends JButton implements ActionListener {

	private int goldAmount;
	private Game game;
	private MainCardPanel mainCardPanel;

	public DiscardGoldButton(
			String buttonText, Game game, MainCardPanel panel) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		this.setText(buttonText);
		this.setPreferredSize(new Dimension(200,30));
		super.setVisible(false);

		this.mainCardPanel = panel;
		this.game = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		super.setText("Discard >="+goldAmount+ "Gold");
		
		//Exactly the same issue as the discard button
		ICard cardToMove = this.mainCardPanel.getSelectedCard();
		try {
			this.game.discardCard(this.game.getCurrentPlayer(), cardToMove);
		} catch(Exception e) {
			e.printStackTrace();
		}

		this.mainCardPanel.repaintFrame();

	}
	
	@Override
	public void setVisible(boolean bool){
		super.setText("Discard >="+goldAmount+ "Gold ");
		super.setVisible(bool);
	}

	public void setGoldAmount(int goldAmount) {
		this.goldAmount = goldAmount;
	}

}
