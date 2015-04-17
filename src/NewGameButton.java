import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class NewGameButton extends Button implements ActionListener{
	public MFrame frame;
	public ArrayList<String> arrayOfCardLines;
	public Game myGame;
	public Player turnPlayer;
	public NewGameButton(MFrame mframe,ArrayList<String> arrayOfLines,Game game){
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
		}
		else{
			this.turnPlayer=game.p2;
		}
		
		this.frame=mframe;
		this.arrayOfCardLines=arrayOfLines;
		this.myGame=game;
		this.setMaximumSize(new Dimension(100,50));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		
		InitializeCards ic = new InitializeCards(arrayOfCardLines);
		Game newGame = new Game(ic.doors,ic.treasure);
		newGame.shuffle(newGame.doors);
		newGame.shuffle(newGame.treasures);
		
		//ArrayList<Integer> hand = newGame.dealCards();
		this.turnPlayer.pHand=newGame.dealCards();
		ArrayList<Card> deal;
		MFrame newFrame;
		try {
			newFrame = new MFrame(myGame,arrayOfCardLines);
			newFrame.setVisible(true);
			newFrame.setTitle("Munchkin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
