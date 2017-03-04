package dragonball.view;

import java.awt.Color;
import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.Timer;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class CollectingBall extends JFrame {
	private JLabel Info;
	private JLabel Info1;
	private JButton wohoo;
	private ImagePanel zizo;
	private JButton collect;
//	private int desiredHeight;
//	private int desiredWidth;
//	private int x;
//	private int y;

	public CollectingBall() {
		this.setLayout(null);
		zizo = new ImagePanel(new ImageIcon("6.jpg").getImage());
		zizo.setLayout(null);
		// zizo.setBounds(500,300,400,130);
		wohoo = new JButton();
		ImageIcon Start = new ImageIcon("4StarDragonball.png");
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
		String y = "YOU FOUND A DRAGON BALL";
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
//	public void setBounds(int x,int y,int width, int height){
//		this.x=x+width/2;
//		this.y=y+height;
//		super.setBounds(x+width/2, y+height,2, 1);
//		desiredWidth =width;
//		desiredHeight=height;
//		Timer t=new Timer(1,this);
//		t.start();
//	}
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		if(this.getHeight()<desiredHeight){
//			y=y-1;
//			super.setBounds(x,y, this.getWidth(), this.getHeight()+1);
//		}
//		else{
//			if(this.getWidth()<desiredWidth){
//				x=x-1;
//				super.setBounds(x,y, this.getWidth()+2, this.getHeight());
//			}
//			else
//				((Timer) arg0.getSource()).stop();
//		}
//		this.repaint();
//	}
}
