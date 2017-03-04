package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.border.LineBorder;

import dragonball.model.character.fighter.PlayableFighter;

@SuppressWarnings("serial")
public class AttackingSuper extends JDialog {
private JComboBox<String> S ;
private ImagePanel picture ;
private JButton Attacking ;
private JButton Close ;
public AttackingSuper(){
	this.setLayout(new BorderLayout());
	this.setBounds(400,100,600,500);
	this.setUndecorated(true);
	
	picture = new ImagePanel(new ImageIcon("SuperAttackMenu.png").getImage());
	picture.setLayout(null);
	picture.setSize(600,500);

	
	S = new JComboBox<String>() ;
	S.setOpaque(false);
	S.setFont(new Font("Breath Fire",Font.BOLD,20));
	S.setBounds(200, 100, 200, 70);
	S.setForeground(Color.WHITE);
	S.setBackground(new Color(0,0,0,0));
	
	Attacking = new JButton("Attack");
	Attacking.setFont(new Font("Breathe Fire", Font.BOLD, 20));
	Attacking.setForeground(Color.WHITE);
	Attacking.setBackground(Color.BLACK);
	Attacking.setBounds(250,250,100,70);
	Attacking.setBorder(new LineBorder(Color.WHITE));
	picture.add(Attacking);
	
	Close = new JButton("Close");
    Close.setFont(new Font("Breathe Fire", Font.BOLD, 20));
	Close.setForeground(Color.WHITE);
	Close.setBackground(Color.BLACK);
	Close.setBounds(250,340,100,70);
	Close.setBorder(new LineBorder(Color.WHITE));
	picture.add(Close);
	
	picture.add(S);
	this.setContentPane(picture);
}
public void updateS(PlayableFighter x){
	S.removeAllItems();
	for (int i = 0; i < x.getSuperAttacks().size(); i++) {
		if(S.getItemCount()<x.getSuperAttacks().size()){
//			if((x.getSuperAttacks().get(i).getName()))
		S.addItem(x.getSuperAttacks().get(i).getName());
		}
		else{
			break ;
		}
	}
}
public JComboBox<String> getS() {
	return S;
}
public ImagePanel getPicture() {
	return picture;
}
public JButton getAttacking() {
	return Attacking;
}
public JButton getClose() {
	return Close;
}

}
