package dragonball.model.game;

import java.util.ArrayList;
import java.util.Random;

import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.character.fighter.Fighter;

public class Tournament {
	private ArrayList<Fighter> firstRound;
	private ArrayList<Fighter> secondRound;
	private ArrayList<Fighter> thirdRound;
	private ArrayList<Fighter> finalMatch;
	private ArrayList<Fighter> currentRound;
	private int nextBattle;
	
	public Tournament(ArrayList<Fighter> fighters,Game game){
		while(fighters.size()<16){
			fighters.add(game.getStrongFoes().get(new Random().nextInt(game.getStrongFoes().size())));
		}
		firstRound=new ArrayList<>();
		secondRound=new ArrayList<>();
		thirdRound=new ArrayList<>();
		finalMatch=new ArrayList<>();
		while(firstRound.size()<16){
			firstRound.add(fighters.get(new Random().nextInt(16)));
		}
		currentRound=firstRound;
	}
//	public Battle nextBattle(){
//		new Battle(currentRound.get(nextBattle), currentRound.get(nextBattle+1));
//		nextBattle+=2;
//		if(nextBattle>=currentRound.size()){
//			currentRound=null;
//			
//		}
//	}
	public void battleEnded(BattleEvent e){
		if(e.getType()==BattleEventType.ENDED){
			if(currentRound==firstRound){
				secondRound.add((Fighter) e.getWinner());
			}
			else if(currentRound==secondRound){
				thirdRound.add((Fighter) e.getWinner());
			}
			else if(currentRound==thirdRound){
				finalMatch.add((Fighter) e.getWinner());
			}
			else if(currentRound==finalMatch){
				
			}
			
		}
	}
}
