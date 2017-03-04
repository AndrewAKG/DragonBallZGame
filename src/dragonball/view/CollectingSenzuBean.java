package dragonball.view;

import java.awt.Color;
import java.awt.Font;

//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class CollectingSenzuBean extends JFrame {
	private JLabel Info;
	private JLabel Info1;
	private JButton wohoo;
	private ImagePanel zizo;
	private JButton collect;

	public CollectingSenzuBean() {
		this.setLayout(null);
		zizo = new ImagePanel(new ImageIcon("6.jpg").getImage());
		zizo.setLayout(null);
		// zizo.setBounds(500,300,400,130);
		wohoo = new JButton();
		ImageIcon Start = new ImageIcon("Senzu_Bean.png");
		wohoo.setIcon(Start);
		wohoo.setContentAreaFilled(false);
		wohoo.setBorderPainted(false);
		wohoo.setBounds(75, 90, Start.getIconWidth(), Start.getIconHeight());
		
		collect = new JButton();
		collect.setText("COLLECT");
		collect.setForeground(Color.ORANGE);
		collect.setBorder(new LineBorder(Color.ORANGE));
		collect.setContentAreaFilled(false);
		collect.setFont(new Font("Breathe Fire",Font.BOLD,20));
//		collect.setBorderPainted(false);
		collect.setBounds(125, 295, 100, 50);
		String x = "   ....CONGRATULATIONS....";
		String y = "YOU FOUND A SENZU BEAN";
//		System.out.println(x + '\n' + y);
		
		Info = new JLabel();
		Info.setText(x);
		Info.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		Info.setBackground(Color.DARK_GRAY);
		Info.setForeground(Color.ORANGE);
		Info.setSize(350, 100);
		
		Info1 = new JLabel();
		Info1.setText(y);
		Info1.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		Info1.setBackground(Color.DARK_GRAY);
		Info1.setForeground(Color.ORANGE);
		Info1.setBounds(40, 50, 300, 50);
		
		zizo.add(Info);
		zizo.add(wohoo);
		zizo.add(Info1);
		zizo.add(collect);
		this.setContentPane(zizo);
		this.setUndecorated(true);
		this.setBounds(500, 200, 350, 350);
		this.repaint();
		this.validate();
	}

	public JLabel getInfo() {
		return Info;
	}

	public JLabel getInfo1() {
		return Info1;
	}

	public JButton getWohoo() {
		return wohoo;
	}

	public ImagePanel getZizo() {
		return zizo;
	}

	public JButton getCollect() {
		return collect;
	}

	public static void main(String[] args) {
		new CollectingSenzuBean();
	}
}
