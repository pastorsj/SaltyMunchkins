import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class EndTurnButton extends JButton implements ActionListener{


	public Player turnPlayer;
	
	public Game myGame;
	public EndTurnButton(Game game){
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
			//need to set the current player to equal game.p1, then set turn player to be current player
		}
		else{
			this.turnPlayer=game.p2;
			//Same as above, except set current player to equal game.p2
		}
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("EndTurn");//Should be just Switch Sides
		//super.setVisible(false);
	
		
		this.setMaximumSize(new Dimension(100,50));
	
		this.myGame=game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(myGame.turnPlayer==1){
			//myGame.turnPlayer=2;
			myGame.changePlayer();
		}
		else{
			//myGame.turnPlayer=1;
			myGame.changePlayer();
		}
		
		for (int i=0; i<myGame.currentPlayer.pPlay.size();i++){
			if(myGame.currentPlayer.pPlay.get(i)>=13 && 
					myGame.currentPlayer.pPlay.get(i)<=25){
				myGame.currentPlayer.pPlay.remove(i);
				i--;
			}
		}
		
		for(int i =0; i<myGame.otherPlayer.pPlay.size();i++){
			if(myGame.otherPlayer.pPlay.get(i)>=13 &&
					myGame.otherPlayer.pPlay.get(i)<=25){
				myGame.otherPlayer.pPlay.remove(i);
				i--;
			}
		}
		
		myGame.mframe.mainPanel.bCardPanel.dgb.goldToDiscard=0;
		myGame.mframe.mainPanel.bCardPanel.etb.setVisible(true);
		myGame.mframe.mainPanel.bCardPanel.pcb.setVisible(true);
		myGame.mframe.mainPanel.bCardPanel.sgb.setVisible(true);
		myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(true);
		//myGame.mframe.dispose();
		
		
		//myGame.mframe=new MFrame(myGame);
		myGame.mframe.revalidate();
		myGame.mframe.repaint();
		
		
		
	}

}
