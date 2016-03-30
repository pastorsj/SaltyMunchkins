package munchkin.game.panels;

import munchkin.api.ICard;
import munchkin.api.IPlayer;
import munchkin.game.Game;
import munchkin.game.MFrame;
import munchkin.game.buttons.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class MainCardPanel extends JPanel implements MouseListener{
	//Current Implementation
	private BufferedImage youLoseScreen;
	private BufferedImage youWinScreen;
	public ArrayList<BufferedImage> cardImages;
	public ArrayList<BufferedImage> cardsInPlayImages;
	public ArrayList<BufferedImage> cardsInPlayImages2;
	public int largeCardPos;
	public BufferedImage largeCard;


	private List<IPlayer> players;
	private Game game;
	private Map<String, JButton> buttons;
	private Map<String, JLabel> labels;
	private Map<String, String> partialLabel;
	private Map<String, BufferedImage> images;
	
	

	 public MainCardPanel(Game game){
		 initializeLabels();
		 initializeButtons();
		 initializeImages();
		 this.game = game;
		 this.updateLabels();
		 addInitialLabelsToPanel();
		 addInitialButtonsToPanel();
		 this.addMouseListener(this);
	 }

	private void initializeImages() {
		try {
			this.images.put("LoserScreen", ImageIO.read(new File("resources/youlosescreen.png")));
			this.images.put("WinnerScreen", ImageIO.read(new File("resources/youwinscreen.jpg")));
			this.images.put("Munchkin Cthulhu", ImageIO.read(new File("resources/munchkin-cthulhu.jpg")));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void addInitialLabelsToPanel() {
		for(String key : this.labels.keySet()) {
			this.add(this.buttons.get(key));
			if(key.equals("GenderLabel")) {
				this.labels.get(key).setVisible(true);
			} else {
				this.labels.get(key).setVisible(false);
			}
		}
	}

	private void addInitialButtonsToPanel() {
		for(String key : this.buttons.keySet()) {
			this.buttons.get(key).setPreferredSize(new Dimension(100, 30));
			this.add(this.buttons.get(key));
			if(!(key.equals("Draw Card") || key.equals("Play Card") || key.equals("Sell Gold") || key.equals("Discard"))) {
				this.buttons.get(key).setVisible(true);
			} else {
				this.buttons.get(key).setVisible(false);
			}
		}
	}

	private void updateLabels() {
		this.labels.get("PlayerLabel").setText("Current Player: " + this.game.getCurrentPlayer().getName());
		this.labels.get("PlayerLevelLabel").setText("Player's Level: " + this.game.getCurrentPlayer().getPlayerLevel());
		this.labels.get("CombatLevelLabel").setText("Player's Combat Level: " + this.game.getCurrentPlayer().getCombatLevel());
		this.labels.get("MonsterLevelLabel").setText("Monster's Level: " + this.game.getCombat().getMonsterLevel());
	}

	public void updateLabel(String label, Integer updatedValue) {
		this.labels.get(label).setText(this.partialLabel.get(label) + updatedValue);
	}

	private void initializeLabels() {
		this.labels = new HashMap<>();
		this.partialLabel = new HashMap<>();
		this.labels.put("PlayerLabel", new JLabel("Current Player: " + this.game.getCurrentPlayer().getName()));
		this.partialLabel.put("PlayerLabel", "Current Player: ");
		this.labels.put("PlayerLevelLabel", new JLabel("Player's Level: " + this.game.getCurrentPlayer().getPlayerLevel()));
		this.partialLabel.put("PlayerLevelLabel", "Player's Level: ");
		this.labels.put("CombatLevelLabel", new JLabel("Player's Combat Level: " + this.game.getCurrentPlayer().getCombatLevel()));
		this.partialLabel.put("CombatLevelLabel", "Player's Combat Level: ");
		this.labels.put("MonsterLevelLabel", new JLabel("Monster's Level: " + this.game.getCombat().getMonsterLevel()));
		this.partialLabel.put("MonsterLevelLabel", "Monster's Level: ");
		this.labels.put("DiceRollLabel", new JLabel("Number Rolled: "));
		this.partialLabel.put("DiceRollLabel", "Number Rolled: ");
		this.labels.put("GenderLabel", new JLabel("Enter Gender: " + this.game.getCurrentPlayer().getName()));
		this.partialLabel.put("GenderLabel", "Enter Gender: ");

	}

	private void initializeButtons() {
		this.buttons = new HashMap<>();
		this.buttons.put("New Game", new NewGameButton("New Game", game));
		this.buttons.put("Draw Card", new DrawCardButton("Draw Card", game));
		this.buttons.put("End Turn", new EndTurnButton("End Turn", game));
		this.buttons.put("Discard", new DiscardButton("Discard", game));
		this.buttons.put("Play Card", new PlayCardButton("Play Card", game));
		this.buttons.put("Pass Combat", new PassCombatButton("Pass Combat", game));
		this.buttons.put("Did I Win?", new DidIWinButton("Did I Win?", game));
		this.buttons.put("Sell Gold", new SellGoldButton("Sell Gold", game));
		this.buttons.put("Discard Gold", new DiscardGoldButton("Discard Gold", game));
		this.buttons.put("Male", new GenderButton("Male", game));
		this.buttons.put("Female", new GenderButton("Female", game));
	}


	public void paintComponent(Graphics g) {
			cardImages = new ArrayList<BufferedImage>();
			cardsInPlayImages = new ArrayList<BufferedImage>();
			cardsInPlayImages2 = new ArrayList<BufferedImage>();
			super.paintComponents(g);
			
			//if you lose
			if(!this.game.getCurrentPlayer().isAlive()){
				g.drawImage(this.images.get("LoserScreen"),0,0,1920,1080,null);
			} else if(game.checkWin()){
				g.drawImage(this.images.get("WinnerScreen"),0,0,1920,1080,null);
			} else{
				try {
					//TODO: Crossroads, rename all images
					MunchBanner = ImageIO.read(new File ("resources/munchkin-cthulhu.jpg"));
					
					//i<this.turnPlayer.pHand.size()
					for(int i = 0; i< game.currentPlayer.pHand.size(); i++){
						BufferedImage cardImage = ImageIO.read(new File ("resources/m"+ game.currentPlayer.pHand.get(i)+".PNG"));
						cardImages.add(cardImage);
					
					}
					
					for(int i = 0; i< game.currentPlayer.pPlay.size(); i++){
						BufferedImage playImage = ImageIO.read(new File("resources/m"+ game.currentPlayer.pPlay.get(i)+".PNG"));
						cardsInPlayImages.add(playImage);
					}
					
					for(int i = 0; i< game.otherPlayer.pPlay.size(); i++){
						BufferedImage playImage2 = ImageIO.read(new File("resources/m"+ game.otherPlayer.pPlay.get(i)+".PNG"));
						cardsInPlayImages2.add(playImage2);
					}
					
					
				
				
				} catch (IOException ex) {
					System.out.println("Error reading card file in MainCardPanel");
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
		game.mframe.repaint();//This blows everything up...
		
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

	public void updateLargeCard(ICard card) {

	}
}
