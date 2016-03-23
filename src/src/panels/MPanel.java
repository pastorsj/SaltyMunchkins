package src.panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;

import src.Game;
import src.MFrame;

public class MPanel extends JPanel {

	//ButtonPanel bPanel;
	MunchkinPanel munchPanel;
	//DirectionsPanel dPanel;
	public Game myGame;
	public BottomCardPanel bCardPanel;
	public WelcomePanel welcPanel;
	

	public MPanel(MFrame frame, Game game) throws IOException {

		super();
		//this.setPreferredSize(new Dimension(1250, 600));
		
		//this.setPreferredSize(new Dimension (1900, 700));
		this.setPreferredSize(new Dimension (2000, 990));
	


		this.setLayout(new BorderLayout(5,5));
		myGame=game;
		this.bCardPanel = new BottomCardPanel(myGame);
		this.add(bCardPanel, BorderLayout.CENTER);
		this.bCardPanel.setPreferredSize(new Dimension(0, 225));
		this.bCardPanel.setVisible(true);

		//this.dPanel = new DirectionsPanel(bPanel);
	
	//	this.cardPanel = new CardPanel(frame);
		//this.cardPanel.setMaximumSize(new Dimension(200,200));

	//	this.munchPanel = new MunchkinPanel();
	
		//this.bPanel = new ButtonPanel(mPanel, dPanel, pPanel,cities,US);
	
		//this.add(bPanel, BorderLayout.NORTH);
		
		//put these back in
	
	
		
		//this.bCardPanel = new BottomCardPanel(game);
		//this.add(bCardPanel, BorderLayout.CENTER);
		//this.bCardPanel.setPreferredSize(new Dimension(0, 225));
		
		
	
		
		
		//this.add(munchPanel, BorderLayout.CENTER);
		
		//this.add(munchPanel, BorderLayout.NORTH);
		//this.add(munchPanel,BorderLayout.NORTH);
		//this.add(Box.createRigidArea(new Dimension(5,0)));
		
		//this.add(dPanel, BorderLayout.WEST);
//		this.add(cardPanel, BorderLayout.EAST);
		
//		munchPanel.setPreferredSize(new Dimension(75, 240));
		
		
	   // panelCenter.setPreferredSize(new Dimension(panelCenter.getWidth(), 100));
	 
		
		
		
		this.setVisible(true);
	}
	
	public void addBCard(){
		myGame.mframe.mainPanel.bCardPanel = new BottomCardPanel(myGame);
		myGame.mframe.mainPanel.add(bCardPanel, BorderLayout.CENTER);
		myGame.mframe.mainPanel.bCardPanel.setPreferredSize(new Dimension(0, 225));
		
	}
	
	public void addWPanel(){
		myGame.mframe.mainPanel.welcPanel = new WelcomePanel(myGame);
		myGame.mframe.mainPanel.add(welcPanel,BorderLayout.CENTER);
		
	}

//	public void paintComponent(Graphics g) {
//
//	}
}
