import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;


public class GenderButton extends JButton implements ActionListener{
	

	public Game myGame;
	public String gender;
	
	public GenderButton(Game game){
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
	
		this.setMaximumSize(new Dimension(100,50));
		
		this.myGame=game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.gender=="Male"){
			myGame.currentPlayer.gender='M';
		
		}
		
		else if(this.gender=="Female"){
			myGame.currentPlayer.gender='F';
	
		}
		
		else{
			System.out.println("NO GENDER MATCH");
		}
		
		if(myGame.flag==0){
			myGame.flag=1;
			System.out.println("Got to set flag to 1");
			myGame.changePlayer();
			myGame.mframe.mainPanel.bCardPanel.enterGender.setText("SELECT P2 GENDER");
			myGame.mframe.mainPanel.bCardPanel.enterGender.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.mb.setBoy();
			myGame.mframe.mainPanel.bCardPanel.gb.setGirl();
			myGame.mframe.revalidate();
			myGame.mframe.repaint();
		}
		
		else if(myGame.flag==1){
			myGame.changePlayer();
			myGame.mframe.mainPanel.bCardPanel.mb.setVisible(false);
			myGame.mframe.mainPanel.bCardPanel.gb.setVisible(false);
			myGame.mframe.mainPanel.bCardPanel.dcb.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.pcb.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.sgb.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.db.setVisible(true);

			myGame.mframe.mainPanel.bCardPanel.playerLabel.setVisible(true); 
			myGame.mframe.mainPanel.bCardPanel.playerLevel.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.playerCLevel.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.monsterLevel.setVisible(true);
			myGame.mframe.mainPanel.bCardPanel.enterGender.setVisible(true);
			
			
		}
	
		
		
		
	}
	
	public void setBoy(){
		if(myGame.flag==0){
			super.setText("P1: Male");
		}
		else{
			super.setText("P2: Male");
		}
		this.gender="Male";
		
	}
	
	public void setGirl(){
		if(myGame.flag==0){
			super.setText("P1: Female");
		}
		else{
			super.setText("P2: Female");
		}
		this.gender="Female";
	}

}
