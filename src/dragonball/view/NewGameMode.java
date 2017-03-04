package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class NewGameMode extends ImagePanel {
	private JLabel choose;
	private JLabel PlayerName;
	private JLabel FighterName;
	private JTextArea PlayerText;
	private JTextArea FighterText;
	private JButton Earthling;
	private JButton Frieza;
	private JButton Majin;
	private JButton Namekian;
	private JButton Saiyan;
	private JButton E;
	private JButton F;
	private JButton M;
	private JButton N;
	private JButton S;

	public NewGameMode(Image img) {
		super(img);
		this.setBounds(0, 0, 1390, 700);
		this.setLayout(null);
		PlayerName = new JLabel();
		PlayerName.setText("PLEASE ENTER YOUR NAME");
		PlayerName.setBounds(20, 30, 400, 50);
		PlayerName.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
		PlayerName.setForeground(Color.WHITE);
		this.add(PlayerName);

		PlayerText = new JTextArea();
		PlayerText.setBounds(440, 40, 200, 30);
		PlayerText.setOpaque(false);
		PlayerText.setBorder(new LineBorder(Color.WHITE));
		PlayerText.setForeground(Color.WHITE);
		PlayerText.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		this.add(PlayerText);

		FighterName = new JLabel();
		FighterName.setText("FIGHTER NAME");
		FighterName.setBounds(700, 30, 240, 50);
		FighterName.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
		FighterName.setForeground(Color.WHITE);
		this.add(FighterName);

		FighterText = new JTextArea();
		FighterText.setBounds(950, 40, 200, 30);
		FighterText.setOpaque(false);
		FighterText.setBorder(new LineBorder(Color.WHITE));
		FighterText.setForeground(Color.WHITE);
		FighterText.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		this.add(FighterText);

		choose = new JLabel();
		choose.setText("CHOOSE YOUR FIGHTER");
		choose.setBounds(500, 60, 400, 100);
		choose.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 30));
		choose.setForeground(Color.WHITE);
		this.add(choose);

		E = new JButton();
		E.setText("EARTHLING");
		E.setContentAreaFilled(false);
		E.setBorderPainted(false);
		E.setBounds(30, 720, 240, 45);
		E.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
		E.setForeground(Color.WHITE);
		this.add(E);

		F = new JButton();
		F.setText("FRIEZA");
		F.setContentAreaFilled(false);
		F.setBorderPainted(false);
		F.setBounds(270, 720, 240, 45);
		F.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
		F.setForeground(Color.WHITE);
		this.add(F);

		M = new JButton();
		M.setText("MAJIN");
		M.setContentAreaFilled(false);
		M.setBorderPainted(false);
		M.setBounds(545, 720, 240, 45);
		M.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
		M.setForeground(Color.WHITE);
		this.add(M);

		N = new JButton();
		N.setText("NAMEKIAN");
		N.setContentAreaFilled(false);
		N.setBorderPainted(false);
		N.setBounds(850, 720, 240, 45);
		N.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
		N.setForeground(Color.WHITE);
		this.add(N);

		S = new JButton();
		S.setText("SAIYAN");
		S.setContentAreaFilled(false);
		S.setBorderPainted(false);
		S.setBounds(1100, 720, 240, 45);
		S.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
		S.setForeground(Color.WHITE);
		this.add(S);

		Earthling = new JButton();
		ImageIcon Start = new ImageIcon("earthling 2.png");
		Earthling.setBounds(30, 315, Start.getIconWidth(), Start.getIconHeight());
		Earthling.setIcon(Start);
		Earthling.setContentAreaFilled(false);
		Earthling.setBorderPainted(false);
		Earthling.setFocusable(true);
		Earthling.setFocusPainted(true);
		// Earthling.setEnabled(false);
		Earthling.setRolloverEnabled(true);
		Earthling.setRolloverIcon(new ImageIcon("earth-on-fire-hd-wallpaper-612x300.png"));
		this.add(Earthling);

		Frieza = new JButton();
		ImageIcon Start1 = new ImageIcon("rsz_friza_1.png");
		Frieza.setBounds(270, 315, Start1.getIconWidth(), Start1.getIconHeight());
		Frieza.setIcon(Start1);
		Frieza.setContentAreaFilled(false);
		Frieza.setBorderPainted(false);
		Frieza.setRolloverEnabled(true);
		Frieza.setRolloverIcon(new ImageIcon("rsz_friza_11.png"));
		this.add(Frieza);

		Majin = new JButton();
		ImageIcon Start2 = new ImageIcon("rsz_majin.png");
		Majin.setBounds(530, 315, Start2.getIconWidth(), Start2.getIconHeight());
		Majin.setIcon(Start2);
		Majin.setContentAreaFilled(false);
		Majin.setBorderPainted(false);
		Majin.setRolloverEnabled(true);
		Majin.setRolloverIcon(new ImageIcon("rsz_majin1.png"));
		this.add(Majin);

		Namekian = new JButton();
		ImageIcon Start3 = new ImageIcon("rsz_namickan.png");
		Namekian.setBounds(840, 315, Start3.getIconWidth(), Start3.getIconHeight());
		Namekian.setIcon(Start3);
		Namekian.setContentAreaFilled(false);
		Namekian.setBorderPainted(false);
		Namekian.setRolloverEnabled(true);
		Namekian.setRolloverIcon(new ImageIcon("rsz_namickan1.png"));
		this.add(Namekian);

		Saiyan = new JButton();
		ImageIcon Start4 = new ImageIcon("rsz_1saiyan.png");
		Saiyan.setBounds(1100, 315, Start4.getIconWidth(), Start4.getIconHeight());
		Saiyan.setIcon(Start4);
		Saiyan.setContentAreaFilled(false);
		Saiyan.setBorderPainted(false);
		Saiyan.setRolloverEnabled(true);
		Saiyan.setRolloverIcon(new ImageIcon("rsz_1saiyan1.png"));
		this.add(Saiyan);

		this.validate();
		this.repaint();
	}

	public NewGameMode(String img) {
		super(img);
		// TODO Auto-generated constructor stub
	}

	public JLabel getChoose() {
		return choose;
	}

	public JLabel getPlayerName() {
		return PlayerName;
	}

	public JTextArea getPlayerText() {
		return PlayerText;
	}

	public JButton getEarthling() {
		return Earthling;
	}

	// public JButton getBack() {
	// return Back;
	// }

	public JButton getFrieza() {
		return Frieza;
	}

	public JButton getMajin() {
		return Majin;
	}

	public JButton getNamekian() {
		return Namekian;
	}

	public JButton getSaiyan() {
		return Saiyan;
	}

	public JButton getE() {
		return E;
	}

	public JButton getF() {
		return F;
	}

	public JButton getM() {
		return M;
	}

	public JButton getN() {
		return N;
	}

	public JButton getS() {
		return S;
	}

	public JLabel getFighterName() {
		return FighterName;
	}

	public JTextArea getFighterText() {
		return FighterText;
	}

}
