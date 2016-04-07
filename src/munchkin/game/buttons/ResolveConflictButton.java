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
	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;
	public Game game;
	private String buttonText;
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
	
	/*
	 * This is the Resolve fight button
	 * This must be changed later
	 */
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.mainCardPanel.getButtonSet().get("End Turn").setVisible(true);
		this.mainCardPanel.getButtonSet().get("Pass Combat").setVisible(false);
		this.mainCardPanel.getButtonSet().get("Sell Gold").setVisible(false);
		this.mainCardPanel.getButtonSet().get("Resolve Conflict").setVisible(false);
		
//		this.frame.mainPanel.bCardPanel.etb.setVisible(true);
//		this.frame.mainPanel.bCardPanel.pcb.setVisible(false);
//		this.frame.mainPanel.bCardPanel.sgb.setVisible(false);
//		this.frame.mainPanel.bCardPanel.diwb.setVisible(false);
		
		this.game.getCombat().resolveFight();
		this.mainCardPanel.updateLabels();
		
//		
//		didIWin();
//		this.mLevel=0;
//		this.currentPlayer.monster=false;
//		if(!this.otherPlayer.monster){
//			this.monster=false;
//		}
//		this.currentPlayer.cLevel=this.currentPlayer.pLevel;
		
		
//		this.frame.mainPanel.bCardPanel.playerLevel.setText("player level: " +this.currentPlayer.pLevel);
//		this.frame.mainPanel.bCardPanel.playerCLevel.setText("combat level: " +this.currentPlayer.cLevel);
//		this.frame.mainPanel.bCardPanel.monsterLevel.setText("monster level: " +this.mLevel);
//		
//		this.currentPlayer.cLevel=this.currentPlayer.pLevel;
//		for (int i=0; i<this.currentPlayer.pPlay.size();i++){
//			
//			this.currentPlayer.cLevel+=this.ic.getCardHash().get(this.currentPlayer.pPlay.get(i)).pLevelBonus;
//			this.frame.mainPanel.bCardPanel.playerCLevel.setText("combat level: " +this.currentPlayer.cLevel);
//		}
//		System.out.println("new clevel: "+this.currentPlayer.cLevel);
		
		
		//TODO: Repaint and Revalidate
//		if(this.currentPlayer.pLevel>=10){
//			this.currentPlayer.winStatus=1;
//		}
//		this.frame.revalidate();
//		this.frame.repaint();
			
	}
	

}
