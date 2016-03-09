package src;
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
	private BufferedImage youLoseScreen;
	private BufferedImage youWinScreen;
	public ArrayList<BufferedImage> cardImages= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> cardsInPlayImages = new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> cardsInPlayImages2 = new ArrayList<BufferedImage>();
	public NewGameButton ngb;
	public DrawCardButton dcb;
	public EndTurnButton etb;
	public LetOtherPlayerPlayCardButton loppcb;
	public DiscardButton db;
	public BufferedImage largeCard;
	public int largeCardPos;
	public PlayCardButton pcb;
	public PassCombatButton pass;
	public DidIWinButton diwb;
	public SellGoldButton sgb;
	public DiscardGoldButton dgb;
	public GenderButton mb;
	public GenderButton gb;
	public Player turnPlayer;
	public Player otherPlayer;
	public Game myGame;
	public MFrame myFrame;
	public ArrayList<String> myArrayOfLines;
	public JLabel playerLabel; 
	public JLabel playerLevel;
	public JLabel playerCLevel;
	public JLabel monsterLevel;
	public JLabel diceLevel;
	public JLabel enterGender;

	
	

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
		
		this.diceLevel= new JLabel("number rolled: ");
		this.enterGender = new JLabel("SELECT P1 GENDER");
		this.enterGender.setVisible(true);
		this.addMouseListener(this);
        //SpringLayout layout = new SpringLayout();
        //this.setLayout(null);
        NewGameButton newGameButton= new NewGameButton(game);
        this.ngb=newGameButton;
 
        //ngb.setBounds(0,0,50,50);
		ngb.setPreferredSize(new Dimension(100,30));
		ngb.setLocation(-100,-100);
		this.add(ngb);
		
		this.dcb = new DrawCardButton(game);
		dcb.setPreferredSize(new Dimension (100,30));
		this.add(dcb);
		
		this.pcb= new PlayCardButton(game);
		pcb.setPreferredSize(new Dimension (100,30));
		this.add(pcb);
		
		this.pass = new PassCombatButton(game);
		pass.setPreferredSize(new Dimension (100,30));
		this.pass.setVisible(false);
		this.add(pass);
		
		this.diwb = new DidIWinButton(game);
		diwb.setPreferredSize(new Dimension (100,30));
		this.diwb.setVisible(false);
		this.add(diwb);
		
		
		this.etb=new EndTurnButton(game);
		etb.setPreferredSize(new Dimension(90,30));
		this.etb.setVisible(false);
		this.add(etb);
		
		this.sgb=new SellGoldButton(game);
		sgb.setPreferredSize(new Dimension(90,30));
		this.add(sgb);
		
		
		this.db = new DiscardButton(game);
		this.add(db);
		
		this.dgb = new DiscardGoldButton(game);
		this.add(dgb);
		
		this.mb= new GenderButton(game);
		this.mb.setBoy();
		this.add(mb);
		
		this.gb = new GenderButton(game);
		this.gb.setGirl();
		this.add(gb);
		
		
		
		this.add(playerLabel);
		this.add(playerLevel);
		this.add(playerCLevel);
		this.add(monsterLevel);
		this.add(diceLevel);
		this.diceLevel.setVisible(false);
		
        
		this.dcb.setVisible(false);
		this.pcb.setVisible(false);
		this.sgb.setVisible(false);
		this.db.setVisible(false);
		this.playerLabel.setVisible(false); 
		this.playerLevel.setVisible(false);
		this.playerCLevel.setVisible(false);
		this.monsterLevel.setVisible(false);
		this.enterGender.setVisible(true);
		
		
		
	 }
	 
	 
	 public void paintComponent(Graphics go) {
			cardImages = new ArrayList<BufferedImage>();
			cardsInPlayImages = new ArrayList<BufferedImage>();
			cardsInPlayImages2 = new ArrayList<BufferedImage>();
			super.paintComponents(go);
			
			//if you lose
			if(myGame.currentPlayer.winStatus==-1){
				try {
					youLoseScreen = ImageIO.read(new File ("resources/youlosescreen.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				go.drawImage(youLoseScreen,0,0,1920,1080,null);
			}
			
			else if(myGame.currentPlayer.winStatus==1){
				try {
					youWinScreen = ImageIO.read(new File ("resources/youwinscreen.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				go.drawImage(youWinScreen,0,0,1920,1080,null);
				
			}
			//if you are in play
			else{
				try {
					MunchBanner = ImageIO.read(new File ("resources/munchkin-cthulhu.jpg"));
					
					//i<this.turnPlayer.pHand.size()
					for(int i =0; i<myGame.currentPlayer.pHand.size();i++){
						BufferedImage cardImage = ImageIO.read(new File ("resources/m"+myGame.currentPlayer.pHand.get(i)+".PNG"));
						cardImages.add(cardImage);
					
					}
					
					for(int i =0; i<myGame.currentPlayer.pPlay.size();i++){
						BufferedImage playImage = ImageIO.read(new File("resources/m"+myGame.currentPlayer.pPlay.get(i)+".PNG"));
						cardsInPlayImages.add(playImage);
					}
					
					for(int i =0; i<myGame.otherPlayer.pPlay.size();i++){
						BufferedImage playImage2 = ImageIO.read(new File("resources/m"+myGame.otherPlayer.pPlay.get(i)+".PNG"));
						cardsInPlayImages2.add(playImage2);
					}
					
					
				
				
				} catch (IOException ex) {
					System.out.println("Error reading card file in BottomCardPanel");
					// handle exception...
				}
				//this.setPreferredSize(new Dimension(2000, 1000));
				this.setMinimumSize(new Dimension(2000,500));
				this.setVisible(true);
				//this.repaint();
				
				
				
				//go.drawImage(this.munchkinLogo,0,0,null);
				//go.drawImage(this.cardImage,0,400, 180, 180, null);
				
				//go.drawImage(this.cardImage1,50,0,180,200,null);
				//go.drawImage(this.cardImage2, 60+180,0,180,200,null);
				//go.drawImage(this.cardImage3, 2*(60+180), 0, 180, 200, null);
		//		go.drawImage(MunchBanner,550,0,null);
				
				for(int i =0; i<cardImages.size() && i<8;i++){
					go.drawImage(cardImages.get(i),50+180*i+10*i,750,180,225,null);
				}
				
				//draw extra drawn cards in top right
				for(int i=0;i<cardImages.size()-8;i++){
					if(cardImages.size()>i+8){
						go.drawImage(cardImages.get(i+8),50+180*(8+i)+10*(8+i),170,180,225,null);
					}
				}
//				go.drawImage(cardImages.get(1),50+180*8+10*8,200,360,610,null);
			//
				for(int i =0; i<cardsInPlayImages.size();i++){
					go.drawImage(cardsInPlayImages.get(i),50+100*i,515,180,225,null);
				}
				
				for(int i =0; i<cardsInPlayImages2.size();i++){
					go.drawImage(cardsInPlayImages2.get(i),50+100*i,50,180,225,null);
				}
				
				go.drawImage(largeCard,50+180*8+10*8,400,360,570,null);
				
			}
			
			


		}
	 
	 public void removeETB(){
		 this.etb.setVisible(false);
	
	 }

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(MouseInfo.getPointerInfo().getLocation());
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
			
			//this.repaint();
		}
		
		if(y<425 && y>202){
			if(x>1530 && x<1707){
				if(cardImages.size()>8){
					largeCard=cardImages.get(8);
					largeCardPos=8;
				}
			}
			
			else if(x>1540 && x<1720){
				if(cardImages.size()>9){
					largeCard=cardImages.get(9);
					largeCardPos=9;
				}
			}
		}
		
		if(y>545 && y<770){
			for(int i =0; i<turnPlayer.pPlay.size();i++){
				if(x>50+100*i && x<50+100*i+100){
					largeCard=cardsInPlayImages.get(i);
					largeCardPos=i;
					
				}
			}
			//this.repaint();
			
		}
		//added this to click other cards
		if(y>50 && y<300){
			for(int i =0; i<otherPlayer.pPlay.size();i++){
				if(x>50+100*i && x<50+100*i+100){
					largeCard=cardsInPlayImages2.get(i);
					largeCardPos=i;
					
				}
			}
			//this.repaint();
			
		}
		myGame.mframe.repaint();//This blows everything up...
		
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
