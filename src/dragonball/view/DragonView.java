package dragonball.view;

import java.awt.Color;
import java.awt.Font;
//import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

//import javax.swing.JPanel;
@SuppressWarnings("serial")
public class DragonView extends ImagePanel {

	private JButton SenzuBeans;
	private JButton AbilityPoints;
	private JButton superAttack;
	private JButton ultimateAttack; 
	private JTextArea Info ;

	public DragonView(Image img) {
		super(img);
		this.setBounds(0, 0, 1400, 770);
		this.setLayout(null);

		SenzuBeans = new JButton();
		ImageIcon Start = new ImageIcon("4StarDragonball.png");
		SenzuBeans.setIcon(Start);
		SenzuBeans.setContentAreaFilled(false);
		SenzuBeans.setBorderPainted(false);
		SenzuBeans.setBounds(120, 550, Start.getIconWidth(), Start.getIconHeight());
		
		Info = new JTextArea();
		Info.setText("CHOOSE YOUR WISH");
		Info.setEditable(false);
		Info.setFont(new Font("Tribal Dragon", Font.PLAIN + Font.BOLD, 80));
		Info.setOpaque(false);
		Info.setBounds(250,15,900,100);
		Info.setForeground(Color.ORANGE);
		this.add(Info);
		
		AbilityPoints = new JButton();
		AbilityPoints.setIcon(Start);
		AbilityPoints.setContentAreaFilled(false);
		AbilityPoints.setBorderPainted(false);
		AbilityPoints.setBounds(440, 550, Start.getIconWidth(), Start.getIconHeight());
		
		
		
		superAttack = new JButton();
		superAttack.setIcon(Start);
		superAttack.setContentAreaFilled(false);
		superAttack.setBorderPainted(false);
		superAttack.setBounds(760, 550, Start.getIconWidth(), Start.getIconHeight());
		
		
		
		ultimateAttack = new JButton();
		ultimateAttack.setIcon(Start);
		ultimateAttack.setContentAreaFilled(false);
		ultimateAttack.setBorderPainted(false);
		ultimateAttack.setBounds(1080, 550, Start.getIconWidth(), Start.getIconHeight());
		// SenzuBeans.setText("Get Senzu Beans");
		// AbilityPoints.setText("Get Ability Points");
		// superAttack.setText("Get SuperAttack");
		// ultimateAttack.setText("Get UltimateAttack");

		// SenzuBeans.setBounds( );
		// AbilityPoints.setBounds( );
		// superAttack.setBounds( );
		// ultimateAttack.setBounds( );

		this.add(SenzuBeans);
		this.add(superAttack);
		this.add(AbilityPoints);
		this.add(ultimateAttack);

		this.repaint();
		this.validate();

	}

	public JButton getSenzuBeans() {
		return SenzuBeans;
	}

	public JButton getAbilityPoints() {
		return AbilityPoints;
	}

	public JButton getSuperAttack() {
		return superAttack;
	}

	public JButton getUltimateAttack() {
		return ultimateAttack;
	}
	
//public static void main(String[] args) {
//JFrame x = new JFrame();
//DragonView y = new DragonView(new ImageIcon("here goes name bta3 el sora").getImage());
//x.setContentPane(y);
//x.setExtendedState(JFrame.MAXIMIZED_BOTH);
//x.setVisible(true);
//}
}