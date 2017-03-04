package dragonball.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sun.applet.Main;


@SuppressWarnings({ "serial", "unused" })
public class DragonBallView extends JFrame {

public DragonBallView(){
	setTitle("DragonBall");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	this.setUndecorated(true);
}

}
