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
public class CreatingFighter extends ImagePanel  
{
	private JLabel choose ; 
	private JLabel FighterName ;
	private JTextArea FighterText ;
	private JButton Earthling ; 
	private JButton Frieza ;
	private JButton Majin ;
	private JButton Namekian ;
	private JButton Saiyan ; 
	private JLabel E ;
	private JLabel F ;
	private JLabel M ;
	public JLabel getFighterName() {
		return FighterName;
	}

	public JLabel getE() {
		return E;
	}

	public JLabel getF() {
		return F;
	}

	public JLabel getM() {
		return M;
	}

	public JLabel getN() {
		return N;
	}

	public JLabel getS() {
		return S;
	}

	private JLabel N ;
	private JLabel S ;
//	private JButton Back ;

		public CreatingFighter(Image img) {
			super(img);
			this.setBounds(0, 0, 1400, 770);
			this.setLayout(null);
			
			FighterName = new JLabel();
			FighterName.setText("FIGHTER NAME");
//			FighterName.setContentAreaFilled(false);
//			FighterName.setBorderPainted(false);
			FighterName.setBounds(500, 30, 240, 50);
			FighterName.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 25));
			FighterName.setForeground(Color.WHITE);
			this.add(FighterName);
			
			FighterText = new JTextArea();
			FighterText.setBounds(760, 40, 200, 30);
			FighterText.setOpaque(false);
			FighterText.setBorder(new LineBorder(Color.WHITE));
			FighterText.setForeground(Color.WHITE);
			FighterText.setFont(new Font(Font.MONOSPACED,Font.PLAIN + Font.BOLD,20));
			this.add(FighterText);
			
			choose = new JLabel();
			choose.setText("CHOOSE YOUR FIGHTER");
//			choose.setContentAreaFilled(false);
//			choose.setBorderPainted(false);
			choose.setBounds(500, 60, 400, 100);
			choose.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 30));
			choose.setForeground(Color.WHITE);
			this.add(choose);
			
			Earthling  = new JButton();
			ImageIcon Start = new ImageIcon("earthling 2.png");
			Earthling.setBounds(30, 320, Start.getIconWidth(), Start.getIconHeight() );
			Earthling.setIcon(Start);
			Earthling.setContentAreaFilled(false);
			Earthling.setBorderPainted(false);
			this.add(Earthling);
			
			Frieza = new JButton();
			ImageIcon Start1 = new ImageIcon("rsz_friza_1.png");
			Frieza.setBounds(270, 320, Start1.getIconWidth(), Start1.getIconHeight());
			Frieza.setIcon(Start1);
			Frieza.setContentAreaFilled(false);
			Frieza.setBorderPainted(false);
			this.add(Frieza);

			Majin = new JButton();
			ImageIcon Start2 = new ImageIcon("rsz_majin.png");
			Majin.setBounds(530, 320, Start2.getIconWidth(), Start2.getIconHeight());
			Majin.setIcon(Start2);
			Majin.setContentAreaFilled(false);
			Majin.setBorderPainted(false);
			this.add(Majin);
			
			Namekian = new JButton();
			ImageIcon Start3 = new ImageIcon("rsz_namickan.png");
			Namekian.setBounds(840, 320, Start3.getIconWidth(), Start3.getIconHeight());
			Namekian.setIcon(Start3);
			Namekian.setContentAreaFilled(false);
			Namekian.setBorderPainted(false);
			this.add(Namekian);
			
			Saiyan = new JButton();
			ImageIcon Start4 = new ImageIcon("rsz_1saiyan.png");
			Saiyan.setBounds(1100, 320, Start4.getIconWidth(), Start4.getIconHeight());
			Saiyan.setIcon(Start4);
			Saiyan.setContentAreaFilled(false);
			Saiyan.setBorderPainted(false);
			this.add(Saiyan);
			
			 
			E = new JLabel("EARTHLING");
			E.setBounds(60, 720 , 200, 45);
			E.setFont(new Font("Breathe Fire",Font.PLAIN + Font.BOLD , 25));
			E.setForeground(Color.WHITE);
			this.add(E);
			
			 
			F = new JLabel("FRIEZA");
			F.setBounds(340, 720 , 200, 45);
			F.setFont(new Font("Breathe Fire",Font.PLAIN + Font.BOLD , 25));
			F.setForeground(Color.WHITE);
			this.add(F);
			
			 
			M = new JLabel("MAJIN");
			M.setBounds(630, 720 , 200, 45);
			M.setFont(new Font("Breathe Fire",Font.PLAIN + Font.BOLD , 25));
			M.setForeground(Color.WHITE);
			this.add(M);
			
			 
			N = new JLabel("NAMEKIAN");
			N.setBounds(910, 720 , 200, 45);
			N.setFont(new Font("Breathe Fire",Font.PLAIN + Font.BOLD , 25));
			N.setForeground(Color.WHITE);
			this.add(N);
			
			 
			S = new JLabel("SAIYAN");
			S.setBounds(1180, 720 , 200, 45);
			S.setFont(new Font("Breathe Fire",Font.PLAIN + Font.BOLD , 25));
			S.setForeground(Color.WHITE);
			this.add(S);
			
//			Back = new JButton();
//			ImageIcon Start5 = new ImageIcon("rsz_1back_button.png");
//			Back.setBounds(50,10 ,Start5.getIconWidth(), Start5.getIconHeight());
//			Back.setIcon(Start5);
//			Back.setContentAreaFilled(false);
//			Back.setBorderPainted(false);
//			this.add(Back);
			
			this.validate();
			this.repaint();
			}

		public CreatingFighter(String img) {
			super(img);
			// TODO Auto-generated constructor stub
		}

		public JLabel getChoose() {
			return choose;
		}

		public JLabel getPlayerName() {
			return FighterName;
		}

		public JTextArea getFighterText() {
			return FighterText;
		}

		public JButton getEarthling() {
			return Earthling;
		}

//		public JButton getBack() {
//			return Back;
//		}

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


}
