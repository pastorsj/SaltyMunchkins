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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.sun.glass.ui.View;



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
	public ArrayList<BufferedImage> cardsInPlayImages = new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> cardsInPlayImages2 = new ArrayList<BufferedImage>();
	public NewGameButton ngb;
	public EndTurnButton etb;
	public LetOtherPlayerPlayCardButton loppcb;
	public DiscardButton db;
	public BufferedImage largeCard;
	public int largeCardPos;
	public PlayCardButton pcb;
	public DidIWinButton diwb;
	public Discard500GoldButton d5gb;
	public Player turnPlayer;
	public Player otherPlayer;
	public Game myGame;
	public MFrame myFrame;
	public ArrayList<String> myArrayOfLines;
	public JLabel playerLabel; 
	public JLabel playerLevel;
	public JLabel playerCLevel;
	public JLabel monsterLevel;
	

	
	

	//public MapPanel (ButtonPanel bPanel){
	 public BottomCardPanel(Game game){
		super();
		this.myGame=game;
		
		//this.myArrayOfLines=arrayOfLines;
	
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
			this.otherPlayer=game.p2;
			this.playerLabel= new JLabel("p1");
			this.playerLevel = new JLabel("player level: "+myGame.p1.pLevel+"");
			this.playerCLevel = new JLabel("player clevel: "+myGame.p1.cLevel+"");
			this.monsterLevel = new JLabel("monster level: "+myGame.mLevel+"");
			
		}
		else{
			this.turnPlayer=game.p2;
			this.otherPlayer=game.p1;
			this.playerLabel= new JLabel("p2");
			this.playerLevel = new JLabel("player level: "+myGame.p2.pLevel+"");
			this.playerCLevel = new JLabel("player clevel: "+myGame.p2.cLevel+"");
			this.monsterLevel = new JLabel("monster level: "+myGame.mLevel+"");
		}
		this.addMouseListener(this);
        //SpringLayout layout = new SpringLayout();
        //this.setLayout(null);
        NewGameButton newGameButton= new NewGameButton(game);
        this.ngb=newGameButton;
 
        //ngb.setBounds(0,0,50,50);
		ngb.setPreferredSize(new Dimension(100,30));
		ngb.setLocation(-100,-100);
		this.add(ngb);
		
		this.pcb= new PlayCardButton(game);
		pcb.setPreferredSize(new Dimension (100,30));
		this.add(pcb);
		
		this.diwb = new DidIWinButton(game);
		diwb.setPreferredSize(new Dimension (100,30));
		this.add(diwb);
		
		
		this.etb=new EndTurnButton(game);
		etb.setPreferredSize(new Dimension(90,30));
		this.add(etb);
		
		
		this.db = new DiscardButton(game);
		this.add(db);
		
		this.d5gb = new Discard500GoldButton(game);
		this.add(d5gb);
		
		
		
		this.add(playerLabel);
		this.add(playerLevel);
		this.add(playerCLevel);
		this.add(monsterLevel);
		
        
    	
		
		
		
		
	 }
	 
	 
	 public void paintComponent(Graphics go) {
			cardImages = new ArrayList<BufferedImage>();
			cardsInPlayImages = new ArrayList<BufferedImage>();
			cardsInPlayImages2 = new ArrayList<BufferedImage>();
			super.paintComponents(go);
			
			try {
				MunchBanner = ImageIO.read(new File ("src\\munchkin-cthulhu.jpg"));
				for(int i =0; i<this.turnPlayer.pHand.size();i++){
					BufferedImage cardImage = ImageIO.read(new File ("src\\m"+this.turnPlayer.pHand.get(i)+".PNG"));
					cardImages.add(cardImage);
				
				}
				
				for(int i =0; i<this.turnPlayer.pPlay.size();i++){
					BufferedImage playImage = ImageIO.read(new File("src\\m"+this.turnPlayer.pPlay.get(i)+".PNG"));
					cardsInPlayImages.add(playImage);
				}
				
				for(int i =0; i<this.otherPlayer.pPlay.size();i++){
					BufferedImage playImage2 = ImageIO.read(new File("src\\m"+this.otherPlayer.pPlay.get(i)+".PNG"));
					cardsInPlayImages2.add(playImage2);
				}
				
				
			
			
			} catch (IOException ex) {
				System.out.println("Error reading card file in BottomCardPanel");
				// handle exception...
			}
			//this.setPreferredSize(new Dimension(2000, 1000));
			this.setMinimumSize(new Dimension(2000,500));
			this.setVisible(true);
			this.repaint();
			
			
			
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
			for(int i =0; i<cardsInPlayImages.size();i++){
				go.drawImage(cardsInPlayImages.get(i),50+100*i,515,180,225,null);
			}
			
			for(int i =0; i<cardsInPlayImages2.size();i++){
				go.drawImage(cardsInPlayImages2.get(i),50+100*i,50,180,225,null);
			}
			
			go.drawImage(largeCard,50+180*8+10*8,400,360,570,null);


		}
	 
	 public void removeETB(){
		 this.etb.setVisible(false);
	
	 }

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println(MouseInfo.getPointerInfo().getLocation());
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		if(y>780 && y<1006){
			if(x>10 && x<185){
				largeCard=cardImages.get(0);
				largeCardPos=0;
			}
			else if(x>200 && x<374){
				if(cardImages.size()>1){
					largeCard=cardImages.get(1);
					largeCardPos=1;
				
				}
				
			}
			
			else if(x>393 && x<564){
				if(cardImages.size()>2){
					largeCard=cardImages.get(2);
					largeCardPos=2;
				}
				
			}
			else if(x>582 && x<753){
				if(cardImages.size()>3){
					largeCard=cardImages.get(3);
					largeCardPos=3;
				}
				
			}
			else if(x>773 && x<946){
				if(cardImages.size()>4){
					largeCard=cardImages.get(4);
					largeCardPos=4;
				}
				
			}
			else if(x>960 && x<1137){
				if(cardImages.size()>5){
					largeCard=cardImages.get(5);
					largeCardPos=5;
				}
				
			}
			else if(x>1151 && x<1324){
				if(cardImages.size()>6){
					largeCard=cardImages.get(6);
					largeCardPos=6;
				}
				
			}
			else if(x>1340 && x<1517){
				if(cardImages.size()>7){
					largeCard=cardImages.get(7);
					largeCardPos=7;
				}
				
			}
		
			else{
				
			}
			
			this.repaint();
		}
		
		if(y>545 && y<770){
			for(int i =0; i<turnPlayer.pPlay.size();i++){
				if(x>50+100*i && x<50+100*i+100){
					largeCard=cardsInPlayImages.get(i);
					largeCardPos=i;
					
				}
			}
			this.repaint();
			
		}
		//added this to click other cards
		if(y>50 && y<300){
			for(int i =0; i<otherPlayer.pPlay.size();i++){
				if(x>50+100*i && x<50+100*i+100){
					largeCard=cardsInPlayImages2.get(i);
					largeCardPos=i;
					
				}
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
