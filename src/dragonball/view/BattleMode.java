package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JProgressBar;
//import javax.swing.JComboBox;
//import javax.swing.JComponent;
//import javax.swing.JProgressBar;
import javax.swing.JTextArea;
//import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.player.Player;

@SuppressWarnings("serial")
public class BattleMode extends ImagePanel {
	private JProgressBar MyHealthBar;
	private JProgressBar MyKiBar;
	private JProgressBar MyStaminaBar;
	private JProgressBar FoeHealthBar;
	private JProgressBar FoeKiBar;
	private JProgressBar FoeStaminaBar;
//	private JTextArea MyKiStamina;
//	private JTextArea FoeKiStamina;
	private JTextArea MyNameLevel;
	private JTextArea foeNameLevel;
	private JTextArea Turn ;
	private JButton MyPic;
	private JButton foePic;
	private JButton use;
	private JButton block;
	private JButton MyPhysicalAttack ;
	private JButton MySuperAttack ;
	private JButton MyUltimateAttack ;
	private JTextArea action ;
//	private JButton FoePhysicalAttack ;
//	private JComboBox<String> attack;
	// private JComponent c;

	// @SuppressWarnings("unchecked")
	public BattleMode(Image img) {
		super(img);
		this.setLayout(null);

		MyNameLevel = new JTextArea();
		MyNameLevel.setBounds(50, 30, 300, 60);
		MyNameLevel.setEditable(false);
		MyNameLevel.setOpaque(false);
		MyNameLevel.setFont(new Font("Breathe Fire", Font.BOLD, 25));
		MyNameLevel.setForeground(Color.WHITE);
		this.add(MyNameLevel);

		foeNameLevel = new JTextArea();
		foeNameLevel.setBounds(1120, 30, 180, 60);
		foeNameLevel.setEditable(false);
		foeNameLevel.setOpaque(false);
		foeNameLevel.setFont(new Font("Breathe Fire", Font.BOLD, 25));
		foeNameLevel.setForeground(Color.WHITE);
		this.add(foeNameLevel);

		Turn = new JTextArea();
		Turn.setBounds(570, 200, 300, 60);
		Turn.setEditable(false);
		Turn.setOpaque(false);
		Turn.setFont(new Font("Breathe Fire", Font.BOLD, 40));
		Turn.setForeground(Color.WHITE);
		this.add(Turn);
		
		action = new JTextArea();
		action.setBounds(550, 600, 300, 700);
		action.setEditable(false);
		action.setOpaque(false);
		action.setFont(new Font("Breathe Fire", Font.BOLD, 25));
		action.setForeground(Color.WHITE);
		this.add(action);

		MyPic = new JButton();
		MyPic.setBounds(50, 300, 300, 400);
		MyPic.setContentAreaFilled(false);
		MyPic.setOpaque(false);
		MyPic.setBorderPainted(false);
		this.add(MyPic);
		
		foePic = new JButton();
		foePic.setOpaque(false);
		foePic.setContentAreaFilled(false);
		foePic.setBounds(1000, 300, 300, 400);
		foePic.setBorderPainted(false);
		this.add(foePic);

		MyHealthBar = new JProgressBar();
		MyHealthBar.setMinimum(0);
		MyHealthBar.setStringPainted(true);
//		MyHealthBar.setOpaque(false);
		MyHealthBar.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		MyHealthBar.setForeground(new Color(198,58,58));
		MyHealthBar.setBackground(Color.BLACK);
		MyHealthBar.setBounds(50, 95, 300, 35);
		add(MyHealthBar);
		
		MyKiBar = new JProgressBar();
		MyKiBar.setMinimum(0);
		MyKiBar.setStringPainted(true);
//		MyKiBar.setOpaque(false);
		MyKiBar.setForeground(new Color(27,229,37));
		MyKiBar.setBackground(Color.BLACK);
		MyKiBar.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		MyKiBar.setBounds(50, 135, 250, 35);
		add(MyKiBar);
		
		MyStaminaBar = new JProgressBar();
		MyStaminaBar.setMinimum(0);
		MyStaminaBar.setStringPainted(true);
//		MyStaminaBar.setOpaque(false);new Color(242,95,14)
		MyStaminaBar.setForeground(Color.ORANGE);
		MyStaminaBar.setBackground(Color.BLACK);
		MyStaminaBar.setBounds(50, 175, 200, 35);
		MyStaminaBar.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		add(MyStaminaBar);
		
//		 MyProgressUI s = new MyProgressUI();
//		 s.paintIndeterminate(getGraphics(), c);
//		 MyHealthBar.setUI(s);
//		 MyHealthBar.setIndeterminate(false);
//
		FoeHealthBar = new JProgressBar();
		FoeHealthBar.setMinimum(0);
		FoeHealthBar.setStringPainted(true);
		FoeHealthBar.setBackground(new Color(198,58,58));
		FoeHealthBar.setForeground(Color.BLACK);
		FoeHealthBar.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		FoeHealthBar.setBounds(1000, 95, 300, 35);
		add(FoeHealthBar);

		FoeKiBar = new JProgressBar();
		FoeKiBar.setMinimum(0);
		FoeKiBar.setStringPainted(true);
		FoeKiBar.setBackground(new Color(27,229,37));
		FoeKiBar.setForeground(Color.BLACK);
		FoeKiBar.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		FoeKiBar.setBounds(1050, 135, 250, 35);
		add(FoeKiBar);
		
		FoeStaminaBar = new JProgressBar();
		FoeStaminaBar.setMinimum(0);
		FoeStaminaBar.setStringPainted(true);
		FoeStaminaBar.setBackground(Color.ORANGE);
		FoeStaminaBar.setForeground(Color.BLACK);
		FoeStaminaBar.setFont(new Font(Font.MONOSPACED, Font.PLAIN + Font.BOLD, 20));
		FoeStaminaBar.setBounds(1100, 175, 200, 35);
		add(FoeStaminaBar);


		use = new JButton();
		use.setBounds(550, 100, 100, 70);
		use.setText("USE");
		use.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		use.setOpaque(false);
		use.setForeground(Color.WHITE);
		use.setContentAreaFilled(false);
		use.setBorder(new LineBorder(Color.WHITE));
		use.setEnabled(false);
		this.add(use);

		block = new JButton();
		block.setBounds(700, 100, 100, 70);
		block.setText("BLOCK");
		block.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		block.setOpaque(false);
		block.setForeground(Color.WHITE);
		block.setContentAreaFilled(false);
		block.setBorder(new LineBorder(Color.WHITE));
		block.setEnabled(false);
		this.add(block);
		
		MyPhysicalAttack = new JButton();
		MyPhysicalAttack.setBounds(450, 10, 150, 70);
		MyPhysicalAttack.setText("Physical Attack");
		MyPhysicalAttack.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		MyPhysicalAttack.setOpaque(false);
		MyPhysicalAttack.setForeground(Color.WHITE);
		MyPhysicalAttack.setContentAreaFilled(false);
		MyPhysicalAttack.setBorder(new LineBorder(Color.WHITE));
		MyPhysicalAttack.setEnabled(false);
		this.add(MyPhysicalAttack);
		
		MySuperAttack = new JButton();
		MySuperAttack.setBounds(610, 10, 150, 70);
		MySuperAttack.setText("Super Attack");
		MySuperAttack.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		MySuperAttack.setOpaque(false);
		MySuperAttack.setForeground(Color.WHITE);
		MySuperAttack.setContentAreaFilled(false);
		MySuperAttack.setBorder(new LineBorder(Color.WHITE));
		MySuperAttack.setEnabled(false);
		this.add(MySuperAttack);
		
		MyUltimateAttack = new JButton();
		MyUltimateAttack.setBounds(770, 10, 150, 70);
		MyUltimateAttack.setText("Ultimate Attack");
		MyUltimateAttack.setFont(new Font("Breathe Fire", Font.BOLD, 20));
		MyUltimateAttack.setOpaque(false);
		MyUltimateAttack.setForeground(Color.WHITE);
		MyUltimateAttack.setContentAreaFilled(false);
		MyUltimateAttack.setBorder(new LineBorder(Color.WHITE));
		MyUltimateAttack.setEnabled(false);
		this.add(MyUltimateAttack);
	}
	
	public JButton getMyPhysicalAttack() {
		return MyPhysicalAttack;
	}

	public JProgressBar getMyKiBar() {
		return MyKiBar;
	}

	public JProgressBar getMyStaminaBar() {
		return MyStaminaBar;
	}

	public JProgressBar getFoeKiBar() {
		return FoeKiBar;
	}

	public JProgressBar getFoeStaminaBar() {
		return FoeStaminaBar;
	}

	public JTextArea getAction() {
		return action;
	}

	public JTextArea getTurn() {
		return Turn;
	}

	public void setTurn(JTextArea turn) {
		Turn = turn;
	}

//	public JButton getFoePhysicalAttack() {
//		return FoePhysicalAttack;
//	}
//	public void updateBar2(int newValue) {
//		FoeHealthBar.setValue(FoeHealthBar.getValue() - newValue);
//	}
	
//	public JTextArea getMyKiStamina() {
//		return MyKiStamina;
//	}
//
//	public JTextArea getFoeKiStamina() {
//		return FoeKiStamina;
//	}

	public JTextArea getMyNameLevel() {
		return MyNameLevel;
	}

	public JTextArea getFoeNameLevel() {
		return foeNameLevel;
	}
//
//	public JTextArea getHealthPointss() {
//		return HealthPointss;
//	}

	public JButton getMyPic() {
		return MyPic;
	}

	public JButton getFoePic() {
		return foePic;
	}

	public JProgressBar getMyHealthBar() {
		return MyHealthBar;
	}
//
	public JProgressBar getFoeHealthBar() {
		return FoeHealthBar;
	}

//	public JTextArea getMyKi() {
//		return MyKiStamina;
//	}
//
//	public JTextArea getFoeKi() {
//		return FoeKiStamina;
//	}

	public JTextArea getMyName() {
		return MyNameLevel;
	}

	public JTextArea getFoeName() {
		return foeNameLevel;
	}

	public JButton getUse() {
		return use;
	}

	public JButton getBlock() {
		return block;
	}

//	public JComboBox<String> getAttack() {
//		return attack;
//	}

	public JButton getMySuperAttack() {
		return MySuperAttack;
	}

	public JButton getMyUltimateAttack() {
		return MyUltimateAttack;
	}

	public void addActiveFighterInfo(Player player) {
		String x = "";
		x += "Name :" + player.getActiveFighter().getName() + '\n';
		x += "Level :" + player.getActiveFighter().getLevel() + '\n';
		MyNameLevel.setText(x);
	}

	public void addFoeInfo(NonPlayableFighter Fighter) {
		String y = "";
		y += "Name :" + Fighter.getName() + '\n';
		y += "Level :" + Fighter.getLevel();
		foeNameLevel.setText(y);
	}

	public void updateAction(String x){
		action.setText(x);
	}

}
