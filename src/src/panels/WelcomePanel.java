package src.panels;

import java.awt.BorderLayout;
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

import src.Game;
import src.MFrame;

public class WelcomePanel extends JPanel implements MouseListener {
	// private BufferedImage munchkinLogo;

	private BufferedImage MunchBanner;
	private BufferedImage boyCard; // 149
	private BufferedImage girlCard; // 5
	// public NewGameButton ngb;

	public Game myGame;
	public MFrame myFrame;

	public JLabel playerLabel;
	public int flag = 0; // when this is 1, the first person has chosen.

	// public MapPanel (ButtonPanel bPanel){
	public WelcomePanel(Game game) {
		super();
		this.myGame = game;

		// this.myArrayOfLines=arrayOfLines;

		this.playerLabel = new JLabel("Select Gender of Player 1");

		this.addMouseListener(this);
		// SpringLayout layout = new SpringLayout();
		// this.setLayout(null);

		this.add(playerLabel);

	}

	public void paintComponent(Graphics go) {

		super.paintComponents(go);

		// if you are in play

		try {
			MunchBanner = ImageIO.read(new File("resources/munchkin-cthulhu.jpg"));
			boyCard = ImageIO.read(new File("resources/m5.PNG"));
			girlCard = ImageIO.read(new File("resources/m149.PNG"));

		} catch (IOException ex) {
			System.out.println("Error reading card file in WelcomeCardPanel");
			// handle exception...
		}
		// this.setPreferredSize(new Dimension(2000, 1000));
		go.drawImage(MunchBanner, 0, 0, 800, 300, null);
		go.drawImage(boyCard, 990, 75, 180, 225, null);
		go.drawImage(girlCard, 800, 75, 180, 225, null);
		this.setMinimumSize(new Dimension(2000, 500));
		this.setVisible(true);
		// this.repaint();

	}

	public void removeETB() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println(MouseInfo.getPointerInfo().getLocation());
		System.out.println(MouseInfo.getPointerInfo().getLocation());
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		if (y > 106 && y < 327) {
			if (x > 760 && x < 938) {

				if (flag == 0) {
					myGame.p1.gender = 'F';
					myGame.mframe.mainPanel.welcPanel.flag = 1;
					myGame.mframe.mainPanel.welcPanel.playerLabel.setText("Select Gender of Player 2");
					myGame.mframe.revalidate();
					myGame.mframe.repaint();
				} else if (flag == 1) {
					myGame.p2.gender = 'M';
					myGame.mframe.mainPanel.welcPanel.setVisible(false);
					myGame.mframe.mainPanel.bCardPanel.setVisible(true);

					myGame.mframe.revalidate();
					myGame.mframe.repaint();
				}

			}

			else if (x > 951 && x < 1126) {

				if (flag == 0) {
					myGame.p1.gender = 'M';
					myGame.mframe.mainPanel.welcPanel.flag = 1;
					myGame.mframe.mainPanel.welcPanel.playerLabel.setText("Select Gender of Player 2");

					myGame.mframe.revalidate();
					myGame.mframe.repaint();
				} else if (flag == 1) {
					myGame.p2.gender = 'M';
					myGame.mframe.mainPanel.welcPanel.setVisible(false);

					try {
						myGame.mframe.mainPanel = new MPanel(myGame.mframe, myGame);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					myGame.mframe.mainPanel.addBCard();
					System.out.println("added BCARD");
					myGame.mframe.revalidate();
					myGame.mframe.repaint();
				}

			}
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
