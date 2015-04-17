import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class PlayCardButton extends Button implements ActionListener{
	public MFrame frame;
	public ArrayList<String> arrayOfCardLines;
	public Player turnPlayer;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public PlayCardButton(MFrame mframe,ArrayList<String> arrayOfLines,Game game){
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
		}
		else{
			this.turnPlayer=game.p2;
		}
		
		this.frame=mframe;
		this.arrayOfCardLines=arrayOfLines;
		this.setMaximumSize(new Dimension(100,50));
		this.arrayOfLines=arrayOfLines;
		this.myGame=game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cardToMovePos=this.frame.mainPanel.bCardPanel.largeCardPos;
		System.out.println("cardToMovePos"+cardToMovePos);
		System.out.println("player hand:"+turnPlayer.pHand);
		int cardToMove = turnPlayer.pHand.get(cardToMovePos);
		turnPlayer.pHand.remove(cardToMovePos);
		turnPlayer.pPlay.add(cardToMove);
		
		if(myGame.turnPlayer==1){
			myGame.p1=turnPlayer;
		}
		else{
			myGame.p2=turnPlayer;
		}
		
		
		frame.dispose();
		
		
		try {
			frame=new MFrame(myGame,this.arrayOfLines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
