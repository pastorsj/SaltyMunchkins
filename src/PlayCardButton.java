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
	public PlayCardButton(MFrame mframe,ArrayList<String> arrayOfLines,Player player){
		this.frame=mframe;
		this.arrayOfCardLines=arrayOfLines;
		this.turnPlayer=player;
		this.setMaximumSize(new Dimension(100,50));
		this.arrayOfLines=arrayOfLines;
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

		frame.dispose();
		
		
		try {
			frame=new MFrame(turnPlayer,this.arrayOfLines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
