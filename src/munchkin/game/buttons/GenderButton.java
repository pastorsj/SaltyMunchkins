package munchkin.game.buttons;

import munchkin.game.Game;
import munchkin.game.MFrame;
import munchkin.game.panels.MainCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenderButton extends JButton implements ActionListener {

	private String gender;
	private MainCardPanel mainCardPanel;
	private Game game;
	private String buttonText;

	public GenderButton(String buttonText, Game game, MainCardPanel panel) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));

		this.setMaximumSize(new Dimension(100, 50));

		this.game = game;
		this.mainCardPanel = panel;
		this.buttonText = buttonText;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//TODO
		
//		bCardPanel = myGame.mframe.mainPanel.bCardPanel;
//		
//		if (this.gender == "Male") {
//			myGame.currentPlayer.gender = 'M';
//
//		}
//
//		else if (this.gender == "Female") {
//			myGame.currentPlayer.gender = 'F';
//
//		}
//
//		else {
//			System.out.println("NO GENDER MATCH");
//		}
//
//		if (myGame.flag == 0) {
//			myGame.flag = 1;
//			System.out.println("Got to set flag to 1");
//			myGame.changePlayer();
//			bCardPanel.enterGender.setText("SELECT P2 GENDER");
//			bCardPanel.enterGender.setVisible(true);
//			bCardPanel.mb.setBoy();
//			bCardPanel.gb.setGirl();
//			myGame.mframe.revalidate();
//			myGame.mframe.repaint();
//		}
//
//		else if (myGame.flag == 1) {
//			myGame.changePlayer();
//			bCardPanel.mb.setVisible(false);
//			bCardPanel.gb.setVisible(false);
//			bCardPanel.dcb.setVisible(true);
//			bCardPanel.pcb.setVisible(true);
//			bCardPanel.sgb.setVisible(true);
//			bCardPanel.db.setVisible(true);
//
//			bCardPanel.playerLabel.setVisible(true);
//			bCardPanel.playerLevel.setVisible(true);
//			bCardPanel.playerCLevel.setVisible(true);
//			bCardPanel.monsterLevel.setVisible(true);
//			bCardPanel.enterGender.setVisible(true);
//		}

	}
}
