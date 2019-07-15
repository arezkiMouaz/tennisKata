package kata.tennis.service;

import kata.tennis.model.ITennisGame;
import kata.tennis.model.Player;

public abstract class ScoreProcessor {

	protected ITennisGame game;

    public ScoreProcessor(ITennisGame game) {
		super();
		this.game = game;
	}

	public abstract void process(Player playerOne, Player playerTwo);

protected abstract int incrementScore(int score);
}
