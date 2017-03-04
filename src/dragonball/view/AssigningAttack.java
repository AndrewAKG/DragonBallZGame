package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.player.Player;

@SuppressWarnings("serial")
public class AssigningAttack extends ImagePanel {
	private JComboBox<String> PlayerSuper;
	private JComboBox<String> PlayerUltimate;
	private JComboBox<String> GainedSuper;
	private JComboBox<String> GainedUltimate;
	private JButton ReplaceS;
	private JButton AddS;
	private JButton ReplaceU;
	private JButton AddU;
	private JLabel MY;
	private JLabel MY1;
	private JLabel MY2;
	private JLabel MY3;
	private JButton Back;

	public AssigningAttack(Image img) {
		super(img);
		PlayerSuper = new JComboBox<String>();
		PlayerSuper.setOpaque(false);
		PlayerSuper.setFont(new Font("Breath Fire", Font.BOLD, 20));
		PlayerSuper.setBounds(40, 400, 300, 70);
		PlayerSuper.setForeground(Color.WHITE);
		PlayerSuper.setBackground(new Color(0, 0, 0, 0));
		this.add(PlayerSuper);

		Back = new JButton();
		ImageIcon Start5 = new ImageIcon("BackButton.png");
		Back.setBounds(1220, 10, Start5.getIconWidth(), Start5.getIconHeight());
		Back.setIcon(Start5);
		Back.setContentAreaFilled(false);
		Back.setBorderPainted(false);
		Back.setRolloverEnabled(true);
		Back.setRolloverIcon(new ImageIcon("play2.png"));
		this.add(Back);

		MY = new JLabel();
		MY.setText("PLAYER SUPER ATTACKS");
		MY.setBounds(40, 330, 300, 50);
		MY.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 20));
		MY.setForeground(Color.WHITE);
		this.add(MY);

		MY1 = new JLabel();
		MY1.setText("PLAYER ULTIMATE ATTACKS");
		MY1.setBounds(380, 330, 300, 50);
		MY1.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 20));
		MY1.setForeground(Color.WHITE);
		this.add(MY1);

		MY2 = new JLabel();
		MY2.setText("FIGHTER SUPER ATTACKS");
		MY2.setBounds(720, 330, 300, 50);
		MY2.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 20));
		MY2.setForeground(Color.WHITE);
		this.add(MY2);

		MY3 = new JLabel();
		MY3.setText("FIGHTER ULTIMATE ATTACKS");
		MY3.setBounds(1060, 330, 300, 50);
		MY3.setFont(new Font("Breathe Fire", Font.PLAIN + Font.BOLD, 20));
		MY3.setForeground(Color.WHITE);
		this.add(MY3);

		PlayerUltimate = new JComboBox<String>();
		PlayerUltimate.setOpaque(false);
		PlayerUltimate.setFont(new Font("Breath Fire", Font.BOLD, 20));
		PlayerUltimate.setBounds(380, 400, 300, 70);
		PlayerUltimate.setBackground(new Color(0, 0, 0, 0));
		PlayerUltimate.setForeground(Color.WHITE);
		this.add(PlayerUltimate);

		GainedSuper = new JComboBox<String>();
		GainedSuper.setOpaque(false);
		GainedSuper.setFont(new Font("Breath Fire", Font.BOLD, 20));
		GainedSuper.setBounds(720, 400, 300, 70);
		GainedSuper.setBackground(new Color(0, 0, 0, 0));
		GainedSuper.setForeground(Color.WHITE);
		this.add(GainedSuper);

		GainedUltimate = new JComboBox<String>();
		GainedUltimate.setOpaque(false);
		GainedUltimate.setFont(new Font("Breath Fire", Font.BOLD, 20));
		GainedUltimate.setBounds(1060, 400, 320, 70);
		GainedUltimate.setBackground(new Color(0, 0, 0, 0));
		GainedUltimate.setForeground(Color.WHITE);
		this.add(GainedUltimate);

		ReplaceS = new JButton();
		ReplaceS.setBounds(440, 200, 200, 70);
		ReplaceS.setText("Replace Super Attack");
		ReplaceS.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		ReplaceS.setOpaque(false);
		ReplaceS.setForeground(Color.WHITE);
		ReplaceS.setContentAreaFilled(false);
		ReplaceS.setBorder(new LineBorder(Color.WHITE));
		this.add(ReplaceS);

		AddS = new JButton();
		AddS.setBounds(120, 200, 200, 70);
		AddS.setText("Add Super Attack");
		AddS.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		AddS.setOpaque(false);
		AddS.setForeground(Color.WHITE);
		AddS.setContentAreaFilled(false);
		AddS.setBorder(new LineBorder(Color.WHITE));
		this.add(AddS);

		ReplaceU = new JButton();
		ReplaceU.setBounds(1080, 200, 240, 70);
		ReplaceU.setText("Replace Ultimate Attack");
		ReplaceU.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		ReplaceU.setOpaque(false);
		ReplaceU.setForeground(Color.WHITE);
		ReplaceU.setContentAreaFilled(false);
		ReplaceU.setBorder(new LineBorder(Color.WHITE));
		this.add(ReplaceU);

		AddU = new JButton();
		AddU.setBounds(760, 200, 200, 70);
		AddU.setText("Add Ultimate Attack");
		AddU.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		AddU.setOpaque(false);
		AddU.setForeground(Color.WHITE);
		AddU.setContentAreaFilled(false);
		AddU.setBorder(new LineBorder(Color.WHITE));
		this.add(AddU);
	}

	public void updateMyS(Player player) {
		PlayerSuper.removeAllItems();
		for (int i = 0; i < player.getSuperAttacks().size(); i++) {
			// System.out.println(i);
			// System.out.println(player.getSuperAttacks().get(i).getName() + "
			// " + player.getSuperAttacks().size());
			if (PlayerSuper.getItemCount() < player.getSuperAttacks().size()) {
				PlayerSuper.addItem(player.getSuperAttacks().get(i).getName());
			} else {
				break;
			}
		}
	}

	public void updateMyU(Player player) {
		PlayerUltimate.removeAllItems();
		for (int i = 0; i < player.getUltimateAttacks().size(); i++) {
			if (PlayerUltimate.getItemCount() < player.getUltimateAttacks().size()) {
				PlayerUltimate.addItem(player.getUltimateAttacks().get(i).getName());
			} else {
				break;
			}
		}
	}

	public void updateFoeS(PlayableFighter x) {
		GainedSuper.removeAllItems();
		for (int i = 0; i < x.getSuperAttacks().size(); i++) {
			if (GainedSuper.getItemCount() < x.getSuperAttacks().size()) {
				GainedSuper.addItem(x.getSuperAttacks().get(i).getName());
			} else {
				break;
			}
		}
	}

	public void updateFoeU(PlayableFighter x) {
		GainedUltimate.removeAllItems();
		for (int i = 0; i < x.getUltimateAttacks().size(); i++) {
			if (GainedUltimate.getItemCount() < x.getUltimateAttacks().size()) {
				GainedUltimate.addItem(x.getUltimateAttacks().get(i).getName());
			} else {
				break;
			}
		}
	}

	public JComboBox<String> getPlayerSuper() {
		return PlayerSuper;
	}

	public JComboBox<String> getPlayerUltimate() {
		return PlayerUltimate;
	}

	public JComboBox<String> getFoeSuper() {
		return GainedSuper;
	}

	public JComboBox<String> getFoeUltimate() {
		return GainedUltimate;
	}

	public JButton getReplaceS() {
		return ReplaceS;
	}

	public JButton getAddS() {
		return AddS;
	}

	public JButton getReplaceU() {
		return ReplaceU;
	}

	public JButton getAddU() {
		return AddU;
	}

	public JButton getBack() {
		return Back;
	}

}
