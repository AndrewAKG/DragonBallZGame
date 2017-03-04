package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.player.Player;

@SuppressWarnings("serial")
public class WorldMapView extends ImagePanel {
	private JPanel Map;
	private JButton CF;
	private JButton SF;
	private JTextArea PI;
	private JTextArea FI;
	private JButton ASS;
	// private JButton ASU;
	private JButton UPF;
	private JButton save;
	private JButton Back;

	public WorldMapView(Image img) {
		super(img);
		setBounds(0, 0, 1390, 700);
		this.setLayout(null);

		Map = new JPanel();
		Map.setBounds(0, 5, 1080, 760);
		Map.setLayout(new GridLayout(10, 10));
		Map.setOpaque(false);
		for (int i = 0; i < 100; i++) {
			Map.add(new JButton());
		}
		this.add(Map);

		save = new JButton();
		ImageIcon Start = new ImageIcon("38511319-Save-floppy-disk-icon-pink-square-button-Stock-Photo.png");
		save.setBounds(1120, 5, Start.getIconWidth(), Start.getIconHeight());
		save.setIcon(Start);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		this.add(save);

		Back = new JButton();
		ImageIcon Start5 = new ImageIcon("rsz_button-36980_640.png");
		Back.setBounds(1240, 5, Start5.getIconWidth(), Start5.getIconHeight());
		Back.setIcon(Start5);
		Back.setContentAreaFilled(false);
		Back.setBorderPainted(false);
//		Back.setRolloverEnabled(true);
//		Back.setRolloverIcon(new ImageIcon("play2.png"));
		this.add(Back);

		PI = new JTextArea();
		PI.setEnabled(false);
		PI.setBounds(1090, 100, 300, 100);
		PI.setEditable(false);
		PI.setOpaque(false);
		PI.setFont(new Font("Breathe Fire", Font.PLAIN, 25));
		PI.setForeground(Color.WHITE);
		this.add(PI);

		CF = new JButton();
		CF.setBounds(1090, 210, 300, 70);
		CF.setText("Create Fighter");
		CF.setFont(new Font("Breathe Fire", Font.BOLD, 30));
		CF.setOpaque(false);
		CF.setForeground(Color.WHITE);
		CF.setContentAreaFilled(false);
		CF.setBorder(new LineBorder(Color.WHITE));
		this.add(CF);

		SF = new JButton();
		SF.setBounds(1090, 290, 300, 70);
		SF.setFont(new Font("Breathe Fire", Font.BOLD, 30));
		SF.setOpaque(false);
		SF.setForeground(Color.WHITE);
		SF.setText("Switch Fighter");
		SF.setContentAreaFilled(false);
		SF.setBorder(new LineBorder(Color.WHITE));
		this.add(SF);

		FI = new JTextArea();
		FI.setEnabled(false);
		FI.setBounds(1090, 420, 300, 150);
		FI.setEditable(false);
		FI.setFont(new Font("Breathe Fire", Font.PLAIN, 25));
		FI.setForeground(Color.WHITE);
		FI.setOpaque(false);
		FI.setForeground(Color.WHITE);
		this.add(FI);

		ASS = new JButton();
		ASS.setBounds(1090, 590, 300, 70);
		ASS.setText("Assign Attack");
		ASS.setFont(new Font("Breathe Fire", Font.BOLD, 30));
		ASS.setOpaque(false);
		ASS.setForeground(Color.WHITE);
		ASS.setContentAreaFilled(false);
		ASS.setBorder(new LineBorder(Color.WHITE));
		this.add(ASS);

		// ASU = new JButton();
		// ASU.setBounds(1100, 540, 300, 70);
		// ASU.setText("Assign UltimateAttack");
		// ASU.setFont(new Font("Breathe Fire", Font.BOLD, 30));
		// ASU.setOpaque(false);
		// ASU.setForeground(Color.WHITE);
		// ASU.setContentAreaFilled(false);
		// ASU.setBorder(new LineBorder(Color.WHITE));
		// this.add(ASU);

		UPF = new JButton();
		UPF.setBounds(1090, 670, 300, 70);
		UPF.setText("Upgrade Fighter");
		UPF.setFont(new Font("Breathe Fire", Font.BOLD, 30));
		UPF.setOpaque(false);
		UPF.setForeground(Color.WHITE);
		UPF.setContentAreaFilled(false);
		UPF.setBorder(new LineBorder(Color.WHITE));
		this.add(UPF);

		this.repaint();
		this.validate();
	}

	public JPanel getMap() {
		return Map;
	}
	// public void add(JButton cell){
	// Map.add(cell);
	// }

	public JButton getCF() {
		return CF;
	}

	public JButton getSF() {
		return SF;
	}

	public JTextArea getPI() {
		return PI;
	}

	public JTextArea getFI() {
		return FI;
	}

	public JButton getASS() {
		return ASS;
	}

	public JButton getUPF() {
		return UPF;
	}

	public JButton getSave() {
		return save;
	}

	public JButton getBack() {
		return Back;
	}

	public void addPlayerInfo(Player player) {
		String x = "";
		x += "Player Name :" + player.getName() + '\n';
		x += "Senzu Beans :" + player.getSenzuBeans() + '\n';
		x += "Dragon Balls :" + player.getDragonBalls();
		PI.setText(x);
	}

	public void addFighterInfo(PlayableFighter Fighter) {
		String y = "";
		y += "Fighter Name :" + Fighter.getName() + '\n';
		y += "Level :" + Fighter.getLevel() + '\n';
		y += "XP :" + Fighter.getXp() + '\n';
		y += "Target XP :" + Fighter.getTargetXp() + '\n';
		y += "Ability Points :" + Fighter.getAbilityPoints() ;
		FI.setText(y);
	}
}