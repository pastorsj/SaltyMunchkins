package src;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GenderButton extends JButton implements ActionListener {

	public Game myGame;
	public String gender;
	private BottomCardPanel bCardPanel;

	public GenderButton(Game game) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));

		this.setMaximumSize(new Dimension(100, 50));

		this.myGame = game;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		bCardPanel = myGame.mframe.mainPanel.bCardPanel;
		
		if (this.gender == "Male") {
			myGame.currentPlayer.gender = 'M';

		}

		else if (this.gender == "Female") {
			myGame.currentPlayer.gender = 'F';

		}

		else {
			System.out.println("NO GENDER MATCH");
		}

		if (myGame.flag == 0) {
			myGame.flag = 1;
			System.out.println("Got to set flag to 1");
			myGame.changePlayer();
			bCardPanel.enterGender.setText("SELECT P2 GENDER");
			bCardPanel.enterGender.setVisible(true);
			bCardPanel.mb.setBoy();
			bCardPanel.gb.setGirl();
			myGame.mframe.revalidate();
			myGame.mframe.repaint();
		}

		else if (myGame.flag == 1) {
			myGame.changePlayer();
			bCardPanel.mb.setVisible(false);
			bCardPanel.gb.setVisible(false);
			bCardPanel.dcb.setVisible(true);
			bCardPanel.pcb.setVisible(true);
			bCardPanel.sgb.setVisible(true);
			bCardPanel.db.setVisible(true);

			bCardPanel.playerLabel.setVisible(true);
			bCardPanel.playerLevel.setVisible(true);
			bCardPanel.playerCLevel.setVisible(true);
			bCardPanel.monsterLevel.setVisible(true);
			bCardPanel.enterGender.setVisible(true);
		}

	}

	public void setBoy() {
		if (myGame.flag == 0) {
			super.setText("P1: Male");
		} else {
			super.setText("P2: Male");
		}
		this.gender = "Male";
	}

	public void setGirl() {
		if (myGame.flag == 0) {
			super.setText("P1: Female");
		} else {
			super.setText("P2: Female");
		}
		this.gender = "Female";
	}

}
