import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;

public class PlayCardButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfLines;
	public Game myGame;

	public PlayCardButton(
			Game game) {
		

		String buttonText = "PlayCard";

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText(buttonText);


		this.myGame = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cardToMovePos = myGame.mframe.mainPanel.bCardPanel.largeCardPos;
		int cardToMove = myGame.currentPlayer.pHand.get(cardToMovePos);
		myGame.currentPlayer.pHand.remove(cardToMovePos);
		myGame.currentPlayer.pPlay.add(cardToMove);
		int curHandLevel=0;
		for(int i =0; i<myGame.currentPlayer.pPlay.size();i++){
			curHandLevel+=myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numHands;
		}
		if(curHandLevel>2){
			CardFunc cf = new CardFunc(myGame);
			cf.cantPlay();
		}
		else{
			//at this point, have checked all hands. need to re-execute the others.
			//System.out.println("pPlay is: "+myGame.currentPlayer.pPlay);
			System.out.println("playing card: "+cardToMove);
			myGame.playACard(cardToMove);
			if(myGame.currentPlayer.pPlay.contains(84)){
				myGame.playACard(84);
			}
			
			myGame.mframe.mainPanel.bCardPanel.pass.lastPass=
					myGame.mframe.mainPanel.bCardPanel.pass.nowPass;
			myGame.mframe.mainPanel.bCardPanel.pass.nowPass=false;
			
			if(myGame.monster){
				myGame.mframe.mainPanel.bCardPanel.etb.setVisible(false);
				myGame.mframe.mainPanel.bCardPanel.pass.setVisible(true);
			}
			else{
				myGame.mframe.mainPanel.bCardPanel.etb.setVisible(true);
			}
		}
		
		

		myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(false);
		myGame.mframe.mainPanel.bCardPanel.dcb.setVisible(false);
		myGame.mframe.revalidate();
		myGame.mframe.repaint();
		

	}

}
