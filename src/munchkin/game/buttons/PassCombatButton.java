package munchkin.game.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import munchkin.game.Game;
import munchkin.game.MFrame;
import munchkin.game.panels.MainCardPanel;


public class PassCombatButton extends JButton implements ActionListener{
	
	public boolean lastPass = false;
	public boolean nowPass = false;

	private Game game;
	private MainCardPanel mainCardPanel;
	
	public PassCombatButton(String buttonText, Game game, MainCardPanel panel){
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText(buttonText);//Should be just Switch Sides
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
		this.lastPass = this.nowPass;
		this.nowPass = true;
		if(this.lastPass && this.nowPass) {
			this.setVisible(false);
			this.mainCardPanel.getButtonSet().get("Resolve Conflict").setVisible(true);
		}
		this.mainCardPanel.repaintFrame();
	}
	
	public void resetButton() {
		this.lastPass = false;
		this.nowPass = false;
	}

}
