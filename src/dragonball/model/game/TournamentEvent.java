package dragonball.model.game;

import java.util.EventObject;

import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleOpponent;

public class TournamentEvent extends EventObject {
	public TournamentEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	private Battle currentBattle;
	private BattleOpponent tournamentWinner;
	private Tournament tournament;
	private BattleOpponent currentBattleWinner;
	private TournamentEventType type;

}
