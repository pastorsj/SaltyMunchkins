package munchkin.game.buttons;

import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


public class EndTurnButton extends JButton implements ActionListener{
	
	private Game game;
	private String buttonText;
	private MainCardPanel mainCardPanel;
	
	public EndTurnButton(String buttonText, Game game, MainCardPanel panel){
	
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("EndTurn");
		super.setVisible(false);
		this.setMaximumSize(new Dimension(100,50));
	
		this.game=game;
		this.buttonText = buttonText;
		this.mainCardPanel = panel;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.game.endTurn()) {
			Map<String, JButton> buttonSet = this.mainCardPanel.getButtonSet();
			Map<String, JLabel> labelSet = this.mainCardPanel.getLabels();
			((DiscardGoldButton) buttonSet.get("Discard Gold")).setGoldAmount(0);
			buttonSet.get("End Turn").setVisible(false);
			buttonSet.get("Pass Combat").setVisible(true);
			buttonSet.get("Sell Gold").setVisible(true);
			buttonSet.get("Resolve Conflict").setVisible(false);
			buttonSet.get("Draw Card").setVisible(true);
			buttonSet.get("Discard").setVisible(true);
			labelSet.get("DiceRollLabel").setVisible(false);
			this.mainCardPanel.repaintFrame();
		}
	}
}
