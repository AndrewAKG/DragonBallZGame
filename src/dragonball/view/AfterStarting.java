package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AfterStarting extends ImagePanel  {
 private JButton StartGame ;
 private JButton LoadGame ;
 private JButton Exit ;

	public AfterStarting(Image img) {
		super(img);
		this.setBounds(0, 0, 1400, 700);
		this.setLayout(null);	
		
		StartGame = new JButton();
//		ImageIcon Start = new ImageIcon("Amr Game - Copy (2).png");
		StartGame.setBounds(20,500,300,100);
//		StartGame.setIcon(Start);
		StartGame.setText("START GAME");
		StartGame.setFont(new Font("Breathe Fire",Font.PLAIN ,40));
		StartGame.setContentAreaFilled(false);
		StartGame.setBorderPainted(false);
		StartGame.setForeground(Color.WHITE);
		this.add(StartGame);
				
		LoadGame = new JButton();
//		ImageIcon Start1 = new ImageIcon("Amr Game - Copy.png");
		LoadGame.setBounds(1080,500,300,100);
//		LoadGame.setIcon(Start1);
		LoadGame.setText("LOAD GAME");
		LoadGame.setFont(new Font("Breathe Fire",Font.PLAIN ,40));
		LoadGame.setContentAreaFilled(false);
		LoadGame.setForeground(Color.WHITE);
		LoadGame.setBorderPainted(false);
		this.add(LoadGame);
		
		Exit = new JButton();
		ImageIcon Start2 = new ImageIcon("rsz_button-36980_640.png");
		Exit.setBounds(50, 10, Start2.getIconWidth(), Start2.getIconHeight());
		Exit.setIcon(Start2);
		Exit.setContentAreaFilled(false);
		Exit.setBorderPainted(false);
		this.add(Exit);
		
		this.repaint();
		this.validate();
		
	}

	public AfterStarting(String img) {
		super(img);
	}

	public JButton getStartGame() {
		return StartGame;
	}

	public JButton getLoadGame() {
		return LoadGame;
	}

	public JButton getExit() {
		return Exit;
	}
	

}
