package dragonball.controller;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
//import dragonball.model.attack.PhysicalAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.Ability;
import dragonball.view.ActiveFighterInfo;
import dragonball.view.AfterStarting;
import dragonball.view.AssigningAttack;
import dragonball.view.AttackingSuper;
import dragonball.view.AttackingUltimate;
import dragonball.view.BattleMode;
import dragonball.view.CollectingBall;
import dragonball.view.CollectingSenzuBean;
import dragonball.view.CreatingFighter;
import dragonball.view.DragonBallView;
import dragonball.view.DragonView;
import dragonball.view.GameStarting;
import dragonball.view.Losing;
import dragonball.view.NewGameMode;
import dragonball.view.PlayFoe;
import dragonball.view.Senzu;
import dragonball.view.Super;
import dragonball.view.SwitchingFighter;
import dragonball.view.Ultimate;
import dragonball.view.UpgradingFighter;
import dragonball.view.Winning;
import dragonball.view.WorldMapView;
//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
////import java.applet.Applet;
////import java.applet.AudioClip;
////import java.net.URL;
////import java.io.*;
////import sun.audio.*;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

@SuppressWarnings("serial")
public class DragonBallGUI implements GameListener, ActionListener, KeyListener, MouseListener {

	private Game game;
	private GameStarting Play;
	private AfterStarting New;
	private NewGameMode StartMode;
	private WorldMapView MapView;
	private DragonBallView All;
	private CreatingFighter CreateFighter;
	private BattleMode BattleView;
	private DragonView Dragon;
	private UpgradingFighter UpgradeFighter;
	private ActiveFighterInfo FI;
	private SwitchingFighter Switch;
	private CollectingSenzuBean collects;
	private CollectingBall collectss;
	private Battle CurrentBattle;
	private PlayableFighter X;
	private Senzu FirstWish;
	private Ability SecondWish;
	private Super ThirdWish;
	private Ultimate FourthWish;
	private Dragon Y;
	private AssigningAttack Assign;
	private Winning Wohoo;
	private AttackingSuper AttackS;
	private AttackingUltimate AttackU;
	private Losing Lost;
	private int i = 0;
	private int j = 0;

	public DragonBallGUI() throws MissingFieldException, UnknownAttackTypeException {
		// LetsRock();
		game = new Game();
		game.setListener(this);
		GraphicsEnvironment x = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			x.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Breathe Fire.otf")));
			x.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Tribal Dragon.ttf")));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		All = new DragonBallView();
		Play = new GameStarting(new ImageIcon("b.jpg").getImage());
		Play.getGS().addActionListener(this);
		All.add(Play);

		New = new AfterStarting(new ImageIcon("568200.jpg").getImage());
		New.getStartGame().addMouseListener(this);
		New.getLoadGame().addMouseListener(this);
		New.getStartGame().addActionListener(this);
		New.getLoadGame().addActionListener(this);
		New.getExit().addActionListener(this);

		StartMode = new NewGameMode(new ImageIcon("6814397-universe-wallpaper.jpg").getImage());
		StartMode.getFrieza().addActionListener(this);
		StartMode.getNamekian().addActionListener(this);
		StartMode.getSaiyan().addActionListener(this);
		StartMode.getEarthling().addActionListener(this);
		StartMode.getMajin().addActionListener(this);
		StartMode.getEarthling().addMouseListener(this);
		StartMode.getFrieza().addMouseListener(this);
		StartMode.getNamekian().addMouseListener(this);
		StartMode.getMajin().addMouseListener(this);
		StartMode.getSaiyan().addMouseListener(this);
		StartMode.getE().addMouseListener(this);
		StartMode.getF().addMouseListener(this);
		StartMode.getN().addMouseListener(this);
		StartMode.getM().addMouseListener(this);
		StartMode.getS().addMouseListener(this);

		MapView = new WorldMapView(new ImageIcon("cloud-sky-moon-star.jpg").getImage());
		MapView.getCF().addActionListener(this);
		MapView.getCF().addMouseListener(this);
		MapView.getSave().addActionListener(this);
		MapView.getSF().addActionListener(this);
		MapView.getSF().addMouseListener(this);
		MapView.getASS().addActionListener(this);
		MapView.getASS().addMouseListener(this);
		MapView.getUPF().addActionListener(this);
		MapView.getUPF().addMouseListener(this);
		MapView.getBack().addActionListener(this);

		UpgradeFighter = new UpgradingFighter(
				new ImageIcon("Shining-spotlight-design-vector-background-02.jpg").getImage());
		UpgradeFighter.getUPFH().addActionListener(this);
		UpgradeFighter.getUPFH().addMouseListener(this);
		UpgradeFighter.getUPFBD().addActionListener(this);
		UpgradeFighter.getUPFBD().addMouseListener(this);
		UpgradeFighter.getUPFPD().addActionListener(this);
		UpgradeFighter.getUPFPD().addMouseListener(this);
		UpgradeFighter.getUPFMS().addActionListener(this);
		UpgradeFighter.getUPFMS().addMouseListener(this);
		UpgradeFighter.getUPFMK().addActionListener(this);
		UpgradeFighter.getUPFMK().addMouseListener(this);
		UpgradeFighter.getBack().addActionListener(this);

		All.addKeyListener(this);
		All.setFocusable(true);

		CreateFighter = new CreatingFighter(new ImageIcon("cloudy-dark-sky-and-tower-1024x1024.jpg").getImage());
		CreateFighter.getEarthling().addMouseListener(this);
		CreateFighter.getFrieza().addMouseListener(this);
		CreateFighter.getNamekian().addMouseListener(this);
		CreateFighter.getMajin().addMouseListener(this);
		CreateFighter.getSaiyan().addMouseListener(this);
		CreateFighter.getEarthling().addActionListener(this);
		CreateFighter.getFrieza().addActionListener(this);
		CreateFighter.getMajin().addActionListener(this);
		CreateFighter.getNamekian().addActionListener(this);
		CreateFighter.getSaiyan().addActionListener(this);

		Switch = new SwitchingFighter(new ImageIcon("maxresdefault (1).jpg").getImage());
		Switch.getActiveFighter().addActionListener(this);
		Switch.getNext().addActionListener(this);

		BattleView = new BattleMode(new ImageIcon("136394.jpg").getImage());
		BattleView.getUse().addActionListener(this);
		BattleView.getUse().addMouseListener(this);
		BattleView.getBlock().addActionListener(this);
		BattleView.getBlock().addMouseListener(this);
		BattleView.getMyPhysicalAttack().addActionListener(this);
		BattleView.getMySuperAttack().addActionListener(this);
		BattleView.getMyUltimateAttack().addActionListener(this);
		BattleView.getMyPhysicalAttack().addMouseListener(this);
		BattleView.getMySuperAttack().addMouseListener(this);
		BattleView.getMyUltimateAttack().addMouseListener(this);

		Dragon = new DragonView(new ImageIcon("8J8ycZP.png").getImage());
		Dragon.getSenzuBeans().addMouseListener(this);
		Dragon.getAbilityPoints().addMouseListener(this);
		Dragon.getSuperAttack().addMouseListener(this);
		Dragon.getUltimateAttack().addMouseListener(this);
		Dragon.getSenzuBeans().addActionListener(this);
		Dragon.getAbilityPoints().addActionListener(this);
		Dragon.getSuperAttack().addActionListener(this);
		Dragon.getUltimateAttack().addActionListener(this);

		collects = new CollectingSenzuBean();
		collectss = new CollectingBall();
		collects.getCollect().addActionListener(this);
		collectss.getCollect().addActionListener(this);

		FirstWish = new Senzu();
		SecondWish = new Ability();
		ThirdWish = new Super();
		FourthWish = new Ultimate();

		Assign = new AssigningAttack(new ImageIcon("flames-1208852_960_720.jpg").getImage());
		Assign.getAddS().addActionListener(this);
		Assign.getAddU().addActionListener(this);
		Assign.getReplaceS().addActionListener(this);
		Assign.getReplaceU().addActionListener(this);
		Assign.getBack().addActionListener(this);

		Wohoo = new Winning();
		Wohoo.getOk().addActionListener(this);

		Lost = new Losing();
		Lost.getOk().addActionListener(this);

		AttackS = new AttackingSuper();
		AttackS.getAttacking().addActionListener(this);
		AttackS.getClose().addActionListener(this);

		AttackU = new AttackingUltimate();
		AttackU.getAttacking().addActionListener(this);
		AttackU.getClose().addActionListener(this);

		All.repaint();
		All.validate();
		All.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton play = (JButton) e.getSource();
		if (Play.getGS().equals(play)) {
			All.setContentPane(New);
			All.repaint();
			All.validate();
			return;
		}
		if (All.getContentPane() instanceof AfterStarting) {
			if (New.getStartGame().equals(play)) {
				All.setContentPane(StartMode);
				All.repaint();
				All.validate();
				return;
			}
			if (New.getLoadGame().equals(play)) {
				if (game.getLastSavedFile() == null) {
					JFrame Fstk = new JFrame();
					Fstk.setBounds(200, 222, 500, 200);
					Fstk.setLayout(new BorderLayout());
					JLabel x = new JLabel("You Haven't any saved files yet");
					x.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
					Fstk.add(x, BorderLayout.CENTER);
					Fstk.setVisible(true);
					Fstk.validate();
					Fstk.repaint();
				} else {
					try {
						game.load("soso");
						game.setListener(this);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					this.getMapView().addPlayerInfo(game.getPlayer());
					this.getMapView().addFighterInfo(game.getPlayer().getActiveFighter());
					this.drawMap();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
				}
				return;
			}
			if (New.getExit().equals(play)) {
				JPanel x = new JPanel();
				x.setLayout(new BorderLayout());
				JTextArea z = new JTextArea();
				z.setOpaque(false);
				z.setFont(new Font("Breathe Fire", Font.BOLD, 15));
				z.setText("Would you like to save before exit ?!!");
				x.add(z, BorderLayout.NORTH);
				int l = JOptionPane.showConfirmDialog(null, x);
				if (l == JOptionPane.YES_OPTION) {
					try {
						game.save("soso");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					All.dispose();
				} else {
					if (l == JOptionPane.NO_OPTION) {
						All.dispose();
					}
				}
				return;
			}
		} else if (All.getContentPane() instanceof NewGameMode) {
			if (StartMode.getEarthling().equals(play)) {
				if (!(StartMode.getFighterText().getText().isEmpty()
						|| StartMode.getPlayerText().getText().isEmpty())) {
					game.getPlayer().createFighter('E', StartMode.getFighterText().getText());
					drawMap();
					game.getPlayer().setName(StartMode.getPlayerText().getText());
					MapView.addFighterInfo(game.getPlayer().getActiveFighter());
					MapView.addPlayerInfo(game.getPlayer());
					FI.dispose();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Player and a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (StartMode.getFrieza().equals(play)) {
				if (!(StartMode.getFighterText().getText().isEmpty()
						|| StartMode.getPlayerText().getText().isEmpty())) {
					game.getPlayer().createFighter('F', StartMode.getFighterText().getText());
					drawMap();
					game.getPlayer().setName(StartMode.getPlayerText().getText());
					MapView.addFighterInfo(game.getPlayer().getActiveFighter());
					MapView.addPlayerInfo(game.getPlayer());
					FI.dispose();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Player and a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (StartMode.getMajin().equals(play)) {
				if (!(StartMode.getFighterText().getText().isEmpty()
						|| StartMode.getPlayerText().getText().isEmpty())) {
					game.getPlayer().createFighter('M', StartMode.getFighterText().getText());
					drawMap();
					game.getPlayer().setName(StartMode.getPlayerText().getText());
					MapView.addFighterInfo(game.getPlayer().getActiveFighter());
					MapView.addPlayerInfo(game.getPlayer());
					FI.dispose();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Player and a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (StartMode.getNamekian().equals(play)) {
				if (!(StartMode.getFighterText().getText().isEmpty()
						|| StartMode.getPlayerText().getText().isEmpty())) {
					game.getPlayer().createFighter('N', StartMode.getFighterText().getText());
					drawMap();
					game.getPlayer().setName(StartMode.getPlayerText().getText());
					MapView.addFighterInfo(game.getPlayer().getActiveFighter());
					MapView.addPlayerInfo(game.getPlayer());
					FI.dispose();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Player and a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (StartMode.getSaiyan().equals(play)) {
				if (!(StartMode.getFighterText().getText().isEmpty()
						|| StartMode.getPlayerText().getText().isEmpty())) {
					game.getPlayer().createFighter('S', StartMode.getFighterText().getText());
					drawMap();
					game.getPlayer().setName(StartMode.getPlayerText().getText());
					MapView.addFighterInfo(game.getPlayer().getActiveFighter());
					MapView.addPlayerInfo(game.getPlayer());
					FI.dispose();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Player and a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
		} else if (All.getContentPane() instanceof WorldMapView) {
			if (MapView.getSave().equals(play)) {
				this.setMapView(this.getMapView());
				try {
					this.getGame().save("soso");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JTextArea z = new JTextArea();
				z.setOpaque(false);
				z.setFont(new Font("Breathe Fire", Font.BOLD, 15));
				z.setText("Your game is saved");
				JOptionPane.showMessageDialog(null, z);
				All.setContentPane(this.getMapView());
				All.validate();
				All.repaint();
				return;
			}
			if (MapView.getCF().equals(play)) {
				All.setContentPane(CreateFighter);
				return;
			}
			if (MapView.getUPF().equals(play)) {
				// game.getPlayer().getActiveFighter().setAbilityPoints(4);
				UpgradeFighter.addInfo(game.getPlayer());

				if (game.getPlayer().getActiveFighter() instanceof Earthling) {
					UpgradeFighter.getFighterPhoto().setIcon(new ImageIcon("earthling 2.png"));
				}
				if (game.getPlayer().getActiveFighter() instanceof Frieza) {
					UpgradeFighter.getFighterPhoto().setIcon(new ImageIcon("rsz_friza_1.png"));
				}
				if (game.getPlayer().getActiveFighter() instanceof Majin) {
					UpgradeFighter.getFighterPhoto().setIcon(new ImageIcon("rsz_majin.png"));
				}
				if (game.getPlayer().getActiveFighter() instanceof Namekian) {
					UpgradeFighter.getFighterPhoto().setIcon(new ImageIcon("rsz_namickan.png"));
				}
				if (game.getPlayer().getActiveFighter() instanceof Saiyan) {
					UpgradeFighter.getFighterPhoto().setIcon(new ImageIcon("rsz_1saiyan.png"));
				}
				All.setContentPane(UpgradeFighter);
				All.repaint();
				All.validate();
				return;
			}
			if (MapView.getBack().equals(play)) {
				JPanel x = new JPanel();
				x.setLayout(new BorderLayout());
				JTextArea z = new JTextArea();
				z.setOpaque(false);
				z.setFont(new Font("Breathe Fire", Font.BOLD, 15));
				z.setText("Would you like to save before exit ?!!");
				x.add(z, BorderLayout.NORTH);
				int l = JOptionPane.showConfirmDialog(null, x);
				if (l == JOptionPane.YES_OPTION) {
					try {
						game.save("soso");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					All.dispose();
				} else {
					if (l == JOptionPane.NO_OPTION) {
						All.dispose();
					}
				}
				return;
			}

			if (MapView.getASS().equals(play)) {
				All.setContentPane(Assign);
				All.validate();
				All.repaint();
				return;
			}
			if (MapView.getSF().equals(play)) {
				ArrayList<PlayableFighter> x = new ArrayList<>();
				x = game.getPlayer().getFighters();
				PlayableFighter z = (PlayableFighter) x.get(Switch.getCount());
				if (z instanceof Earthling) {
					Switch.getPicture().setIcon(new ImageIcon("earthling 2.png"));
				}
				if (z instanceof Frieza) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_friza_1.png"));
				}
				if (z instanceof Majin) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_majin.png"));
				}
				if (z instanceof Namekian) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_namickan.png"));
				}
				if (z instanceof Saiyan) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_1saiyan.png"));
				}
				Switch.addInfo(z);
				Switch.Inc();
				if (Switch.getCount() == x.size()) {
					Switch.DeInc();
				}
				All.setContentPane(Switch);
				All.repaint();
				All.validate();
				this.setX(z);
				return;
			}
		} else if (All.getContentPane() instanceof SwitchingFighter) {
			if (Switch.getNext().equals(play)) {
				ArrayList<PlayableFighter> x = new ArrayList<>();
				x = game.getPlayer().getFighters();
				PlayableFighter z = (PlayableFighter) x.get(Switch.getCount());
				if (z instanceof Earthling) {
					Switch.getPicture().setIcon(new ImageIcon("earthling 2.png"));
				}
				if (z instanceof Frieza) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_friza_1.png"));
				}
				if (z instanceof Majin) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_majin.png"));
				}
				if (z instanceof Namekian) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_namickan.png"));
				}
				if (z instanceof Saiyan) {
					Switch.getPicture().setIcon(new ImageIcon("rsz_1saiyan.png"));
				}
				Switch.addInfo(z);
				Switch.Inc();
				if (Switch.getCount() == x.size()) {
					Switch.DeInc();
				}
				this.setX(z);
				return;
			}
			if (Switch.getActiveFighter().equals(play)) {
				game.getPlayer().setActiveFighter(X);
				this.drawMap();
				this.getMapView().addFighterInfo(game.getPlayer().getActiveFighter());
				All.setContentPane(this.getMapView());
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				All.validate();
				All.repaint();
				return;
			}
		} else if (All.getContentPane() instanceof CreatingFighter) {
			if (CreateFighter.getEarthling().equals(play)) {
				if (!(CreateFighter.getFighterText().getText().isEmpty())) {
					game.getPlayer().createFighter('E', CreateFighter.getFighterText().getText());
					this.drawMap();
					FI.dispose();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (CreateFighter.getFrieza().equals(play)) {
				if (!(CreateFighter.getFighterText().getText().isEmpty())) {
					game.getPlayer().createFighter('F', CreateFighter.getFighterText().getText());
					this.drawMap();
					FI.dispose();
					All.setContentPane(this.getMapView());
					// MapView.addFighterInfo(F);
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (CreateFighter.getMajin().equals(play)) {
				if (!(CreateFighter.getFighterText().getText().isEmpty())) {
					game.getPlayer().createFighter('M', CreateFighter.getFighterText().getText());
					this.drawMap();
					FI.dispose();
					All.setContentPane(this.getMapView());
					// MapView.addFighterInfo(M);
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (CreateFighter.getNamekian().equals(play)) {
				if (!(CreateFighter.getFighterText().getText().isEmpty())) {
					game.getPlayer().createFighter('N', CreateFighter.getFighterText().getText());
					this.drawMap();
					FI.dispose();
					All.setContentPane(this.getMapView());
					// MapView.addFighterInfo(N);
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if (CreateFighter.getSaiyan().equals(play)) {
				if (!(CreateFighter.getFighterText().getText().isEmpty())) {
					game.getPlayer().createFighter('S', CreateFighter.getFighterText().getText());
					this.drawMap();
					FI.dispose();
					All.setContentPane(this.getMapView());
					All.repaint();
					All.validate();
					return;
				} else {
					JTextArea f = new JTextArea();
					f.setText("you must enter a Fighter name");
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
			}
		} else if (All.getContentPane() instanceof UpgradingFighter) {
			if (UpgradeFighter.getBack().equals(play)) {
				All.setContentPane(this.getMapView());
				All.repaint();
				All.validate();
				return;
			}
			if ((UpgradeFighter.getUPFH().equals(play))) {
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'H');
					UpgradeFighter.addInfo(game.getPlayer());
				} catch (NotEnoughAbilityPointsException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					f.setOpaque(false);
					JOptionPane.showMessageDialog(null, f);
				}
				return;
			}
			if ((UpgradeFighter.getUPFPD().equals(play))) {
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'P');
					UpgradeFighter.addInfo(game.getPlayer());
				} catch (NotEnoughAbilityPointsException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				return;
			}
			if ((UpgradeFighter.getUPFBD().equals(play))) {
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'B');
					UpgradeFighter.addInfo(game.getPlayer());
				} catch (NotEnoughAbilityPointsException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				return;
			}
			if ((UpgradeFighter.getUPFMK().equals(play))) {
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'K');
					UpgradeFighter.addInfo(game.getPlayer());
				} catch (NotEnoughAbilityPointsException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				return;
			}
			if ((UpgradeFighter.getUPFMS().equals(play))) {
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'S');
					UpgradeFighter.addInfo(game.getPlayer());
				} catch (NotEnoughAbilityPointsException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				return;
			}
		} else if (All.getContentPane() instanceof BattleMode) {
			if (BattleView.getUse().equals(play)) {
				try {
					this.getCurrentBattle().use(game.getPlayer(), Collectible.SENZU_BEAN);
					// BattleView.addMyKs(game.getPlayer());
				} catch (NotEnoughSenzuBeansException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				return;
			}
			if (BattleView.getBlock().equals(play)) {
				this.getCurrentBattle().block();
				return;
			}
			if (BattleView.getMyPhysicalAttack().equals(play)) {
				try {
					if (this.getCurrentBattle().getAttacker().equals(this.getCurrentBattle().getMe())) {
						this.getCurrentBattle().attack(new PhysicalAttack());
					}
				} catch (NotEnoughKiException e1) {
					JTextArea z = new JTextArea();
					z.setText(e1.getMessage());
					z.setOpaque(false);
					z.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, z);
				}
				return;
			}
			if (BattleView.getMySuperAttack().equals(play)) {
				AttackS.updateS(game.getPlayer().getActiveFighter());
				AttackS.setVisible(true);
				return;
			}
			if (BattleView.getMyUltimateAttack().equals(play)) {
				AttackU.updateU(game.getPlayer().getActiveFighter());
				AttackU.setVisible(true);
				return;
			}
		} else if (All.getContentPane() instanceof AssigningAttack) {
			if (Assign.getBack().equals(play)) {
				All.setContentPane(this.getMapView());
				All.validate();
				All.repaint();
			}
			if (Assign.getAddS().equals(play)) {
				String x = (String) Assign.getPlayerSuper().getSelectedItem();
				SuperAttack y = null;
				for (int i = 0; i < game.getPlayer().getSuperAttacks().size(); i++) {
					if (x.equals(game.getPlayer().getSuperAttacks().get(i).getName())) {
						y = game.getPlayer().getSuperAttacks().get(i);
						break;
					}
				}
				try {
					try {
						game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), y, null);
					} catch (NotASaiyanException e1) {
						JTextArea z = new JTextArea();
						z.setText(e1.getMessage());
						z.setOpaque(false);
						z.setFont(new Font("Breathe Fire", Font.BOLD, 20));
						JOptionPane.showMessageDialog(null, z);
					}
				} catch (DuplicateAttackException e1) {
					JTextArea z = new JTextArea();
					z.setText(e1.getMessage());
					z.setOpaque(false);
					z.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, z);
				} catch (MaximumAttacksLearnedException e1) {
					JTextArea z = new JTextArea();
					z.setText(e1.getMessage());
					z.setOpaque(false);
					z.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, z);
				}
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				All.validate();
				All.repaint();
				return;
			}
			if (Assign.getReplaceS().equals(play)) {
				String x = (String) Assign.getPlayerSuper().getSelectedItem();
				String z = (String) Assign.getFoeSuper().getSelectedItem();
				SuperAttack y = null;
				SuperAttack l = null;
				for (int i = 0; i < game.getPlayer().getSuperAttacks().size(); i++) {
					if (x.equals(game.getPlayer().getSuperAttacks().get(i).getName())) {
						y = game.getPlayer().getSuperAttacks().get(i);
						break;
					}
				}
				for (int i = 0; i < game.getPlayer().getActiveFighter().getSuperAttacks().size(); i++) {
					if (z.equals(game.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName())) {
						l = game.getPlayer().getActiveFighter().getSuperAttacks().get(i);
						break;
					}
				}
				try {
					try {
						game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), y, l);
					} catch (NotASaiyanException e1) {
						JTextArea f = new JTextArea();
						f.setText(e1.getMessage());
						f.setOpaque(false);
						f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
						JOptionPane.showMessageDialog(null, f);
					}
				} catch (DuplicateAttackException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				} catch (MaximumAttacksLearnedException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				All.validate();
				All.repaint();
				return;
			}
			if (Assign.getAddU().equals(play)) {
				String x = (String) Assign.getPlayerUltimate().getSelectedItem();
				UltimateAttack y = null;
				for (int i = 0; i < game.getPlayer().getUltimateAttacks().size(); i++) {
					if (x.equals(game.getPlayer().getUltimateAttacks().get(i).getName())) {
						y = game.getPlayer().getUltimateAttacks().get(i);
						break;
					}
				}
				try {
					game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), y, null);
				} catch (DuplicateAttackException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				} catch (MaximumAttacksLearnedException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				} catch (NotASaiyanException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				All.validate();
				All.repaint();
				return;
			}
			if (Assign.getReplaceU().equals(play)) {
				String x = (String) Assign.getPlayerUltimate().getSelectedItem();
				String z = (String) Assign.getFoeUltimate().getSelectedItem();
				UltimateAttack y = null;
				UltimateAttack l = null;
				for (int i = 0; i < game.getPlayer().getUltimateAttacks().size(); i++) {
					if (x.equals(game.getPlayer().getUltimateAttacks().get(i).getName())) {
						y = game.getPlayer().getUltimateAttacks().get(i);
						break;
					}
				}
				for (int i = 0; i < game.getPlayer().getActiveFighter().getUltimateAttacks().size(); i++) {
					if (z.equals(game.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName())) {
						l = game.getPlayer().getActiveFighter().getUltimateAttacks().get(i);
						break;
					}
				}
				try {
					game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), y, l);
				} catch (DuplicateAttackException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				} catch (MaximumAttacksLearnedException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				} catch (NotASaiyanException e1) {
					JTextArea f = new JTextArea();
					f.setText(e1.getMessage());
					f.setOpaque(false);
					f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, f);
				}
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				All.validate();
				All.repaint();
				return;
			}
		} else if (All.getContentPane() instanceof DragonView) {
			if (Dragon.getSenzuBeans().equals(play)) {
				game.getPlayer().chooseWish(this.getY().getWishes()[0]);
				this.getMapView().addPlayerInfo(game.getPlayer());
				// this.getMapView().addFighterInfo(game.getPlayer().getActiveFighter());
				FirstWish.dispose();
				All.setContentPane(this.getMapView());
				return;
			}
			if (Dragon.getAbilityPoints().equals(play)) {
				game.getPlayer().chooseWish(this.getY().getWishes()[1]);
				game.getPlayer().setDragonBalls(0);
				this.getMapView().addPlayerInfo(game.getPlayer());
				this.getMapView().addFighterInfo(game.getPlayer().getActiveFighter());
				SecondWish.dispose();
				All.setContentPane(this.getMapView());
				return;
			}
			if (Dragon.getSuperAttack().equals(play)) {
				game.getPlayer().chooseWish(this.getY().getWishes()[2]);
				ThirdWish.dispose();
				this.getMapView().addPlayerInfo(game.getPlayer());
				All.setContentPane(this.getMapView());
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				return;
			}
			if (Dragon.getUltimateAttack().equals(play)) {
				game.getPlayer().chooseWish(this.getY().getWishes()[3]);
				FourthWish.dispose();
				this.getMapView().addPlayerInfo(game.getPlayer());
				All.setContentPane(this.getMapView());
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				return;
			}
		}
		if (collects.getCollect().equals(play)) {
			collects.dispose();
			MapView.addPlayerInfo(game.getPlayer());
			return;
		}
		if (collectss.getCollect().equals(play)) {
			collectss.dispose();
			MapView.addPlayerInfo(game.getPlayer());
			return;
		}

		if (Wohoo.getOk().equals(play)) {
			Wohoo.dispose();
			return;
		}

		if (Lost.getOk().equals(play)) {
			Lost.dispose();
			return;
		}

		if (AttackS.getAttacking().equals(play)) {
			String y = (String) AttackS.getS().getSelectedItem();
			SuperAttack z = null;
			for (int i = 0; i < game.getPlayer().getActiveFighter().getSuperAttacks().size(); i++) {
				if (y.equals(game.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName())) {
					z = game.getPlayer().getActiveFighter().getSuperAttacks().get(i);
					break;
				}
			}
			AttackS.dispose();
			try {
				this.getCurrentBattle().attack(z);
			} catch (NotEnoughKiException e1) {
				JTextArea f = new JTextArea();
				f.setText(e1.getMessage());
				f.setOpaque(false);
				f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, f);
			}
			return;
		}
		if (AttackS.getClose().equals(play)) {
			AttackS.dispose();
			All.validate();
			All.repaint();
		}
		if (AttackU.getAttacking().equals(play)) {
			String y = (String) AttackU.getU().getSelectedItem();
			UltimateAttack z = null;
			for (int i = 0; i < game.getPlayer().getActiveFighter().getUltimateAttacks().size(); i++) {
				if (y.equals(game.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName())) {
					z = game.getPlayer().getActiveFighter().getUltimateAttacks().get(i);
					break;
				}
			}
			AttackU.dispose();
			try {
				this.getCurrentBattle().attack(z);
			} catch (NotEnoughKiException e1) {
				JTextArea f = new JTextArea();
				f.setText(e1.getMessage());
				f.setOpaque(false);
				f.setFont(new Font("Breathe Fire", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, f);
			}
			return;
		}
		if (AttackU.getClose().equals(play)) {
			AttackU.dispose();
			All.validate();
			All.repaint();
			return;
		}
		return;
	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		FirstWish.addDInfo(dragon);
		SecondWish.addDInfo(dragon);
		ThirdWish.addDInfo(dragon);
		FourthWish.addDInfo(dragon);
		this.setY(dragon);
		All.setContentPane(Dragon);
		All.repaint();
		All.validate();
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		if (collectible == Collectible.SENZU_BEAN) {
			collects.setVisible(true);
		}
		if (collectible == Collectible.DRAGON_BALL) {
			if (game.getPlayer().getDragonBalls() < 7)
				collectss.setVisible(true);
		}
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		this.setCurrentBattle((Battle) e.getSource());
		if (e.getType().equals(BattleEventType.STARTED)) {
			BattleView.addActiveFighterInfo(game.getPlayer());
			BattleView.addFoeInfo((NonPlayableFighter) ((Battle) e.getSource()).getFoe());
			if (game.getPlayer().getActiveFighter() instanceof Earthling) {
				BattleView.getMyPic().setIcon(new ImageIcon("krillin.gif"));
			}
			if (game.getPlayer().getActiveFighter() instanceof Frieza) {
				BattleView.getMyPic().setIcon(new ImageIcon("frieza.gif"));
			}
			if (game.getPlayer().getActiveFighter() instanceof Majin) {
				BattleView.getMyPic().setIcon(new ImageIcon("buu.gif"));
			}
			if (game.getPlayer().getActiveFighter() instanceof Namekian) {
				BattleView.getMyPic().setIcon(new ImageIcon("tumblr_nd9f9icNf71tp8kdpo1_500.gif"));
			}
			if (game.getPlayer().getActiveFighter() instanceof Saiyan) {
				BattleView.getMyPic().setIcon(new ImageIcon("goku.gif"));
			}
			BattleView.getMyHealthBar().setMaximum(game.getPlayer().getActiveFighter().getMaxHealthPoints());
			BattleView.getMyKiBar().setMaximum(game.getPlayer().getActiveFighter().getMaxKi());
			BattleView.getMyStaminaBar().setMaximum(game.getPlayer().getActiveFighter().getMaxStamina());
			BattleView.getFoeHealthBar()
					.setMaximum(((NonPlayableFighter) (this.getCurrentBattle().getFoe())).getMaxHealthPoints());
			BattleView.getFoeKiBar().setMaximum(((NonPlayableFighter) (this.getCurrentBattle().getFoe())).getMaxKi());
			BattleView.getFoeStaminaBar()
					.setMaximum(((NonPlayableFighter) (this.getCurrentBattle().getFoe())).getMaxStamina());
			ImageIcon f10 = new ImageIcon("dragon-ball-z-battle-of-z-vegeta-great-ape-artwork.png");
			ImageIcon f1 = new ImageIcon("e8832f0079883b10c14c8c165c9893b7.png");
			ImageIcon f2 = new ImageIcon("Kid_Buu_Dragon_Ball_Z.png");
			ImageIcon f3 = new ImageIcon("Raditz_for_Saiyanelite.png");
			ImageIcon f4 = new ImageIcon("Render_Dragon_Ball_Z_Trunks_Do_Future_by_zat_renders.png");
			ImageIcon f5 = new ImageIcon("renders_dragon_ball_z_by_elnenecool-d49k50i.png");
			ImageIcon f6 = new ImageIcon("Android_17.png");
			ImageIcon f7 = new ImageIcon("Cooler_Dragon_Ball_Z.png");
			ImageIcon f8 = new ImageIcon("card_1000640_character.png");
			ImageIcon f9 = new ImageIcon("Cell_Super_Perfect_Form_Dragon_Ball_Z.png");
			ImageIcon f0 = new ImageIcon("dragon-ball-z-battle-of-z-vegeta-artwork.png");
			ImageIcon f11 = new ImageIcon("Raditz_for_Saiyanelite.png");
			ImageIcon f12 = new ImageIcon("Tien.png");
			ImageIcon f13 = new ImageIcon(
					"[large][AnimePaper]scans_Dragon-Ball-Z_liraooa(0.75)__THISRES__168596-723027.png");

			if (!(((NonPlayableFighter) ((Battle) e.getSource()).getFoe()).isStrong())) {
				switch (i) {
				case 0:
					BattleView.getFoePic().setIcon(f0);
					break;
				case 1:
					BattleView.getFoePic().setIcon(f1);
					break;
				case 2:
					BattleView.getFoePic().setIcon(f2);
					break;
				case 3:
					BattleView.getFoePic().setIcon(f3);
					break;
				case 4:
					BattleView.getFoePic().setIcon(f4);
					break;
				case 5:
					BattleView.getFoePic().setIcon(f5);
					break;
				case 6:
					BattleView.getFoePic().setIcon(f6);
					break;
				case 7:
					BattleView.getFoePic().setIcon(f7);
					break;
				case 8:
					BattleView.getFoePic().setIcon(f11);
					break;
				case 9:
					BattleView.getFoePic().setIcon(f12);
					break;
				default:
					BattleView.getFoePic().setIcon(f0);
				}
				i++;
				if (i == 10) {
					i = 0;
				}
			} else {
				switch (j) {
				case 0:
					BattleView.getFoePic().setIcon(f8);
					break;
				case 1:
					BattleView.getFoePic().setIcon(f9);
					break;
				case 2:
					BattleView.getFoePic().setIcon(f10);
					break;
				case 3:
					BattleView.getFoePic().setIcon(f13);
				default:
					BattleView.getFoePic().setIcon(f8);
				}
				j++;
				if (j == 4) {
					j = 0;
				}
			}
			BattleView.getTurn().setText("It's Your Turn");
			BattleView.updateAction(" ");
			All.setContentPane(BattleView);
			All.repaint();
			All.validate();
		}
		if (e.getType().equals(BattleEventType.NEW_TURN)) {
			NonPlayableFighter F = ((NonPlayableFighter) (this.getCurrentBattle().getFoe()));
			PlayableFighter P = game.getPlayer().getActiveFighter();
			// BattleView.addFoeKS((NonPlayableFighter) ((Battle)
			// e.getSource()).getFoe());
			// BattleView.addMyKs(game.getPlayer());
			BattleView.getMyHealthBar().setValue(P.getHealthPoints());
			BattleView.getMyHealthBar().setString("HP : " + P.getHealthPoints() + "/" + P.getMaxHealthPoints());
			BattleView.getMyKiBar().setValue(P.getKi());
			BattleView.getMyKiBar().setString("KI : " + P.getKi() + "/" + P.getMaxKi());
			BattleView.getMyStaminaBar().setValue(P.getStamina());
			BattleView.getMyStaminaBar().setString("Stamina : " + P.getStamina() + "/" + P.getMaxStamina());
			BattleView.getFoeHealthBar().setValue(F.getMaxHealthPoints() - F.getHealthPoints());
			BattleView.getFoeHealthBar().setString("HP : " + F.getHealthPoints() + "/" + F.getMaxHealthPoints());
			BattleView.getFoeKiBar().setValue(F.getMaxKi() - F.getKi());
			BattleView.getFoeKiBar().setString("KI : " + F.getKi() + "/" + F.getMaxKi());
			BattleView.getFoeStaminaBar().setValue(F.getMaxStamina() - F.getStamina());
			BattleView.getFoeStaminaBar().setString("Stamina : " + F.getStamina() + "/" + F.getMaxStamina());
			if (this.getCurrentBattle().getAttacker().equals(this.getCurrentBattle().getMe())) {
				BattleView.getUse().setEnabled(true);
				BattleView.getBlock().setEnabled(true);
				BattleView.getMyPhysicalAttack().setEnabled(true);
				BattleView.getMySuperAttack().setEnabled(true);
				BattleView.getMyUltimateAttack().setEnabled(true);
				BattleView.getTurn().setText("It's Your Turn");
			} else {
				BattleView.getUse().setEnabled(false);
				BattleView.getBlock().setEnabled(false);
				BattleView.getMyPhysicalAttack().setEnabled(false);
				BattleView.getMySuperAttack().setEnabled(false);
				BattleView.getMyUltimateAttack().setEnabled(false);
				BattleView.getTurn().setText("It's Your Turn");
				BattleView.getTurn().setText("It's Foe's Turn");
			}
			if (e.getCurrentOpponent().equals(this.getCurrentBattle().getFoe())) {
				Timer T = new Timer(2000, new PlayFoe(this.getCurrentBattle()));
				T.setRepeats(false);
				T.start();
			}
			All.validate();
			All.repaint();
		}
		if (e.getType() == BattleEventType.ATTACK) {
			if (e.getCurrentOpponent().equals(this.getCurrentBattle().getMe())) {
				BattleView.updateAction("You made an Attack ;)");
			} else {
				BattleView.updateAction("Foe made an Attack :(");
			}
		}
		if (e.getType() == BattleEventType.USE) {
			BattleView.updateAction("You used a senzuBean,Oh Wow look at your HP!!!");
		}
		if (e.getType() == BattleEventType.BLOCK) {
			if (e.getCurrentOpponent().equals(this.getCurrentBattle().getMe())) {
				BattleView.updateAction("You Blocked the Beast ;)");
			} else {
				BattleView.updateAction("Foe Blocked 8:)");
			}
		}
		if (e.getType().equals(BattleEventType.ENDED)) {
			if (e.getWinner().equals(this.getCurrentBattle().getMe())) {
				Assign.updateMyS(game.getPlayer());
				Assign.updateMyU(game.getPlayer());
				Assign.updateFoeS(game.getPlayer().getActiveFighter());
				Assign.updateFoeU(game.getPlayer().getActiveFighter());
				if (((NonPlayableFighter) ((Battle) e.getSource()).getFoe()).isStrong()) {
					String x ="";
					x+="                  CONGRATULATIONZZZZZZ" + '\n' ;
					x+= "           YOU HAVE WON THE BIG BATTLE" +'\n';
					x+= " A NEW MAP IS GENERATED WITH STRONGER FOES" +'\n';
					x+="     CHECK ASSIGN ATTACK IT'S AWESOME NOW" +'\n' ;
					x+= "            ENJOoOoOoOoOoOoOoY ;) ;)" ;
					Wohoo.getMessage().setText(x);
					Wohoo.setVisible(true);
				}
				else {
					String x ="";
					x+="               CONGRATULATIONS" + '\n' ;
					x+= "           YOU HAVE WON THE BATTLE" +'\n';
					x+= "            CHECK ASSIGN ATTACK" +'\n';
					x+= "U CAN GAIN YOUR ENEMY'S POWERFUL ATTACKS" ;
					Wohoo.getMessage().setText(x);
					Wohoo.setVisible(true);
				}
			}
			else {
				Lost.setVisible(true);
			}
			this.drawMap();
			this.getMapView().addFighterInfo(game.getPlayer().getActiveFighter());
			this.getMapView().addPlayerInfo(game.getPlayer());
			All.setContentPane(this.getMapView());
			All.revalidate();
			All.repaint();
		}

	}

	public Game getGame() {
		return game;
	}

	public Battle getCurrentBattle() {
		return CurrentBattle;
	}

	public void setCurrentBattle(Battle currentBattle) {
		CurrentBattle = currentBattle;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	// public static void LetsRock() {
	// AudioPlayer MGP = AudioPlayer.player;
	// AudioStream BGM;
	// AudioData MD;
	//
	// ContinuousAudioDataStream loop = null;
	//
	// try {
	// InputStream test = new
	// FileInputStream("dragon+ball+z+arabic+opening+song.mp3");
	// BGM = new AudioStream(test);
	// AudioPlayer.player.start(BGM);
	// MD = BGM.getData();
	// loop = new ContinuousAudioDataStream(MD);
	//
	// } catch (FileNotFoundException e) {
	// System.out.print(e.toString());
	// } catch (IOException error) {
	// System.out.print(error.toString());
	// }
	// MGP.start(loop);
	//
	// }

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			// System.out.println("tttttttt");
			game.getWorld().moveLeft();
			this.drawMap();
			All.repaint();
			All.validate();
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			// System.out.println("tttttttt");
			game.getWorld().moveRight();
			this.drawMap();
			All.repaint();
			All.validate();
		}
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			// System.out.println("tttttttt");
			game.getWorld().moveUp();
			this.drawMap();
			All.repaint();
			All.validate();
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			// System.out.println("tttttttt");
			game.getWorld().moveDown();
			this.drawMap();
			All.repaint();
			All.validate();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource().equals(New.getStartGame())) {
			New.getStartGame().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(New.getLoadGame())) {
			New.getLoadGame().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(MapView.getCF())) {
			MapView.getCF().setForeground(Color.RED);
		}
		if (arg0.getSource().equals(MapView.getSF())) {
			MapView.getSF().setForeground(Color.BLUE);
		}
		if (arg0.getSource().equals(MapView.getASS())) {
			MapView.getASS().setForeground(Color.GREEN);
		}
		if (arg0.getSource().equals(MapView.getUPF())) {
			MapView.getUPF().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFH())) {
			UpgradeFighter.getUPFH().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFBD())) {
			UpgradeFighter.getUPFBD().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFPD())) {
			UpgradeFighter.getUPFPD().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFMS())) {
			UpgradeFighter.getUPFMS().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFMK())) {
			UpgradeFighter.getUPFMK().setForeground(Color.ORANGE);
		}

		if (arg0.getSource().equals(StartMode.getEarthling())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Earthling("Ay 7aga"));
			FI.setBounds(50, 130, 290, 160);
			FI.setVisible(true);
			StartMode.getE().setForeground(Color.ORANGE);
		}

		if (arg0.getSource().equals(StartMode.getFrieza())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Frieza("Ay 7aga"));
			FI.setBounds(270, 130, 290, 160);
			FI.setVisible(true);
			StartMode.getF().setForeground(Color.ORANGE);

		}

		if (arg0.getSource().equals(StartMode.getMajin())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Majin("Ay 7aga"));
			FI.setBounds(530, 130, 290, 160);
			FI.setVisible(true);
			StartMode.getM().setForeground(Color.ORANGE);
		}

		if (arg0.getSource().equals(StartMode.getNamekian())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Namekian("Ay 7aga"));
			FI.setBounds(840, 130, 290, 160);
			FI.setVisible(true);
			StartMode.getN().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(StartMode.getSaiyan())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Saiyan("Ay 7aga"));
			FI.setBounds(1080, 130, 290, 160);
			FI.setVisible(true);
			StartMode.getS().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(CreateFighter.getEarthling())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Earthling("Ay 7aga"));
			FI.setBounds(50, 130, 290, 160);
			FI.setVisible(true);
			CreateFighter.getE().setForeground(Color.ORANGE);
		}

		if (arg0.getSource().equals(CreateFighter.getFrieza())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Frieza("Ay 7aga"));
			FI.setBounds(270, 130, 290, 160);
			FI.setVisible(true);
			CreateFighter.getF().setForeground(Color.ORANGE);
		}

		if (arg0.getSource().equals(CreateFighter.getMajin())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Majin("Ay 7aga"));
			FI.setBounds(530, 130, 290, 160);
			FI.setVisible(true);
			CreateFighter.getM().setForeground(Color.ORANGE);
		}

		if (arg0.getSource().equals(CreateFighter.getNamekian())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Namekian("Ay 7aga"));
			FI.setBounds(840, 130, 290, 160);
			FI.setVisible(true);
			CreateFighter.getN().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(CreateFighter.getSaiyan())) {
			FI = new ActiveFighterInfo();
			FI.addInfo(new Saiyan("Ay 7aga"));
			FI.setBounds(1080, 130, 290, 160);
			FI.setVisible(true);
			CreateFighter.getS().setForeground(Color.ORANGE);
		}
		if (arg0.getSource().equals(BattleView.getUse())) {
			BattleView.getUse().setForeground(Color.GREEN);
		}
		if (arg0.getSource().equals(BattleView.getBlock())) {
			BattleView.getBlock().setForeground(Color.GREEN);
		}
		if (arg0.getSource().equals(BattleView.getMyPhysicalAttack())) {
			BattleView.getMyPhysicalAttack().setForeground(Color.GREEN);
		}
		if (arg0.getSource().equals(BattleView.getMySuperAttack())) {
			BattleView.getMySuperAttack().setForeground(Color.GREEN);
		}
		if (arg0.getSource().equals(BattleView.getMyUltimateAttack())) {
			BattleView.getMyUltimateAttack().setForeground(Color.GREEN);
		}
		if (arg0.getSource().equals(Dragon.getSenzuBeans())) {
			FirstWish.setBounds(70, 430, 300, 120);
			// FirstWish.getGround().setBounds(70, 445, 300, 100 );
			// FirstWish.getInfo().setBounds(80, 545, 300, 100 );
			FirstWish.setVisible(true);
		}
		if (arg0.getSource().equals(Dragon.getAbilityPoints())) {
			SecondWish.setBounds(390, 430, 300, 120);
			SecondWish.setVisible(true);
		}
		if (arg0.getSource().equals(Dragon.getSuperAttack())) {
			ThirdWish.setBounds(710, 430, 300, 120);
			ThirdWish.setVisible(true);
		}
		if (arg0.getSource().equals(Dragon.getUltimateAttack())) {
			FourthWish.setBounds(1020, 430, 330, 120);
			FourthWish.setVisible(true);
		}
		All.repaint();
		All.validate();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource().equals(New.getStartGame())) {
			New.getStartGame().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(New.getLoadGame())) {
			New.getLoadGame().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(MapView.getCF())) {
			MapView.getCF().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(MapView.getSF())) {
			MapView.getSF().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(MapView.getASS())) {
			MapView.getASS().setForeground(Color.WHITE);
		}
		// if (arg0.getSource().equals(MapView.getASU())) {
		// MapView.getASU().setForeground(Color.WHITE);
		// }
		if (arg0.getSource().equals(MapView.getUPF())) {
			MapView.getUPF().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFH())) {
			UpgradeFighter.getUPFH().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFBD())) {
			UpgradeFighter.getUPFBD().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFPD())) {
			UpgradeFighter.getUPFPD().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFMS())) {
			UpgradeFighter.getUPFMS().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(UpgradeFighter.getUPFMK())) {
			UpgradeFighter.getUPFMK().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(StartMode.getEarthling())) {
			FI.dispose();
			StartMode.getE().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(StartMode.getFrieza())) {
			FI.dispose();
			StartMode.getF().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(StartMode.getMajin())) {
			FI.dispose();
			StartMode.getM().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(StartMode.getNamekian())) {
			FI.dispose();
			StartMode.getN().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(StartMode.getSaiyan())) {
			FI.dispose();
			StartMode.getS().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(CreateFighter.getEarthling())) {
			FI.dispose();
			CreateFighter.getE().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(CreateFighter.getFrieza())) {
			FI.dispose();
			CreateFighter.getF().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(CreateFighter.getMajin())) {
			FI.dispose();
			CreateFighter.getM().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(CreateFighter.getNamekian())) {
			FI.dispose();
			CreateFighter.getN().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(CreateFighter.getSaiyan())) {
			FI.dispose();
			CreateFighter.getS().setForeground(Color.WHITE);
			// StartMode.getEarthling().setIcon(new ImageIcon("earthling
			// 2.png"));
		}
		if (arg0.getSource().equals(BattleView.getUse())) {
			BattleView.getUse().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(BattleView.getBlock())) {
			BattleView.getBlock().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(BattleView.getMyPhysicalAttack())) {
			BattleView.getMyPhysicalAttack().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(BattleView.getMySuperAttack())) {
			BattleView.getMySuperAttack().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(BattleView.getMyUltimateAttack())) {
			BattleView.getMyUltimateAttack().setForeground(Color.WHITE);
		}
		if (arg0.getSource().equals(Dragon.getSenzuBeans())) {
			// FirstWish = new Senzu();
			// FirstWish.setBounds(200, 200, 300, 100);
			FirstWish.dispose();
		}
		if (arg0.getSource().equals(Dragon.getAbilityPoints())) {
			// SecondWish = new Ability();
			// SecondWish.setBounds(200, 200, 300, 100);
			SecondWish.dispose();
		}
		if (arg0.getSource().equals(Dragon.getSuperAttack())) {
			// ThirdWish = new Super();
			// ThirdWish.setBounds(200, 200, 300, 100);
			ThirdWish.dispose();
		}
		if (arg0.getSource().equals(Dragon.getUltimateAttack())) {
			// FourthWish = new Ultimate();
			// FourthWish.setBounds(200, 200, 300, 100);
			FourthWish.dispose();
		}
		All.repaint();
		All.validate();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	public void drawMap() {
		this.getMapView().getMap().removeAll();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 && j == 0) {
					JButton boss = new JButton();
					boss.setIcon(new ImageIcon("rsz_evil_goku_by_gokugarlic-d4ab7uy.png"));
					boss.setContentAreaFilled(false);
					boss.addKeyListener(this);
					// boss.addActionListener(this);
					boss.setVisible(true);
					// boss.setEnabled(false);
					this.getMapView().getMap().add(boss);
				} else {
					if (i == game.getWorld().getPlayerRow() && j == game.getWorld().getPlayerColumn()) {
						JButton d = new JButton();

						d.addKeyListener(this);
						if (game.getPlayer().getActiveFighter() instanceof Earthling) {
							d.setIcon(new ImageIcon("rsz_earthling_2 (1).png"));

						}
						if (game.getPlayer().getActiveFighter() instanceof Frieza) {
							d.setIcon(new ImageIcon("rsz_1friza_1.png"));

						}
						if (game.getPlayer().getActiveFighter() instanceof Majin) {
							d.setIcon(new ImageIcon("rsz_rsz_majin.png"));

						}
						if (game.getPlayer().getActiveFighter() instanceof Namekian) {
							d.setIcon(new ImageIcon("rsz_namickan (1).png"));

						}
						if (game.getPlayer().getActiveFighter() instanceof Saiyan) {
							d.setIcon(new ImageIcon("rsz_saiyan.png"));

						}
						d.setVisible(true);
						d.setContentAreaFilled(false);
						// d.addActionListener(this);
						// d.setEnabled(false);
						this.getMapView().getMap().add(d);
					} else {
						JButton c = new JButton();
						// c.addActionListener(this);
						// c.addKeyListener(this);
						c.addKeyListener(this);
						c.setFocusable(true);
						c.requestFocusInWindow();
						c.setContentAreaFilled(false);
//						c.setText(game.getWorld().getMap()[i][j].toString());
						c.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
						c.setForeground(Color.WHITE);
						c.setBorder(new LineBorder(Color.WHITE));
						c.setVisible(true);
						// c.setEnabled(false);
						this.getMapView().getMap().add(c);
					}
				}
			}
		}
		this.setMapView(this.getMapView());
	}

	public WorldMapView getMapView() {
		return MapView;
	}

	public void setMapView(WorldMapView mapView) {
		MapView = mapView;
	}

	public PlayableFighter getX() {
		return X;
	}

	public void setX(PlayableFighter x) {
		X = x;
	}

	public Dragon getY() {
		return Y;
	}

	public void setY(Dragon y) {
		Y = y;
	}

	public static void main(String[] args) throws IOException {
		new DragonBallGUI();
	}

}
