import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class BottomCardPanel extends JPanel {
	//private BufferedImage munchkinLogo;
	private BufferedImage cardImage1;
	private BufferedImage cardImage2;
	private BufferedImage cardImage3;
	private BufferedImage cardImage4;
	private BufferedImage cardImage5;
	private BufferedImage cardImage6;
	private BufferedImage cardImage7;
	private BufferedImage cardImage8;
	
	
	

	//public MapPanel (ButtonPanel bPanel){
	 public BottomCardPanel(){
		super();

        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
    	
		try {
			this.cardImage1 = ImageIO.read(new File ("src\\card1.jpg"));
			this.cardImage2 = ImageIO.read(new File ("src\\card2.jpg"));
			this.cardImage3 = ImageIO.read(new File ("src\\card3.jpg"));
			this.cardImage4 = ImageIO.read(new File ("src\\card4.jpg"));
			this.cardImage5 = ImageIO.read(new File ("src\\card5.jpg"));
			this.cardImage6 = ImageIO.read(new File ("src\\card6.jpg"));
			this.cardImage7 = ImageIO.read(new File ("src\\card7.jpg"));
			this.cardImage8 = ImageIO.read(new File ("src\\card8.jpg"));
		} catch (IOException ex) {
			System.out.println("Error reading card file in BottomCardPanel");
			// handle exception...
		}
		this.setPreferredSize(new Dimension(2000, 1000));
		this.setVisible(true);
		this.repaint();
		
	 }
	 
	 public void paintComponent(Graphics go) {
			
			super.paintComponents(go);
			
			//go.drawImage(this.munchkinLogo,0,0,null);
			//go.drawImage(this.cardImage,0,400, 180, 180, null);
			
			//go.drawImage(this.cardImage1,50,0,180,200,null);
			//go.drawImage(this.cardImage2, 60+180,0,180,200,null);
			//go.drawImage(this.cardImage3, 2*(60+180), 0, 180, 200, null);
			
			go.drawImage(this.cardImage1,50,0,180, 225, null);
			go.drawImage(this.cardImage2,50+180+15,0,180,225,null);
			//go.drawImage(this.cardImage2, 50, -200, 180, 225, null);
			go.drawImage(this.cardImage3, 50+180+15+180+15,0,180,225,null);
			go.drawImage(this.cardImage4, 50+180+15+180+15+180+15,0,180,225,null);
			go.drawImage(this.cardImage5, 50+180+15+180+15+180+15+180+15,0,180,225,null);
			go.drawImage(this.cardImage6, 50+180+15+180+15+180+15+180+15+180+15,0,180,225,null);
			go.drawImage(this.cardImage7, 50+180+15+180+15+180+15+180+15+180+15+180+15,0,180,225,null);
			go.drawImage(this.cardImage8, 50+180+15+180+15+180+15+180+15+180+15+180+15+180+15,0,180,225,null);

		}

}
