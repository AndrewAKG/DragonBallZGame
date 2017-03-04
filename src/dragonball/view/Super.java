package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;

import dragonball.model.dragon.Dragon;
@SuppressWarnings("serial")
public class Super extends JFrame implements ActionListener{
	private JTextArea Info ;
	private ImagePanel ground ;
	private int desiredHeight;
	private int desiredWidth;
	private int x;
	private int y;
	public Super(){
	this.setLayout(null);
	ground = new ImagePanel(new ImageIcon("1 (1).jpg").getImage());
	ground.setLayout(new BorderLayout());
	Info = new JTextArea();
	Info.setEditable(false);
	Info.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
	Info.setOpaque(false);
	Info.setForeground(Color.ORANGE);
	ground.add(Info,BorderLayout.CENTER);
	ground.setOpaque(false);
	this.setContentPane(ground);
	this.setUndecorated(true);
	}
	public void addDInfo(Dragon dragon) {
		String x = "";
		x += "  " + '\n' ;
		x += " " +  1 + " SUPER ATTACK";
		Info.setText(x);
}
	public void setBounds(int x,int y,int width, int height){
		this.x=x+width/2;
		this.y=y+height;
		super.setBounds(x+width/2, y+height,2, 1);
		desiredWidth =width;
		desiredHeight=height;
		Timer t=new Timer(1,this);
		t.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.getHeight()<desiredHeight){
			y=y-1;
			super.setBounds(x,y, this.getWidth(), this.getHeight()+1);
		}
		else{
			if(this.getWidth()<desiredWidth){
				x=x-1;
				super.setBounds(x,y, this.getWidth()+2, this.getHeight());
			}
			else
				((Timer) arg0.getSource()).stop();
		}
		this.repaint();
	}

}
