import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class NewGameButton extends Button implements ActionListener{
	public MFrame frame;
	public ArrayList<String> arrayOfCardLines;
	public NewGameButton(MFrame mframe,ArrayList<String> arrayOfLines){
		this.frame=mframe;
		this.arrayOfCardLines=arrayOfLines;
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
		
		ArrayList<Integer> hand = newGame.dealCards();
		ArrayList<Card> deal;
		MFrame newFrame;
		try {
			newFrame = new MFrame(hand,arrayOfCardLines);
			newFrame.setVisible(true);
			newFrame.setTitle("Munchkin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}