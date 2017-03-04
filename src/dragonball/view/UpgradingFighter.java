package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import dragonball.model.player.Player;

@SuppressWarnings("serial")
public class UpgradingFighter extends ImagePanel {
	private JTextArea Info;
	private JButton UPFH ;
	private JButton UPFBD ;
	private JButton UPFPD ;
	private JButton UPFMS ;
	private JButton UPFMK ;
	private JButton Back ;
	private JButton FighterPhoto ;


	public UpgradingFighter(Image img) {
		super(img);
		Info = new JTextArea();
		Info.setBounds(550, 10, 300, 170);
		Info.setEditable(false);
		Info.setOpaque(false);
		Info.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		Info.setForeground(Color.WHITE);
		this.add(Info);
		
		FighterPhoto = new JButton();
		FighterPhoto.setOpaque(false);
		FighterPhoto.setContentAreaFilled(false);
		FighterPhoto.setBounds(550, 200, 245, 400);
		FighterPhoto.setBorderPainted(false);
		this.add(FighterPhoto);
		
		UPFBD = new JButton();
		UPFBD.setBounds(50, 400, 250, 70);
		UPFBD.setText("UPGRADE Blast Damage");
		UPFBD.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		UPFBD.setOpaque(false);
		UPFBD.setForeground(Color.WHITE);
		UPFBD.setContentAreaFilled(false);
		UPFBD.setBorder(new LineBorder(Color.WHITE));
		this.add(UPFBD);

		UPFH = new JButton();
		UPFH.setBounds(500, 690, 330, 70);
		UPFH.setText("UPGRADE Max Health Points");
		UPFH.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		UPFH.setOpaque(false);
		UPFH.setForeground(Color.WHITE);
		UPFH.setContentAreaFilled(false);
		UPFH.setBorder(new LineBorder(Color.WHITE));
		this.add(UPFH);
		
		UPFPD = new JButton();
		UPFPD.setBounds(30, 600, 300, 70);
		UPFPD.setText("UPGRADE Physical Damage");
		UPFPD.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		UPFPD.setOpaque(false);
		UPFPD.setForeground(Color.WHITE);
		UPFPD.setContentAreaFilled(false);
		UPFPD.setBorder(new LineBorder(Color.WHITE));
		this.add(UPFPD);
		
		UPFMS = new JButton();
		UPFMS.setBounds(1100, 400, 250, 70);
		UPFMS.setText("UPGRADE Max Stamina");
		UPFMS.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		UPFMS.setOpaque(false);
		UPFMS.setForeground(Color.WHITE);
		UPFMS.setContentAreaFilled(false);
		UPFMS.setBorder(new LineBorder(Color.WHITE));
		this.add(UPFMS);

		UPFMK = new JButton();
		UPFMK.setBounds(1100, 600, 250, 70);
		UPFMK.setText("UPGRADE Max Ki");
		UPFMK.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		UPFMK.setOpaque(false);
		UPFMK.setForeground(Color.WHITE);
		UPFMK.setContentAreaFilled(false);
		UPFMK.setBorder(new LineBorder(Color.WHITE));
		this.add(UPFMK);
		
		Back = new JButton();
		ImageIcon Start5 = new ImageIcon("BackButton.png");
		Back.setBounds(1220,10 ,Start5.getIconWidth(), Start5.getIconHeight());
		Back.setIcon(Start5);
		Back.setContentAreaFilled(false);
		Back.setBorderPainted(false);
		Back.setRolloverEnabled(true);
		Back.setRolloverIcon(new ImageIcon("play2.png"));
		this.add(Back);
	}

	public UpgradingFighter(String img) {
		super(img);
	}

	public void addInfo(Player player) {
		String x = "";
		x += "Max HealthPoints :" + player.getActiveFighter().getMaxHealthPoints() + '\n';
		x += "Max Ki :" + player.getActiveFighter().getMaxKi() + '\n';
		x += "Max Stamina :" + player.getActiveFighter().getMaxStamina() + '\n';
		x += "Physical Damage :" + player.getActiveFighter().getPhysicalDamage() + '\n';
		x += "Blast Damage :" + player.getActiveFighter().getBlastDamage() + '\n';
		x += "Ability Points :" + player.getActiveFighter().getAbilityPoints();
		Info.setText(x);
	}

	public JTextArea getInfo() {
		return Info;
	}

	public JButton getUPFH() {
		return UPFH;
	}

	public JButton getUPFBD() {
		return UPFBD;
	}

	public JButton getUPFPD() {
		return UPFPD;
	}

	public JButton getUPFMS() {
		return UPFMS;
	}

	public JButton getUPFMK() {
		return UPFMK;
	}

	public JButton getBack() {
		return Back;
	}

	public JButton getFighterPhoto() {
		return FighterPhoto;
	}
	
//	public static void main(String[] args) {
//		JFrame x =new JFrame();
//		UpgradingFighter z = new UpgradingFighter(new ImageIcon("Shining-spotlight-design-vector-background-02.jpg").getImage());
//		x.setContentPane(z);
//		x.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		x.setVisible(true);
//	}
}
