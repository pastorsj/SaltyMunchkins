import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class BottomCardPanel extends JPanel implements MouseListener{
	//private BufferedImage munchkinLogo;
	private BufferedImage cardImage1;
	private BufferedImage cardImage2;
	private BufferedImage cardImage3;
	private BufferedImage cardImage4;
	private BufferedImage cardImage5;
	private BufferedImage cardImage6;
	private BufferedImage cardImage7;
	private BufferedImage cardImage8;
	private BufferedImage MunchBanner;
	public ArrayList<BufferedImage> cardImages= new ArrayList<BufferedImage>();
	public NewGameButton ngb;
	public NewGameButton ngb2;
	private BufferedImage largeCard;

	
	

	//public MapPanel (ButtonPanel bPanel){
	 public BottomCardPanel(ArrayList<Integer> hand,MFrame frame,ArrayList<String> arrayOfLines){
		super();

		this.addMouseListener(this);
        //SpringLayout layout = new SpringLayout();
        //this.setLayout(null);
        NewGameButton newGameButton= new NewGameButton(frame,arrayOfLines);
        this.ngb=newGameButton;
        this.ngb2 = new NewGameButton(frame, arrayOfLines);
        //ngb.setBounds(0,0,50,50);
		ngb.setPreferredSize(new Dimension(50,50));
		ngb.setLocation(-100,-100);
		  this.add(ngb);
		  
		  this.add(ngb2);
        
    	
		try {
			MunchBanner = ImageIO.read(new File ("src\\munchkin-cthulhu.jpg"));
			for(int i =0; i<hand.size();i++){
				BufferedImage cardImage = ImageIO.read(new File ("src\\m"+hand.get(i)+".PNG"));
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
	//		go.drawImage(MunchBanner,550,0,null);
			
			for(int i =0; i<cardImages.size();i++){
				go.drawImage(cardImages.get(i),50+180*i+10*i,750,180,225,null);
			}
//			go.drawImage(cardImages.get(1),50+180*8+10*8,200,360,610,null);
		//
			go.drawImage(largeCard,50+180*8+10*8,400,360,570,null);

			
		//	go.drawImage(this.cardImage1,50,0,180, 225, null);
			//go.drawImage(this.cardImage2,50+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage3, 50+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage4, 50+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage5, 50+180+15+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage6, 50+180+15+180+15+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage7, 50+180+15+180+15+180+15+180+15+180+15+180+15,0,180,225,null);
		//	go.drawImage(this.cardImage8, 50+180+15+180+15+180+15+180+15+180+15+180+15+180+15,0,180,225,null);

		}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("hello");
		System.out.println(MouseInfo.getPointerInfo().getLocation());
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		
		if(y>780 && y<1006){
			if(x>10 && x<185){
				largeCard=cardImages.get(0);
			}
			else if(x>200 && x<374){
				largeCard=cardImages.get(1);
			}
			
			else if(x>393 && x<564){
				largeCard=cardImages.get(2);
			}
			else if(x>582 && x<753){
				largeCard=cardImages.get(3);
			}
			else if(x>773 && x<946){
				largeCard=cardImages.get(4);
			}
			else if(x>960 && x<1137){
				largeCard=cardImages.get(5);
			}
			else if(x>1151 && x<1324){
				largeCard=cardImages.get(6);
			}
			else if(x>1340 && x<1517){
				largeCard=cardImages.get(7);
			}
		
			else{
				
			}
			
			this.repaint();
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
