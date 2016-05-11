package munchkin.game.panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MunchkinPanel extends JPanel {
	private BufferedImage munchkinLogo;
	//private BufferedImage cardImage;
	
	
	

	//public MapPanel (ButtonPanel bPanel){
	 public MunchkinPanel(){
		super();

        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
    	
		try {
			this.munchkinLogo = ImageIO.read(new File("resources/munchkin-cthulhu.jpg"));
			//this.cardImage = ImageIO.read(new File ("resources/cards.jpg"));
		} catch (IOException ex) {
			System.err.println("Error reading munchkin banner file in Mpanel");
			// handle exception...
		}
		
		this.setVisible(true);
		this.repaint();
		
	 }
	 
	 public void paintComponent(Graphics go) {
			
			super.paintComponents(go);
			
			go.drawImage(this.munchkinLogo,550,0,null);
			//go.drawImage(this.cardImage,0,250,null);
			
		}

}
