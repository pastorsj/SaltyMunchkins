import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class EndTurnButton extends JButton implements ActionListener{
	
	public Game myGame;
	public EndTurnButton(Game game){
	
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("EndTurn");//Should be just Switch Sides
		//super.setVisible(false);
		this.setVisible(false);
	
		
		this.setMaximumSize(new Dimension(100,50));
	
		this.myGame=game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//if this is not true, then can't end turn. must discard first. 
		if(myGame.currentPlayer.pHand.size()<=8){
			myGame.currentPlayer.drewCard = false;
			myGame.changePlayer();
			if(myGame.currentPlayer.sentCurse){
				myGame.currentPlayer.sentCurse=false;
				myGame.changePlayer();
			}
			
			//
			for (int i=0; i<myGame.currentPlayer.pPlay.size();i++){
				if((myGame.currentPlayer.pPlay.get(i)>=13 && 
						myGame.currentPlayer.pPlay.get(i)<=25) ||
						myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).discard){
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
			myGame.mframe.mainPanel.bCardPanel.etb.setVisible(false);
			myGame.mframe.mainPanel.bCardPanel.pcb.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.sgb.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(false);
			myGame.mframe.mainPanel.bCardPanel.dcb.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.db.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.diceLevel.setVisible(false);

			//myGame.mframe.dispose();
			
			
			//myGame.mframe=new MFrame(myGame);
			myGame.mframe.revalidate();
			myGame.mframe.repaint();
		}
		else{
			System.out.println("Can't end turn; too many cards in hand.");
		}
		
		
		
		
	}

}
