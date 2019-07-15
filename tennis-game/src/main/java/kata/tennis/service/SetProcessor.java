package kata.tennis.service;

import kata.tennis.model.ITennisGame;
import kata.tennis.model.Player;


public class SetProcessor extends ScoreProcessor{

	
	
	public static int SCORE_TO_WIN_SET=6;	
	public static int LOWER_SET_SCORE=4;
	public static int SCORE_WIN_SET_REPLAY=7;
	public static int TIEBREAK_DIFFERENCE_TO_WIN=2;
	
	public SetProcessor(ITennisGame gameArg){
       super(gameArg);
}

	
	
	public ITennisGame getGame() {
		return game;
	}

	public void setGame(ITennisGame game) {
		this.game = game;
	}



	@Override
	public void process(Player playerOne, Player playerTwo) {
		
        int currentScore = game.getPlayerSetScore(playerOne.getName());
        int newScore = incrementScore(currentScore);
        if ( newScore >= SCORE_TO_WIN_SET ) {
            if (game.getPlayerSetScore(playerTwo.getName()) <=LOWER_SET_SCORE ) {
                game.winTheSet(playerOne.getName());
                game.setPlayerSetScore( playerOne, newScore );
            }else if (currentScore>=SCORE_TO_WIN_SET && game.getPlayerSetScore(playerTwo.getName())>=SCORE_TO_WIN_SET) {
                game.setPlayerTieBreakScore(playerOne.getName(), game.getPlayerTieBreakScore(playerOne.getName()) + 1);
                //choose match and set winner if player one tieBreak greater or equal to 7 
                //and the difference between the tieBreak score between player is greater than 2
                chooseMatchAndSetWinner(playerOne, playerTwo);
            }else
                game.setPlayerSetScore( playerOne, newScore );
        }else
            game.setPlayerSetScore( playerOne, newScore );
      

		
	}



	private void chooseMatchAndSetWinner(Player playerOne, Player playerTwo) {
		if (game.getPlayerTieBreakScore(playerTwo.getName())>=SCORE_WIN_SET_REPLAY
				&& game.getPlayerTieBreakScore(playerOne.getName())-game.getPlayerTieBreakScore(playerTwo.getName())>TIEBREAK_DIFFERENCE_TO_WIN){
		    game.winTheSet(playerOne.getName());
		    game.winTheMatch(playerOne.getName());
		}
	}



	@Override
	protected int incrementScore(int score) {
		 return score+1;
	}
	
}
