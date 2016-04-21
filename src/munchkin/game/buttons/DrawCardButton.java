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


public class DrawCardButton extends JButton implements ActionListener{
	
	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;

	private Game game;
	private String buttonText;
	private MainCardPanel mainCardPanel;
	public DrawCardButton(String buttonText, Game game, MainCardPanel panel){
		
		this.arrayOfCardLines=arrayOfLines;
		this.setMaximumSize(new Dimension(100,50));
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("Draw");//Should be End Turn
		
		this.buttonText = buttonText;
		this.game=game;
		this.mainCardPanel = panel;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			ICard card = this.game.dealNewDoorCard(this.game.getCurrentPlayer());
			if(card != null) {
				this.mainCardPanel.updateLargeCard(card);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mainCardPanel.repaintFrame();
	}

}
