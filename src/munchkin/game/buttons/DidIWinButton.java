package munchkin.game.buttons;

import munchkin.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class DidIWinButton extends JButton implements ActionListener{
	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	private String buttonText;
	public DidIWinButton(String buttonText, Game game){
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		this.setText(buttonText);
		this.setMaximumSize(new Dimension(100,50));
		this.myGame=game;
		this.setVisible(false);
		addActionListener(this);
	}
	
		
	

	@Override
	public void actionPerformed(ActionEvent arg0) {

		myGame.mframe.mainPanel.bCardPanel.etb.setVisible(true);
		myGame.mframe.mainPanel.bCardPanel.pcb.setVisible(false);
		myGame.mframe.mainPanel.bCardPanel.sgb.setVisible(false);
		myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(false);
		
		didIWin();
		myGame.mLevel=0;
		myGame.currentPlayer.monster=false;
		if(!myGame.otherPlayer.monster){
			myGame.monster=false;
		}
		myGame.currentPlayer.cLevel=myGame.currentPlayer.pLevel;
		myGame.mframe.mainPanel.bCardPanel.playerLevel.setText("player level: " +myGame.currentPlayer.pLevel);
		myGame.mframe.mainPanel.bCardPanel.playerCLevel.setText("combat level: " +myGame.currentPlayer.cLevel);
		myGame.mframe.mainPanel.bCardPanel.monsterLevel.setText("monster level: " +myGame.mLevel);
		
		myGame.currentPlayer.cLevel=myGame.currentPlayer.pLevel;
		for (int i=0; i<myGame.currentPlayer.pPlay.size();i++){
			
			myGame.currentPlayer.cLevel+=myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).pLevelBonus;
			myGame.mframe.mainPanel.bCardPanel.playerCLevel.setText("combat level: " +myGame.currentPlayer.cLevel);
		}
		System.out.println("new clevel: "+myGame.currentPlayer.cLevel);
		
		if(myGame.currentPlayer.pLevel>=10){
			myGame.currentPlayer.winStatus=1;
		}
		//game.mframe.dispose();
		//game.mframe=new MFrame(game);
		myGame.mframe.revalidate();
		myGame.mframe.repaint();
			
	}
	

}
