package dragonball.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class GameStarting extends ImagePanel  {
	private JButton GS ;

	public GameStarting(Image img) {
		super(img);
		this.setBounds(0, 0, 1400, 770);
		this.setLayout(null);	
		GS = new JButton();
		ImageIcon Start = new ImageIcon("play4.png");
		GS.setBounds(50, 470, Start.getIconWidth(), Start.getIconHeight());
		GS.setIcon(Start);
//		GS.setRolloverEnabled(true);
//		GS.setRolloverIcon(new ImageIcon("play1.png"));
		GS.setBorderPainted(false);
		GS.setContentAreaFilled(false);
		GS.setRolloverEnabled(true);
		GS.setRolloverIcon(new ImageIcon("b8b43029273905.55eac91c9691c.png"));
		this.add(GS);
		}

	public GameStarting(String img) {
		super(img);
	}

	public JButton getGS() {
		return GS;
	}
	

}
