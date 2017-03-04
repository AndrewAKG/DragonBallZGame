package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
//import  com.sun.awt.AWTUtilities;

import java.awt.Font;
//import java.awt.Shape;
//import java.awt.Window;

//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.PlayableFighter;

@SuppressWarnings("serial")
public class ActiveFighterInfo extends JFrame {
	private JTextArea Info;
	private JPanel ground;

	public ActiveFighterInfo() {
		this.setLayout(null);
		ground = new JPanel();
		ground.setLayout(new BorderLayout());
		Info = new JTextArea();
		Info.setEditable(false);
		this.setUndecorated(true);
		Info.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		Info.setOpaque(false);
		Info.setForeground(Color.ORANGE);
		ground.add(Info, BorderLayout.CENTER);
		ground.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setContentPane(ground);
	}

	public void addInfo(PlayableFighter player) {
		String x = "";
		x += " Max HealthPoints :" + player.getMaxHealthPoints() + '\n';
		x += " Max Ki :" + player.getMaxKi() + '\n';
		x += " Max Stamina :" + player.getMaxStamina() + '\n';
		x += " Physical Damage :" + player.getPhysicalDamage() + '\n';
		x += " Blast Damage :" + player.getBlastDamage() + '\n';
		Info.setText(x);
	}

}
