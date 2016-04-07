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
	private String buttonText;
	
	public PassCombatButton(String buttonText, Game game, MainCardPanel panel){
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("Pass");//Should be just Switch Sides
		this.setVisible(false);
		this.setMaximumSize(new Dimension(100,50));

		this.game=game;
		this.mainCardPanel = panel;
		this.buttonText = buttonText;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//TODO
		
//		myGame.changePlayer();
//		myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(false);
//		
//		
//		myGame.mframe.mainPanel.bCardPanel.pass.lastPass=
//				this.myGame.mframe.mainPanel.bCardPanel.pass.nowPass;
//		myGame.mframe.mainPanel.bCardPanel.pass.nowPass=true;
//		
//		if(myGame.mframe.mainPanel.bCardPanel.pass.lastPass&&
//				myGame.mframe.mainPanel.bCardPanel.pass.nowPass && 
//				myGame.currentPlayer.monster){
//			System.out.println("last and now pass both true");
//			myGame.mframe.mainPanel.bCardPanel.pass.setVisible(false);
//			myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(true);
//			myGame.mframe.revalidate();
//			myGame.mframe.repaint();
//		}
//		
//
//		//game.mframe.dispose();
//		
//		
//		//game.mframe=new MFrame(game);
//		myGame.mframe.revalidate();
//		myGame.mframe.repaint();
		
		
		
	}

}
