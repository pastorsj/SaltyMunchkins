package munchkin.game.buttons;

import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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
			this.mainCardPanel.repaintFrame();

			buttonSet.get("Male").setVisible(false);
			buttonSet.get("Female").setVisible(false);
			buttonSet.get("Draw Card").setVisible(true);
			buttonSet.get("Pass Combat").setVisible(false);
			buttonSet.get("Sell Gold").setVisible(true);
			buttonSet.get("Discard").setVisible(false);
			buttonSet.get("Play Card").setVisible(true);
			buttonSet.get("New Game").setVisible(true);

			
			labelSet.get("PlayerLabel").setVisible(true);
			labelSet.get("PlayerLevelLabel").setVisible(true);
			labelSet.get("CombatLevelLabel").setVisible(true);
			labelSet.get("MonsterLevelLabel").setVisible(true);
			labelSet.get("MonsterLevelLabel").setVisible(true);
			labelSet.get("FactionLabel").setVisible(true);
			labelSet.get("DiscardGoldLabel").setVisible(true);
			labelSet.get("GenderLabel").setVisible(true);

			this.mainCardPanel.updateLabels();
			this.mainCardPanel.repaintFrame();

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
		this.game.getCurrentPlayer().setGender("Male");
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
		this.game.getCurrentPlayer().setGender("Female");
		this.gender = "Female";
	}
}
