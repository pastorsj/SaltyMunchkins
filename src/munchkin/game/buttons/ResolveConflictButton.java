package munchkin.game.buttons;

import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


public class ResolveConflictButton extends JButton implements ActionListener{

	private Game game;
	private MainCardPanel mainCardPanel;

	public ResolveConflictButton(String buttonText, Game game, MainCardPanel panel){
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		this.setText(buttonText);
		this.setMaximumSize(new Dimension(100,50));
		this.mainCardPanel = panel;
		this.game=game;
		this.setVisible(false);
		addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Map<String, JButton> buttonSet = this.mainCardPanel.getButtonSet();

		this.game.getCombat().resolveFight();
		if(this.game.getCurrentPlayer().getHand().checkSizeOfHand()) {
			buttonSet.get("Discard").setVisible(true);
		} else {
			buttonSet.get("End Turn").setVisible(true);
		}
		buttonSet.get("Pass Combat").setVisible(false);
		buttonSet.get("Sell Gold").setVisible(false);
		buttonSet.get("Resolve Conflict").setVisible(false);
		this.mainCardPanel.updateLabels();

		if(this.game.checkWin()) {
			//Display Win!!!
		}
		this.mainCardPanel.repaintFrame();

	}


}
