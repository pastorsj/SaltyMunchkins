
import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CardPanel extends Panel {
	
	public JTextArea aboutOrigin;
	public JTextArea aboutDest;
	public JTextArea aboutPOI;

	public CardPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel about = new JLabel("About the Cards:");
		this.add(about,JPanel.CENTER_ALIGNMENT);		
		
		
		//this.aboutOrigin = new JTextArea(5,30);
		//this.aboutDest = new JTextArea(5,30);
		this.aboutOrigin = new JTextArea (5, 30);
		this.aboutDest = new JTextArea (5,30);
		
		aboutOrigin.setLineWrap(true);
		aboutDest.setLineWrap(true);
		
		//aboutOrigin.setMaximumSize(new Dimension(450,75));
		//aboutDest.setMaximumSize(new Dimension(450,75));
		aboutOrigin.setMaximumSize(new Dimension(50,75));
		aboutDest.setMaximumSize(new Dimension(50, 75));
		
		this.add(aboutOrigin);
		this.add(aboutDest);
		
		JLabel poi = new JLabel("Cards:");
		this.add(poi);
		this.aboutPOI = new JTextArea();
		//aboutPOI.setMaximumSize(new Dimension(100,100));
		this.add(aboutPOI);
		//this.add(Box.createRigidArea(new Dimension(5,0)));
		
		JScrollPane scrolly = new JScrollPane(aboutPOI);
		scrolly.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrolly.setMaximumSize(new Dimension(450,320));
		this.add(scrolly);		
	}
	
}
