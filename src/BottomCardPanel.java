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
	public ArrayList<BufferedImage> cardImages= new ArrayList<BufferedImage>();
	
	
	

	//public MapPanel (ButtonPanel bPanel){
	 public BottomCardPanel(ArrayList<Integer> hand){
		super();

        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
    	
		try {
			
			for(int i =0; i<hand.size();i++){
				BufferedImage cardImage = ImageIO.read(new File ("src\\c"+hand.get(i)+".PNG"));
				cardImages.add(cardImage);
			}
			
		
		} catch (IOException ex) {
			System.out.println("Error reading card file in BottomCardPanel");
			// handle exception...
		}
		//this.setPreferredSize(new Dimension(2000, 1000));
		this.setMinimumSize(new Dimension(2000,500));
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
			
			for(int i =0; i<cardImages.size();i++){
				go.drawImage(cardImages.get(i),50+180*i+10*i,500,180,225,null);
			}
			go.drawImage(cardImages.get(1),50+180*8+10*8,200,360,610,null);
		//
			go.drawImage(cardImages.get(1),50+180*8+10*8,200,360,570,null);

			
		//	go.drawImage(this.cardImage1,50,0,180, 225, null);
			//go.drawImage(this.cardImage2,50+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage3, 50+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage4, 50+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage5, 50+180+15+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage6, 50+180+15+180+15+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage7, 50+180+15+180+15+180+15+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage8, 50+180+15+180+15+180+15+180+15+180+15+180+15+180+15,0,180,225,null);

		}

}
