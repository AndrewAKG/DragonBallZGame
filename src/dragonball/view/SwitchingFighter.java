package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JTextArea;

import dragonball.model.character.fighter.PlayableFighter;

//import dragonball.model.character.fighter.Earthling;
//import dragonball.model.character.fighter.Frieza;
//import dragonball.model.character.fighter.Majin;
//import dragonball.model.character.fighter.Namekian;
//import dragonball.model.character.fighter.Saiyan;

@SuppressWarnings("serial")
public class SwitchingFighter extends ImagePanel {
	private JButton Next;
	private JButton ActiveFighter;
	private JLabel choose;
	private JTextArea FighterInfo;
	private JButton picture;
	private int count  ;

	public SwitchingFighter(Image img) {
		super(img);

		this.count = 0;
		choose = new JLabel();
		choose.setBounds(430, 50, 600, 100);
		choose.setText("Choose your Active Fighter");
		choose.setFont(new Font("Breathe Fire", Font.BOLD + Font.PLAIN, 35));
		choose.setForeground(Color.WHITE);
		this.add(choose);

		picture = new JButton();
		picture.setOpaque(false);
		picture.setContentAreaFilled(false);
		picture.setBounds(580, 300, 240, 400);
		picture.setBorderPainted(false);
		this.add(picture);

		FighterInfo = new JTextArea();
		FighterInfo.setBounds(900, 300, 290, 200);
		FighterInfo.setEditable(false);
		FighterInfo.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		FighterInfo.setOpaque(false);
		FighterInfo.setForeground(Color.ORANGE);
		this.add(FighterInfo);

		Next = new JButton();
		ImageIcon Start5 = new ImageIcon("rsz_button-hi.png");
		Next.setBounds(50, 335, Start5.getIconWidth() , Start5.getIconHeight());
		Next.setIcon(Start5);
		Next.setContentAreaFilled(false);
		Next.setBorderPainted(false);
		Next.setRolloverEnabled(true);
		Next.setRolloverIcon(new ImageIcon("rsz_button-hi1.png"));
		this.add(Next);

		ActiveFighter = new JButton();
		ImageIcon Start1 = new ImageIcon("select_button.png");
		ActiveFighter.setBounds(1000, 600, Start1.getIconWidth(), Start1.getIconHeight());
		ActiveFighter.setIcon(Start1);
		ActiveFighter.setContentAreaFilled(false);
		ActiveFighter.setBorderPainted(false);
		ActiveFighter.setRolloverEnabled(true);
		ActiveFighter.setRolloverIcon(new ImageIcon("play5.png"));
		this.add(ActiveFighter);

	}

	public void addInfo(PlayableFighter player) {
		String x = "";
		x += " Name :" + player.getName() + '\n';
		x += " Level :" + player.getLevel() + '\n';
		x += " Max HealthPoints :" + player.getMaxHealthPoints() + '\n';
		x += " Max Ki :" + player.getMaxKi() + '\n';
		x += " Max Stamina :" + player.getMaxStamina() + '\n';
		x += " Physical Damage :" + player.getPhysicalDamage() + '\n';
		x += " Blast Damage :" + player.getBlastDamage() + '\n';
		FighterInfo.setText(x);
	}
 public void Inc(){
	 this.setCount(this.getCount()+1);
 }
	public void DeInc(){
		this.setCount(0);
	}
	public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

	public JButton getNext() {
		return Next;
	}

	public JButton getActiveFighter() {
		return ActiveFighter;
	}

	public JLabel getChoose() {
		return choose;
	}

	public JTextArea getFighterInfo() {
		return FighterInfo;
	}

	public JButton getPicture() {
		return picture;
	}
	
//
//	public static void main(String[] args) {
//
//	}
}
