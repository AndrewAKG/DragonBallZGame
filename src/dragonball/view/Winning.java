package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Winning extends JFrame {
	private JTextArea message ;
	private JButton Ok ;
public Winning(){
	this.setLayout(new BorderLayout());
	this.setUndecorated(true);
	this.setBounds(480, 300, 480, 150);
	
	message = new JTextArea();
	message.setFont(new Font("Breathe Fire", Font.BOLD, 20));
	message.setBackground(Color.DARK_GRAY);
	message.setForeground(Color.ORANGE);
	message.setSize(350, 100);
	
	Ok = new JButton();
	Ok.setText("OK");
	Ok.setForeground(Color.ORANGE);
	Ok.setBackground(Color.DARK_GRAY);
	Ok.setBorder(new LineBorder(Color.ORANGE));
	Ok.setContentAreaFilled(false);
	Ok.setFont(new Font("Breathe Fire",Font.BOLD,20));
	
	this.setBackground(Color.DARK_GRAY);
	this.add(message,BorderLayout.CENTER);
	this.add(Ok,BorderLayout.SOUTH);
	this.repaint();
	this.validate();
}
public JTextArea getMessage() {
	return message;
}
public JButton getOk() {
	return Ok;
}

}
