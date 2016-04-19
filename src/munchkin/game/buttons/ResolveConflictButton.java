package munchkin.game.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;


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

		this.mainCardPanel.getButtonSet().get("End Turn").setVisible(true);
		this.mainCardPanel.getButtonSet().get("Pass Combat").setVisible(false);
		this.mainCardPanel.getButtonSet().get("Sell Gold").setVisible(false);
		this.mainCardPanel.getButtonSet().get("Resolve Conflict").setVisible(false);
		this.game.getCombat().resolveFight();
		this.mainCardPanel.updateLabels();

		if(this.game.checkWin()) {
			//Display Win!!!
		}
		this.mainCardPanel.repaintFrame();

	}


}
