package munchkin.game.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

public class GenderButton extends JButton implements ActionListener {

	private String gender;
	private MainCardPanel mainCardPanel;
	private Game game;
	private String buttonText;

	public GenderButton(String buttonText, Game game, MainCardPanel panel) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText(buttonText);

		this.setMaximumSize(new Dimension(100, 50));

		this.game = game;
		this.mainCardPanel = panel;
		this.buttonText = buttonText;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
				
		this.game.getCurrentPlayer().setGender(this.gender);
		Map<String, JLabel> labelSet = this.mainCardPanel.getLabels();
		Map<String, JButton> buttonSet = this.mainCardPanel.getButtonSet();

		if(!Game.gameSetUp) {
			Game.gameSetUp = true;
			this.game.pass();
			labelSet.get("GenderLabel").setText("Select P2 Gender");
			labelSet.get("GenderLabel").setVisible(true);
			((GenderButton)buttonSet.get("Male")).setMaleGender();
			((GenderButton)buttonSet.get("Female")).setFemaleGender();
			this.mainCardPanel.repaintFrame();
		} else {
			this.game.pass();

			buttonSet.get("Male").setVisible(false);
			buttonSet.get("Female").setVisible(false);
			buttonSet.get("Draw Card").setVisible(true);
			buttonSet.get("Pass Combat").setVisible(false);
			buttonSet.get("Sell Gold").setVisible(true);
			buttonSet.get("Discard").setVisible(false);
			buttonSet.get("Play Card").setVisible(true);

			
			labelSet.get("PlayerLabel").setVisible(true);
			labelSet.get("PlayerLevelLabel").setVisible(true);
			labelSet.get("CombatLevelLabel").setVisible(true);
			labelSet.get("MonsterLevelLabel").setVisible(true);
			labelSet.get("GenderLabel").setVisible(false);

		}
	}
	
	public void setMaleGender() {
		if(!Game.gameSetUp) {
			super.setText("P1: Male");
			this.game.getCurrentPlayer().setName("P1");
		} else {
			super.setText("P2: Male");
			this.game.getCurrentPlayer().setName("P2");
		}
		this.gender = "Male";
	}
	
	public void setFemaleGender() {
		if(!Game.gameSetUp) {
			super.setText("P1: Female");
			this.game.getCurrentPlayer().setName("P1");
		} else {
			super.setText("P2: Female");
			this.game.getCurrentPlayer().setName("P2");
		}
		this.gender = "Female";
	}
}
