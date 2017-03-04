package dragonball.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dragonball.model.battle.Battle;
import dragonball.model.exceptions.NotEnoughKiException;
import javax.swing.Timer;

public class PlayFoe implements ActionListener {

	Battle B ;
	public PlayFoe(Battle C){
		B = C ;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
   		try {
			B.play();
		} catch (NotEnoughKiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		((Timer)arg0.getSource()).stop();
	}

}
