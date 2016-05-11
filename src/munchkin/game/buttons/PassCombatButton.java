package munchkin.game.buttons;

import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PassCombatButton extends JButton implements ActionListener{
	
	public boolean lastPass = false;
	public boolean nowPass = false;

	private Game game;
	private MainCardPanel mainCardPanel;
	
	public PassCombatButton(String buttonText, Game game, MainCardPanel panel){
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText(buttonText);
		this.setVisible(false);
		this.setMaximumSize(new Dimension(100,50));

		this.game=game;
		this.mainCardPanel = panel;		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.game.pass();
		this.mainCardPanel.getButtonSet().get("Resolve Conflict").setVisible(false);
		this.setNowPass(true);
		if(this.lastPass && this.nowPass && this.game.getCombat().containsMonster()) {
			this.setVisible(false);
			this.mainCardPanel.getButtonSet().get("Resolve Conflict").setVisible(true);
		}
		this.mainCardPanel.updateLabels();
		this.mainCardPanel.repaintFrame();
	}

	public void setNowPass(boolean pass) {
		this.lastPass = this.nowPass;
		this.nowPass = pass;
	}

}
