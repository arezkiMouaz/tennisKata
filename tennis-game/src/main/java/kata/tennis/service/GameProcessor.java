package kata.tennis.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import kata.tennis.model.ITennisGame;
import kata.tennis.model.Player;


public class GameProcessor extends ScoreProcessor{

	
	public static int SCORE_TO_WIN_GAME=40;
	
	
	public GameProcessor(ITennisGame gameArg){
       super(gameArg);
}
	public static List<Integer> SCORES = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 15, 30, 40}));
	
	@Override
    public void process(Player playerOne, Player playerTwo){
       
        int currentScore = playerOne.getGameScore().getScore();
        int newScore = incrementScore(currentScore);
        if (currentScore==SCORE_TO_WIN_GAME) {
        	//get the opponent score and check if it is different from 40
            if (playerTwo.getGameScore().getScore()!=SCORE_TO_WIN_GAME){
                game.winTheGame(playerOne.getName());
            }
            //check if player is deuce to make him winner
            else if (game.isPlayerDeuce(playerOne.getName())) {
                game.winTheGame(playerOne.getName());
            } else
            	//choose the deuce between player one and his opponent
				chooseTheDeucePlayer(playerOne, playerTwo);
        }else
            game.setPlayerGameScore(playerOne, newScore);

    }
	
	private void chooseTheDeucePlayer(Player playerOne, Player playerTwo) {
		if (!game.isPlayerDeuce(playerTwo.getName())) {
		    game.setPlayerDeuce(playerOne, true);
		    game.setPlayerDeuce(playerTwo, false);
		    
		}else{
		    game.setPlayerDeuce(playerTwo, false);
		    
		}
	}
@Override
    protected int incrementScore(int score){
        int index = SCORES.indexOf(score);
        if ( index < SCORES.size()-1 )
            return SCORES.get(index+1);
        return SCORES.get(index);
}
	public ITennisGame getGame() {
		return game;
	}

	public void setGame(ITennisGame game) {
		this.game = game;
	}
	

	
	
}
